package core.models

import core.average
import core.processors.Binarization
import utils.debug.LogConsole
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class Graph(file: File) {
	val image: BufferedImage
	val cache: BufferedImage
	val mark: Array<Array<Boolean>>

	var pointCache = Point(0, 0)

	val getColor: (Int, Int) -> Boolean = { x, y ->
//		LogConsole.log("x = $x, y = $y, color = ${this[x, y]}")
		this@Graph[x, y]
	}

	init {
		image = ImageIO.read(file)
		cache = ImageIO.read(file)
		LogConsole.log("width = ${cache.width}, height = ${cache.height}")
		mark = Array(cache.width, { Array(cache.height, { false }) })
		init()
	}

	fun init() {
		(0..image.width - 1).forEach { x ->
			(0..image.height - 1).forEach { y ->
				image.setRGB(x, y, color(x, y))
				mark[x][y] = this[x, y]
			}
		}
	}

	operator fun plusAssign(point: Point) {
		if (pointCache connect point) LogConsole.log("Yes!! Connected!!")
		else LogConsole.log("Not connected!!")
		val line = Line(pointCache, point)
		(pointCache.x..point.x).forEach { x ->
			image.setRGB(x, line.longitude(x).toInt(), Color.BLUE.rgb)
		}
		pointCache = point
		pointCache.getColor = getColor
	}

	/**
	 * @param x pointCache in image
	 * @param y y in image
	 * @return black or white
	 */
	private fun color(x: Int, y: Int) = if (this[x, y]) Color.WHITE.rgb else Color.BLACK.rgb

	/** @return True is black, False is white */
	operator fun get(x: Int, y: Int) = Binarization.gray(cache.getRGB(x, y)) > average

}
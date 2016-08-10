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
				image.setRGB(x, y, if (this[x, y]) Color.WHITE.rgb else Color.BLACK.rgb)
				mark[x][y] = this[x, y]
			}
		}
	}

	/**
	 * @param point send a clicked point
	 * @return connected
	 */
	fun send(point: Point): Boolean {
		val ret = pointCache connect point
		drawLine(Line(pointCache, point))
		pointCache = point
		return ret
	}

	fun drawLine(line: Line) {
		line.allPoints().forEach { p ->
			image.setRGB(p.x, p.y, if (this[p.x, p.y]) Color.BLUE.rgb else Color.ORANGE.rgb)
		}
	}

	/** 判断两点是否连通 (｡ŏ﹏ŏ) */
	private infix fun Point.connect(point: Point): Boolean {
		Line(this, point).allPoints().forEach { p -> if (this@Graph[p.x, p.y]) return false }
		return true
	}

	/** @return True is white, False is black */
	operator fun get(x: Int, y: Int) = Binarization.gray(cache.getRGB(x, y)) > average
}

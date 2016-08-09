package core.models

import core.average
import core.processors.BinaryProcessor
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

	init {
		image = ImageIO.read(file)
		cache = ImageIO.read(file)
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

	/** connect */
	fun isConnected(x: Point, y: Point): Boolean {
		val lambda: (Int, Int) -> Boolean = { x, y -> this@Graph[x, y] }
		x.getColor = lambda
		y.getColor = lambda
		return x connect y
	}

	/**
	 * @param x x in image
	 * @param y y in image
	 * @return black or white
	 */
	private fun color(x: Int, y: Int) = if (get(x, y)) Color.WHITE.rgb else Color.BLACK.rgb

	operator fun get(x: Int, y: Int) = BinaryProcessor.getGray(cache.getRGB(x, y)) > average

}
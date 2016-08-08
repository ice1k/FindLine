package core

import core.models.Line
import core.models.Point
import core.processors.BinaryProcessor
import utils.exceptions.LineNotFoundException
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
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
		mark = Array(cache.height, {
			Array(cache.width, { false })
		})
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

	/**
	 * please handle an exception
	 */
	fun findLine(x: Int, y: Int) {
		var line = ArrayList<Line>()
		if (!mark[x][y]) throw LineNotFoundException(x, y)
//		deprecated
//		var max = Max(x, y, -1.0)
//		(-1..1).forEach { x ->
//			(-1..1).forEach { y ->
//				if (x == 0 && y == 0) return
//				var p = Point(x, y)
//
//			}
//		}
	}

	fun findLine(point: Point) = findLine(point.x, point.y)

	/**
	 * @param x x in image
	 * @param y y in image
	 * @return black or white
	 */
	private fun color(x: Int, y: Int) =
			if (get(x, y))
				Color.WHITE.rgb
			else
				Color.BLACK.rgb

	private fun color(point: Point) =
			color(point.x, point.y)

	operator fun get(x: Int, y: Int) =
			BinaryProcessor.getGray(cache.getRGB(x, y)) > average

	operator fun get(point: Point) = this[point.x, point.y]

	private fun isLine(x: Point, y: Point): Boolean {
		// tOdO
		return true
	}

	data class Max(val x: Int, val y: Int, val length: Double)

}
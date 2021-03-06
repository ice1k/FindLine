package ice1000.models

import ice1000.average
import ice1000.utils.Binarization
import ice1000.utils.java.BooleanMap
import java.awt.Color
import java.awt.image.BufferedImage
import java.util.*
import java.util.concurrent.LinkedBlockingQueue

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
abstract class Area(val origin: BufferedImage) {
	val image = BufferedImage(origin.width, origin.height, origin.type)

	fun drawLine(line: Line) = line.set.forEach { point -> draw(point) }

	fun drawTriangle(triangle: Triangle) = triangle.lines().forEach { line -> drawLine(line) }

	fun draw(points: Set<Point>) = points.forEach { p -> draw(p) }

	fun draw(p: Point) = image.setRGB(p.x, p.y, if (this[p.x, p.y]) Color.BLUE.rgb else Color.ORANGE.rgb)

	/** @return True is white, False is black */
	operator fun get(x: Int, y: Int) = Binarization.gray(origin.getRGB(x, y)) > average

	fun init() {
		(0..image.width - 1).forEach { x ->
			(0..image.height - 1).forEach { y ->
				image.setRGB(x, y, if (this[x, y]) Color.WHITE.rgb else Color.BLACK.rgb)
			}
		}
	}

	protected infix fun Point.connect(point: Point): Boolean {
		Line(this, point).set.forEach { p -> if (this@Area[p.x, p.y]) return false }
		return true
	}

	protected fun Point.legal() = x >= 0 && y >= 0 && x < origin.width && y < origin.height

	@Deprecated("Will take too much time") fun getArea(point: Point): Set<Point> {
		val queue = LinkedBlockingQueue<Point>()
		val mark = BooleanMap(origin.width, origin.height)
		val set = HashSet<Point>()
		queue.put(point)
		while (queue.isNotEmpty()) {
			set.add(queue.peek())
			mark[queue.peek().x, queue.peek().y] = true
			queue.addAll(queue.poll().surrounded().filter { p ->
				p.legal() && image.getRGB(p.x, p.y) == Color.BLACK.rgb && !mark[p.x, p.y]
			})
		}
		return set
	}
}
package core.models

import java.util.*

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 *
 * 通过两点构造一条直线
 */
open class Line(start: Point, end: Point) {

	private val a = end.y - start.y
	private val b = start.x - end.x
	private val c = end.x * start.y - start.x * end.y
	val allPoints = HashSet<Point>()

	init {
		(Math.min(start.x, end.x)..Math.max(start.x, end.x)).forEach { x -> allPoints.add(Point(x, x2y(x))) }
		(Math.min(start.y, end.y)..Math.max(start.y, end.y)).forEach { y -> allPoints.add(Point(y2x(y), y)) }
	}

	fun x2y(x: Int) = (a * x + c) * -1 / b
	fun y2x(y: Int) = (b * y + c) * -1 / a

	override operator fun equals(other: Any?): Boolean {
		if (other == null) return false
		if (other is Line) return a / other.a == b / other.b && b / other.b == c / other.c
		return false
	}

	override fun hashCode(): Int {
		var result = a.hashCode()
		result = 31 * result + b.hashCode()
		result = 31 * result + c.hashCode()
		return result
	}
}
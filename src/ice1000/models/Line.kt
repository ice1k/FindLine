package ice1000.models

import java.util.*

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 *
 * 通过两点构造一条直线
 */
open class Line(one: Point, two: Point) {

	private val a = two.y - one.y
	private val b = one.x - two.x
	private val c = two.x * one.y - one.x * two.y
	val set = HashSet<Point>()

	init {
		(Math.min(one.x, two.x)..Math.max(one.x, two.x)).forEach { x -> if (b != 0) set.add(Point(x, x2y(x))) }
		(Math.min(one.y, two.y)..Math.max(one.y, two.y)).forEach { y -> if (a != 0) set.add(Point(y2x(y), y)) }
	}

	fun x2y(x: Int) = -(a * x + c) / b
	fun y2x(y: Int) = -(b * y + c) / a

	override operator fun equals(other: Any?): Boolean {
		if (other == null || other !is Line) return false
		return a / other.a == b / other.b && b / other.b == c / other.c
	}

	override fun hashCode(): Int {
		var result = a.hashCode()
		result = 31 * result + b.hashCode()
		result = 31 * result + c.hashCode()
		return result
	}
}
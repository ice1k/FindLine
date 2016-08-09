package core.models

import core.deviation
import java.util.*

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 *
 * 通过两点构造一条直线
 */
open class Line(val start: Point, val end: Point) {

	private val a = end.y - start.y
	private val b = start.x - end.x
	private val c = end.x * start.y - start.x * end.y

	/** 判断一个点是否在直线上 */
	operator fun get(x: Int, y: Int) = Math.abs(a * x + b * y + c) < deviation

	/** @see get(Int, Int) */
	operator fun get(point: Point) = get(point.x, point.y)

	/** 已知x值求直线上的y值 */
	fun f(x: Int) = (a * x + c) * -1.0 / b

	/** 已知y值求直线上的x值 */
	fun fa(y: Int) = (b * y + c) * -1.0 / a

	/** 获取所有的点 */
	fun getAllPoints(): HashSet<Point> {
		val set = HashSet<Point>()
		set.add(start)
		set.add(end)
		(Math.min(start.x, end.x)..Math.max(start.x, end.x)).forEach { x -> set.add(Point(x, f(x).toInt())) }
		(Math.min(start.y, end.y)..Math.max(start.y, end.y)).forEach { y -> set.add(Point(fa(y).toInt(), y)) }
		return set
	}

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
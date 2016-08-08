package core.models

import core.deviation
import utils.exceptions.FatalError

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
open class Line(
		private val a: Double,
		private val b: Double,
		private val c: Double) {

	companion object {
		fun fromPoint(x: Point, y: Point): Line {
			if (x == y) throw FatalError()
//			TODO
			return Line(0.0, 0.0, 0.0)
		}
	}

	/** 判断一个点在不在方程上 */
	operator fun get(x: Int, y: Int) = Math.abs(bring(x, y)) < deviation

	/** 判断一个点在不在方程上 */
	operator fun get(x: Double, y: Double) = Math.abs(bring(x, y)) < deviation

	/** 判断一个点在不在方程上 */
	operator fun get(point: Point) = get(point.x, point.y)

	/** 将一个点带入直线方程 */
	fun bring(x: Int, y: Int) = a * x + b * y + c

	/** 将一个点带入直线方程 */
	fun bring(x: Double, y: Double) = a * x + b * y + c

	/** 已知x值求直线上的y值 */
	fun longitude(x: Int) = (a * x + c) * -1.0 / b

	/** 已知y值求直线上的x值 */
	fun latitude(y: Int) = (b * y + c) * -1.0 / a

	override operator fun equals(other: Any?): Boolean {
		if (other == null) return false
		if (other is Line) return a == other.a && b == other.b && c == other.b
		return false
	}

	override fun hashCode(): Int {
		var result = a.hashCode()
		result = 31 * result + b.hashCode()
		result = 31 * result + c.hashCode()
		return result
	}
}
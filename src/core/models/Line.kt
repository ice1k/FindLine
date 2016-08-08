package core.models

import core.deviation

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
class Line(val a: Double, val b: Double, val c: Double) {

	/**
	 * is the point located on (x, y) belong to this line
	 */
	operator fun get(x: Double, y: Double) = on(x, y)

	operator fun get(point: Point) =
			get(point.x, point.y)

	fun on(x: Double, y: Double) =
			Math.abs(bring(x, y)) < deviation

	fun bring(x: Double, y: Double) =
			a * x + b * y + c
}
package core.models

import core.deviation

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
class Line(val a: Double, val b: Double, val c: Double) {

	operator fun get(x: Double, y: Double) = on(Point(x, y))

	fun on(point: Point) =
			Math.abs(bring(point)) < deviation

	fun bring(point: Point) =
			a * point.x + b * point.y + c
}
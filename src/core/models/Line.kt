package core.models

import core.deviation

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
class Line(val a: Double, val b: Double, val c: Double) {

	/** is the point located on (x, y) belong to this line */
	operator fun get(x: Int, y: Int) = on(x, y)

	operator fun get(point: Point) = get(point.x, point.y)

	/** 判断一个点在不在方程上 */
	fun on(x: Int, y: Int) = Math.abs(bring(x, y)) < deviation

	/** 将一个点带入直线方程 */
	fun bring(x: Int, y: Int) = a * x + b * y + c
}
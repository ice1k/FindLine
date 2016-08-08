package core.models

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */

fun main(args: Array<String>) {
	println(Point(1.0, 1.0).quadrant)
	println(Point(-1.0, 1.0).quadrant)
	println(Point(-1.0, -1.0).quadrant)
	println(Point(1.0, -1.0).quadrant)
}
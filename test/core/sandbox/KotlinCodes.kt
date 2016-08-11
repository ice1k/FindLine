package core.sandbox

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/11.
 */

infix fun Boolean.exactly(other: Boolean) = this || other

fun main(args: Array<String>) {
	val b = true
	val a = false
	if (a exactly b) println("a exactly b")
}
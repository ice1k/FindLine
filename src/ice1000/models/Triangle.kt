package ice1000.models

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
class Triangle(x: Point, y: Point, z: Point) {
	val a = Line(x, y)
	val b = Line(y, z)
	val c = Line(x, z)

	fun contains(point: Point): Boolean {
		return true
	}

	override fun equals(other: Any?): Boolean {
		if (other == null || other !is Triangle) return false
		if (c != other.c || b != other.b || a != other.a) return false
		return true
	}

	fun lines() = listOf(a, b, c)

	override fun hashCode(): Int {
		var result = a.hashCode()
		result = 31 * result + b.hashCode()
		result = 31 * result + c.hashCode()
		return result
	}
}
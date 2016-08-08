package core.models

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
class Point(val x: Int, val y: Int) {

	var quadrant = 0

	/** 计算象限 */
	init {
		quadrant += if (x >= 0) 1 else 2
		quadrant += if (y >= 0) 0 else 3
		if (quadrant == 5) quadrant = 3
	}

	override fun toString(): String =
			x.toString() + y.toString()

	operator override fun equals(other: Any?): Boolean {
		if (other == null) return false
		if (other is Point) return x == other.x && y == other.y
		return false
	}
}

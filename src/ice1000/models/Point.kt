package ice1000.models

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
data class Point(val x: Int, val y: Int) {

	var quadrant = 0

	/** 计算象限 */
	init {
		quadrant += if (x >= 0) 1 else 2
		quadrant += if (y >= 0) 0 else 3
		if (quadrant == 5) quadrant = 3
	}

	/** 计算两点距离 */
	infix fun distance(p: Point) = Math.sqrt(((p.x - x) * (p.x - x) + (p.y - y) * (p.y - y)).toDouble()).toInt()

	override fun toString() = "( $x, $y )"

	operator override fun equals(other: Any?): Boolean {
		if (other == null || other !is Point) return false
		return x == other.x && y == other.y
	}

	override fun hashCode(): Int {
		var result = x
		result = 31 * result + y
		result = 31 * result + quadrant
		return result
	}
}

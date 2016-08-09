package core.models

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
class Point(val x: Int, val y: Int, internal var getColor: (Int, Int) -> Boolean) {

	constructor(x: Int, y: Int): this(x, y, { b1, b2 -> false })

	var quadrant = 0

	/** 计算象限 */
	init {
		quadrant += if (x >= 0) 1 else 2
		quadrant += if (y >= 0) 0 else 3
		if (quadrant == 5) quadrant = 3
	}

	override fun toString(): String = x.toString() + y.toString()

	/** 判断两点是否连通 (｡ŏ﹏ŏ) */
	infix fun connect(point: Point): Boolean {
		val line = Line(this, point)
		(Math.min(this.x, point.x)..Math.max(this.x, point.x)).forEach { x ->
			if (!getColor(x, line.f(x).toInt())) return false
		}
		(Math.min(this.y, point.y)..Math.max(this.y, point.y)).forEach { y ->
			if (!getColor(line.fa(y).toInt(), y)) return false
		}
		return true
	}

	operator override fun equals(other: Any?): Boolean {
		if (other == null) return false
		if (other is Point) return x == other.x && y == other.y
		return false
	}

	override fun hashCode(): Int {
		var result = x
		result = 31 * result + y
		result = 31 * result + quadrant
		return result
	}
}

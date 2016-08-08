package core.models

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
class Point(val x: Double, val y: Double) {

	var quadrant = 0

	/**
	 * 计算象限
	 */
	init {
		quadrant += if (x >= 0) 1 else 2
		quadrant += if (y >= 0) 0 else 3
		if (quadrant == 5) quadrant = 3
	}

}

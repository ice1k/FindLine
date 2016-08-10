package core.finder

import core.models.Area
import core.models.Line
import core.models.Point
import java.awt.Color
import java.io.File

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class Graph(file: File): Area(file) {
	var pointCache = Point(0, 0)

	override fun init() {
		(0..image.width - 1).forEach { x ->
			(0..image.height - 1).forEach { y ->
				image.setRGB(x, y, if (this[x, y]) Color.WHITE.rgb else Color.BLACK.rgb)
				mark[x][y] = this[x, y]
			}
		}
	}

	/**
	 * @param point send a clicked point
	 * @return connected
	 */
	fun send(point: Point): Boolean {
		val ret = pointCache connect point
		drawLine(Line(pointCache, point))
		pointCache = point
		return ret
	}

	private infix fun Point.connect(point: Point): Boolean {
		Line(this, point).allPoints.forEach { p -> if (this@Graph[p.x, p.y]) return false }
		return true
	}

}

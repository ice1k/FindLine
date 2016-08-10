package core.finder

import core.models.Area
import core.models.Line
import core.models.Point
import java.io.File

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
open class LineFinder(file: File): Area(file), Finder {
	var pointCache = Point(0, 0)

	/**
	 * @param point send a clicked point
	 * @return connected
	 */
	override fun send(point: Point): Boolean {
		val ret = pointCache connect point
		drawLine(Line(pointCache, point))
		pointCache = point
		return ret
	}

	private infix fun Point.connect(point: Point): Boolean {
		Line(this, point).allPoints.forEach { p -> if (this@LineFinder[p.x, p.y]) return false }
		return true
	}

}

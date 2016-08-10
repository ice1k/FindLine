package finder

import core.models.Area
import core.models.Line
import core.models.Point
import java.awt.image.BufferedImage

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
open class LineFinder(image: BufferedImage): Area(image), Finder {
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

}

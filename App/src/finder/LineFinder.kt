package finder

import core.models.Line
import core.models.Point
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
open class LineFinder(image: BufferedImage): Finder666(image) {
	override fun createFromFile(file: File) = LineFinder(ImageIO.read(file)!!)

	protected var pointCache = Point(1, 2)

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

package finder

import core.models.Line
import core.models.Point
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
open class TriangleFinder(image: BufferedImage) : LineFinder(image) {
	protected var pointCache1 = Point(2, 1)

	/**
	 * @param point send a clicked point
	 * @return connected
	 */
	override fun send(point: Point): Boolean {
		val ret = point connect pointCache1 && pointCache1 connect pointCache && point connect pointCache
		drawLine(Line(pointCache1, pointCache))
		drawLine(Line(point, pointCache))
		drawLine(Line(point, pointCache1))
		pointCache = pointCache1
		pointCache1 = point
		return ret
	}

	override fun createFromFile(file: File) = TriangleFinder(ImageIO.read(file)!!)
}
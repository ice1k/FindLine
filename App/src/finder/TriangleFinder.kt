package finder

import ice1000.models.Point
import ice1000.models.Triangle
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
open class TriangleFinder(image: BufferedImage) : Finder666(image) {
	private var pointCache1 = Point(2, 1)
	private var pointCache = Point(1, 2)

	/**
	 * @param point send a clicked p
	 * @return connected
	 */
	override fun send(point: Point): Boolean {
		val ret = point connect pointCache1 && pointCache1 connect pointCache && point connect pointCache
		drawTriangle(Triangle(point, pointCache, pointCache1))
		pointCache = pointCache1
		pointCache1 = point
		return ret
	}

	override fun createFromFile(file: File) = TriangleFinder(ImageIO.read(file)!!)
}
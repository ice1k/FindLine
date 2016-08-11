package filler

import finder.Finder666
import ice1000.models.Point
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000 * Created by ice1000 on 2016/8/11.
 */
class AreaFiller(image: BufferedImage): Finder666(image) {
	override fun send(point: Point): Boolean {
		val ret = this[point.x, point.y]
		draw(getArea(point))
		return ret
	}

	override fun createFromFile(file: File) = AreaFiller(ImageIO.read(file)!!)
}
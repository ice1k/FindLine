package core.models

import core.average
import utils.Binarization
import java.awt.Color
import java.awt.image.BufferedImage

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
abstract class Area(val origin: BufferedImage) {
	val image = BufferedImage(origin.width, origin.height, origin.type)

	fun drawLine(line: Line) = line.set.forEach { p ->
		image.setRGB(p.x, p.y, if (this[p.x, p.y]) Color.BLUE.rgb else Color.ORANGE.rgb)
	}

	/** @return True is white, False is black */
	operator fun get(x: Int, y: Int) = Binarization.gray(origin.getRGB(x, y)) > average

	fun init() {
		(0..image.width - 1).forEach { x ->
			(0..image.height - 1).forEach { y ->
				image.setRGB(x, y, if (this[x, y]) Color.WHITE.rgb else Color.BLACK.rgb)
			}
		}
	}

	protected infix fun Point.connect(point: Point): Boolean {
		Line(this, point).set.forEach { p -> if (this@Area[p.x, p.y]) return false }
		return true
	}
}
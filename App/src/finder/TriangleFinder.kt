package finder

import core.models.Point
import java.awt.image.BufferedImage

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
open class TriangleFinder(image: BufferedImage): LineFinder(image){
	override fun send(point: Point): Boolean {
		// TODO triangle fucking
		return super.send(point)
	}
}
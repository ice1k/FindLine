package core.finder

import core.models.Point
import java.io.File

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
open class TriangleFinder(file: File): LineFinder(file){
	override fun send(point: Point): Boolean {
		// TODO triangle fucking
		return super.send(point)
	}
}
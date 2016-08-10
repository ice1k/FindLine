package searcher

import finder.LineFinder
import java.awt.image.BufferedImage

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
open class LineSearcher(image: BufferedImage) : LineFinder(image), Searcher {
	override fun search() {
		// TODO search all lines
	}

}
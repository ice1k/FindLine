package core.finder.searcher

import core.finder.LineFinder
import java.io.File

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
open class LineSearcher(file: File) : LineFinder(file), Searcher {
	override fun search() {
		// TODO search all lines
	}

}
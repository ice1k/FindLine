package view

import searcher.Searcher666
import view.components.Frame666

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/11.
 */
class SearcherGUI(title: String, var graph: Searcher666) {
	val frame = Frame666(title, { setupFrame() }, { file -> graph = graph.createFromFile(file) })

	private fun setupFrame() {
		frame.setupSize(graph.image.width, graph.image.height)
	}
}
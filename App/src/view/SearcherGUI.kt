package view

import searcher.Searcher666

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/11.
 */
class SearcherGUI(title: String, var graph: Searcher666) {
	val frame = Factory.create(title, { setupFrame() }, { file -> graph = graph.createFromFile(file) })

	private fun setupFrame() {
		frame.setupSize(graph.image.width, graph.image.height)
	}
}
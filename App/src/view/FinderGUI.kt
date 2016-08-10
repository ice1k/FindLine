package view

import finder.Finder666
import view.components.FinderImagePanel
import java.awt.BorderLayout

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
open class FinderGUI(title: String, var graph: Finder666) {
	val panel = FinderImagePanel(graph)
	val frame = Factory.create(title, { setupFrame() }, { file -> graph = graph.createFromFile(file) })

	init {
		frame.add(panel, BorderLayout.CENTER)
		setupFrame()
	}

	private fun setupFrame() {
		frame.setupSize(graph.image.width, graph.image.height)
		panel.change(graph)
	}
}
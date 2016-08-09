package view.components

import core.models.Graph
import java.awt.Graphics
import javax.swing.JPanel

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class ImagePanel(var graph: Graph) : JPanel() {

	override fun paintComponent(g: Graphics) {
		g.drawImage(graph.image, 0, 0, this)
	}

	fun change(graph: Graph) {
		this.graph = graph
		graph.init()
		repaint()
	}
}
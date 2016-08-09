package view.components

import core.models.Graph
import core.models.Point
import utils.debug.LogConsole
import java.awt.Graphics
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JPanel

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class ImagePanel(var graph: Graph) : JPanel() {

	init {
		addMouseListener(object : MouseListener {
			override fun mouseEntered(e: MouseEvent) = Unit
			override fun mouseReleased(e: MouseEvent) = Unit
			override fun mouseExited(e: MouseEvent) = Unit
			override fun mousePressed(e: MouseEvent) = Unit
			override fun mouseClicked(e: MouseEvent) {
				graph.init()
				graph += Point(e.x, e.y)
				repaint()
				LogConsole.log("e.x = ${e.x}, e.y = ${e.y}")
			}
		})
	}

	override fun paintComponent(g: Graphics) {
		g.drawImage(graph.image, 0, 0, this)
	}

	fun change(graph: Graph) {
		this.graph = graph
		graph.init()
		repaint()
	}
}
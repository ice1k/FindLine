package view.components

import core.models.Graph
import core.models.Point
import java.awt.Graphics
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JOptionPane
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
				val connected = graph.send(Point(e.x, e.y))
				repaint()
				JOptionPane.showMessageDialog(null, if (connected) "Connected" else "Not Connected",
						"Information", JOptionPane.INFORMATION_MESSAGE)
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
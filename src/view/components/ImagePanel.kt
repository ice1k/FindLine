package view.components

import finder.LineFinder
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
class ImagePanel(var graph: LineFinder) : JPanel() {

	var point = Point(0, 0)

	init {
		addMouseListener(object : MouseListener {
			override fun mouseEntered(e: MouseEvent) = Unit
			override fun mouseReleased(e: MouseEvent) = Unit
			override fun mouseExited(e: MouseEvent) = Unit
			override fun mousePressed(e: MouseEvent) = Unit
			override fun mouseClicked(e: MouseEvent) {
				graph.init()
				point = Point(e.x, e.y)
				val connected = graph.send(point)
				repaint()
				JOptionPane.showMessageDialog(null, "${if (connected) "Connected" else "Not Connected"} , " +
						"ended on $point", "Information", JOptionPane.INFORMATION_MESSAGE)
			}
		})
	}

	override fun paintComponent(g: Graphics) {
		g.drawImage(graph.image, 0, 0, this)
	}

	fun change(graph: LineFinder) {
		this.graph = graph
		graph.init()
		repaint()
	}
}
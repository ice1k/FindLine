package view

import core.Graph
import view.components.ImagePanel
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class GUI(title: String, graph: Graph) {
    val frame: JFrame
    init {
        frame = JFrame(title)
        frame.bounds = Rectangle(x, y, graph.image.width, graph.image.height)
        frame.layout = BorderLayout()
        val panel = ImagePanel(graph.image)
        frame.add(panel)
        frame.isVisible = true
    }
}
package view

import core.Graph
import view.components.ImagePanel
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.imageio.ImageIO
import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.filechooser.FileNameExtensionFilter

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class GUI(title: String, var graph: Graph) {
    val frame = JFrame(title)
    val panel = ImagePanel(graph.image)

    var space = 0

    init {
        frame.layout = BorderLayout()
        val chooserButton = JButton("Open File")
        space += chooserButton.preferredSize.height
        setupFrame()
        frame.add(panel, BorderLayout.CENTER)
        chooserButton.addActionListener { action ->
            val chooser = JFileChooser()
            chooser.fileSelectionMode = JFileChooser.FILES_ONLY
            chooser.fileFilter = FileNameExtensionFilter("PNG Image", "png")
            if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
                graph = Graph(chooser.selectedFile)
                setupFrame()
            }
        }
        frame.add(chooserButton, BorderLayout.SOUTH)
        frame.isVisible = true
    }

    private fun setFrameSize(width: Int, height: Int) {
        frame.bounds = Rectangle(x, y, width, height + space)
    }
    
    private fun setupFrame() {
        setFrameSize(graph.image.width, graph.image.height)
        panel.change(graph.image)
    }
}
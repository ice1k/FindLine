package view

import core.GraphProcessor
import core.average
import view.components.Frame666
import view.components.ImagePanel
import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.filechooser.FileNameExtensionFilter

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class GUI(title: String, var graph: GraphProcessor) {
	val frame = Frame666(title)
	val panel = ImagePanel(graph.image)

	init {
		frame.layout = BorderLayout()
		val chooserButton = JButton("Open File")
		frame.add(panel, BorderLayout.CENTER)
		chooserButton.addActionListener { action ->
			val chooser = JFileChooser()
			chooser.fileSelectionMode = JFileChooser.FILES_ONLY
			chooser.fileFilter = FileNameExtensionFilter("PNG Image", "png")
			if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
				graph = GraphProcessor(chooser.selectedFile)
				setupFrame()
			}
		}
		frame.add(chooserButton, BorderLayout.SOUTH)

		fun manageAverage(number: Int) {
			average += number
			if (average > 0b11111111) average = 0b11111111
			if (average < 0b0) average = 0b0
			println(average)
			graph.init()
			setupFrame()
		}

		val plusButton = JButton("+")
		plusButton.addActionListener { action ->
			manageAverage(10)
		}
		frame.add(plusButton, BorderLayout.WEST)
		val minusButton = JButton("-")
		minusButton.addActionListener { action ->
			manageAverage(-10)
		}
		frame.add(minusButton, BorderLayout.EAST)
		setupFrame()
		frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		frame.isResizable = false
		frame.isVisible = true
	}

	private fun setupFrame() {
		frame.setupSize(graph.image.width, graph.image.height)
		panel.change(graph.image)
	}
}
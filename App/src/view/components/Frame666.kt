package view.components

import ice1000.average
import java.awt.BorderLayout
import java.awt.Component
import java.io.File
import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.filechooser.FileNameExtensionFilter

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */

class Frame666(title: String, setupFrame: () -> Unit, changeGraph: (File) -> Unit) : JFrame(title) {

	var spaceHeight = 0
	var spaceWidth = 0

	init {
		layout = BorderLayout()

		val chooserButton = JButton("Open File")

		chooserButton.addActionListener { action ->

			val chooser = JFileChooser()
			chooser.fileSelectionMode = JFileChooser.FILES_ONLY
			chooser.fileFilter = FileNameExtensionFilter("Supported Image Format", "png", "jpg")

			if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
				changeGraph(chooser.selectedFile)
				setupFrame()
			}
		}
		add(chooserButton, BorderLayout.SOUTH)

		fun manageAverage(number: Int) {
			average += number
			if (average > 0b11111111) average = 0b11111111
			if (average < 0b0) average = 0b0
			println(average)
			setupFrame()
		}

		val plusButton = JButton("+\n+\n+")
		plusButton.addActionListener { action -> manageAverage(5) }
		add(plusButton, BorderLayout.WEST)

		val minusButton = JButton("-\n-\n-")
		minusButton.addActionListener { action -> manageAverage(-5) }
		add(minusButton, BorderLayout.EAST)

		defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		isResizable = false
	}

	override fun add(comp: Component, constraints: Any?) {
		super.add(comp, constraints)
		when (constraints) {
			BorderLayout.NORTH, BorderLayout.SOUTH -> spaceHeight += comp.maximumSize.height
			BorderLayout.EAST, BorderLayout.WEST -> spaceWidth += comp.maximumSize.width
		}
	}

	fun setupSize(width: Int, height: Int) = setSize(width + spaceWidth, height + spaceHeight)

}
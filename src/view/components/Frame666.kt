package view.components

import java.awt.BorderLayout
import java.awt.Component
import java.awt.Rectangle
import javax.swing.JFrame

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */

class Frame666(title: String) : JFrame(title) {

	var spaceHeight = 0
	var spaceWidth = 0

	override fun add(comp: Component, constraints: Any?) {
		super.add(comp, constraints)
		when (constraints) {
			BorderLayout.NORTH, BorderLayout.SOUTH ->
				spaceHeight += comp.maximumSize.height
			BorderLayout.EAST, BorderLayout.WEST ->
				spaceWidth += comp.maximumSize.width
		}
	}

	fun setupSize(width: Int, height: Int) {
		bounds = Rectangle(view.x, view.y, width + spaceWidth, height + spaceHeight)
	}

}
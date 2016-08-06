package view.components

import java.awt.Graphics
import java.awt.Image
import javax.swing.JPanel

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class ImagePanel(var image: Image) : JPanel() {

    override fun paintComponent(g: Graphics?) {
        g?.drawImage(image, 0, 0, this)
    }

    fun change(image: Image) {
        this.image = image
        repaint()
    }
}
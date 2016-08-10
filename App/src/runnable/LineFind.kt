package runnable

import finder.LineFinder
import view.FinderGUI
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */

fun main(args: Array<String>) {
	FinderGUI("Line by ice1000", LineFinder(ImageIO.read(File("test.png"))))
}
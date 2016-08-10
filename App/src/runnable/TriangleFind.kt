package runnable

import finder.TriangleFinder
import view.GUI
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/11.
 */

fun main(args: Array<String>) {
	GUI("Line by ice1000", TriangleFinder(ImageIO.read(File("test.png"))))
}
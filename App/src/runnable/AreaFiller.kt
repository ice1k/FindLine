package runnable

import filler.AreaFiller
import view.FinderGUI
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/11.
 */

fun main(args: Array<String>) {
	FinderGUI("Line by ice1000", AreaFiller(ImageIO.read(File("test.png"))))
}
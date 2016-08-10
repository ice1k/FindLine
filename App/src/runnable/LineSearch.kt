package runnable

import searcher.LineSearcher
import view.SearcherGUI
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/11.
 */

fun main(args: Array<String>) {
	SearcherGUI("Search by ice1000", LineSearcher(ImageIO.read(File("test.png"))))
}
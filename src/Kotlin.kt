import core.Graph
import view.GUI
import java.io.File

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */

fun main(args: Array<String>) {
	GUI("Line by ice1000", Graph(File("test.png")))
}
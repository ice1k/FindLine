package searcher

import ice1000.models.Area
import java.awt.image.BufferedImage
import java.io.File

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/11.
 */
abstract class Searcher666(image: BufferedImage) : Area(image), Searcher {
		abstract fun createFromFile(file: File): Searcher666
}
package finder

import core.models.Area
import java.awt.image.BufferedImage
import java.io.File

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/11.
 */
abstract class Finder666(image: BufferedImage) : Area(image), Finder {
		abstract fun createFromFile(file: File): Finder666
}
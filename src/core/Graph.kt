package core

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class Graph(path: String) {
    val image: BufferedImage

    init {
        image = ImageIO.read(File(path))
        for (x in 0..image.width) {
            for (y in 0..image.height) {
                image.setRGB(
                        x, y,
                        image.getRGB(x, y)
                )
            }
        }
    }
}
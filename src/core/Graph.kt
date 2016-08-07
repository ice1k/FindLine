package core

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class Graph(file: File) {
    val image: BufferedImage

    init {
        image = ImageIO.read(file)
        (0..image.width - 1).forEach { x ->
            (0..image.height - 1).forEach { y ->
                image.setRGB(
                        x, y,
                        getBin(x, y)
                )
            }
        }
    }

    /**
     * @param x x in image
     * @param y y in image
     * @return black or white
     */
    private fun getBin(x: Int, y: Int) =
            if (BinaryMaker.getGray(image.getRGB(x, y)) > average)
                Color(0b111111, 0b111111, 0b111111).rgb
            else
                Color(0b000000, 0b000000, 0b000000).rgb

}
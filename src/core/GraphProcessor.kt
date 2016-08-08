package core

import core.processors.BinaryProcessor
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 */
class GraphProcessor(file: File) {
	val image: BufferedImage
	val cache: BufferedImage

	init {
		image = ImageIO.read(file)
		cache = ImageIO.read(file)
		init()
	}

	fun init() {
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
			if (BinaryProcessor.getGray(cache.getRGB(x, y)) > average)
				Color.WHITE.rgb
			else
				Color.BLACK.rgb

}
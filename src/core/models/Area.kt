package core.models

import core.average
import utils.Binarization
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
abstract class Area(file: File) {
	val image: BufferedImage
	val origin: BufferedImage
	val mark: Array<Array<Boolean>>

	init {
		image = ImageIO.read(file)
		origin = ImageIO.read(file)
		mark = Array(origin.width, { Array(origin.height, { false }) })
		init()
	}

	fun drawLine(line: Line) = line.allPoints.forEach { p ->
		image.setRGB(p.x, p.y, if (this[p.x, p.y]) Color.BLUE.rgb else Color.ORANGE.rgb)
	}

	/** @return True is white, False is black */
	operator fun get(x: Int, y: Int) = Binarization.gray(origin.getRGB(x, y)) > average

	abstract fun init()
}
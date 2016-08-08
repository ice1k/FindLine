package core.processors

import java.awt.Color

/**
 * @author ice1000
 * Created by ice1000 on 16-8-6.
 * referred http://blog.csdn.net/lzs109/article/details/7316507
 */
object BinaryProcessor {

	fun getGray(rgb: Int): Int {
		val color = Color(rgb)
		return (color.blue +
				color.green +
				color.red) / 3
	}

}
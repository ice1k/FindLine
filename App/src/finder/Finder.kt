package finder

import core.models.Point

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
interface Finder {
	fun send(point: Point): Boolean
}
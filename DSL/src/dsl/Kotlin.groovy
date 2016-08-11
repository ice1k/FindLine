package dsl

import finder.LineFinder
import view.FinderGUI

import javax.imageio.ImageIO

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 *
 * This Class resolve staffs between Kotlin and Groovy
 */
abstract class Kotlin extends FinderGUI {

	abstract String getPath();

	protected Kotlin() {
		this("Kotlin by ice1000", new LineFinder(ImageIO.read(new File(getPath()))))
	}

	private Kotlin(String title, LineFinder graph) {
		super(title, graph)
		init()
	}

	abstract void init();
}

package dsl

import core.finder.LineFinder
import view.GUI

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 *
 * This Class resolve staffs between Kotlin and Groovy
 */
abstract class Kotlin extends GUI {

	abstract String getPath();

	protected Kotlin() {
		this("Kotlin by ice1000", new LineFinder(new File(getPath())))
	}

	private Kotlin(String title, LineFinder graph) {
		super(title, graph)
		init()
	}

	abstract void init();
}

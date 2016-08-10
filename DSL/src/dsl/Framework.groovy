package dsl

import core.models.Graph

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/10.
 */
abstract class Framework {

	private def graph

	abstract String getPath();

	abstract void init();

	protected Framework() {
		graph = new Graph(new File(getPath()))
	}
}

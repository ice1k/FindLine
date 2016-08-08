package dsl

import core.GraphProcessor
import view.GUI

class Framework {
	Framework() {
		def gui = new GUI(
				'FindLine',
				new GraphProcessor(new File('test.png'))
		)
	}
}
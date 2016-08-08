package core;

/**
 * @author ice1000
 *         Created by ice1000 on 2016/8/8.
 */
public abstract class Test {

	protected Test() {
		run();
	}

	private class AssertionError extends Error {
	}

	protected void assertEqual(Object x, Object y) {
		if (x != y) throw new AssertionError();
	}

	protected abstract void run();
}

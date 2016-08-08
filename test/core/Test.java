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

	/**
	 * assertion
	 * @param x one object
	 * @param y another object
	 */
	protected void assertEqual(Object x, Object y) {
		if (x != y && !x.equals(y)) throw new AssertionError();
	}

	protected abstract void run();
}

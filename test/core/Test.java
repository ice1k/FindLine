package core;

/**
 * My own test framework.
 * Created by ice1000 on 2016/8/8.
 *
 * @author ice1000
 *         <p>
 */
public class Test {

	protected Test() {
		run();
	}

	private class AssertionError extends Error {
	}

	/**
	 * assertion
	 *
	 * @param x one object
	 * @param y another object
	 */
	protected void assertEqual(Object x, Object y) {
		if (x != y && !x.equals(y)) throw new AssertionError();
	}

	/**
	 * show an object on console (calling toString)
	 *
	 * @param any object to show
	 */
	protected void show(Object any) {
		System.out.println("[type: " + any.getClass().toString() + ", value: " + any.toString() + ']');
	}

	protected void run() {
		assertEqual(1 + 2, 3);
	}
}

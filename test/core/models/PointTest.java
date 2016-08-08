package core.models;

import core.Test;

/**
 * @author ice1000
 * Created by ice1000 on 2016/8/8.
 */
public class PointTest extends Test {

	public static void main(String[] args) {
		new PointTest();
	}

	@Override
	protected void run() {
		assertEqual(new Point(1, 1).getQuadrant(), 1);
		assertEqual(new Point(-1, 1).getQuadrant(), 2);
		assertEqual(new Point(-1, -1).getQuadrant(), 3);
		assertEqual(new Point(1, -1).getQuadrant(), 4);
		assertEqual(new Point(1, 2), new Point(1, 2));
	}
}

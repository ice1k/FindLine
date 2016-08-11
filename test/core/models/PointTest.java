package core.models;

import core.Test;
import ice1000.models.Point;

/**
 * Created by ice1000 on 2016/8/11.
 * @author ice1000
 */
public class PointTest extends Test{
	@Override
	protected void run() {
		assertEqual(new Point(1, 2), new Point(1, 2));
		assertEqual(new Point(1, 1).distance(new Point(2, 1)), 1);
		show(new Point(0, 0).distance(new Point(1, 1)));
	}

	public static void main(String[] args) {
		new PointTest();
	}
}

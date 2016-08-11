package core.models;

import core.Test;
import ice1000.models.Position;

/**
 * Created by ice1000 on 2016/8/8.
 * @author ice1000
 */
public class PositionTest extends Test {

	@Override
	protected void run() {
		assertEqual(new Position(1, 1).getQuadrant(), 1);
		assertEqual(new Position(-1, 1).getQuadrant(), 2);
		assertEqual(new Position(-1, -1).getQuadrant(), 3);
		assertEqual(new Position(1, -1).getQuadrant(), 4);
	}

	public static void main(String[] args) {
		new PositionTest();
	}
}

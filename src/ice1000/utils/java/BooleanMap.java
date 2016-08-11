package ice1000.utils.java;

/**
 * Created by ice1000 on 2016/8/11.
 *
 * @author ice1000
 */
public class BooleanMap {
	private boolean[][] bool;

	public BooleanMap(int x, int y) {
		bool = new boolean[x][y];
	}

	public boolean get(int x, int y) {
		return bool[x][y];
	}

	public void set(int x, int y, boolean value) {
		bool[x][y] = value;
	}
}

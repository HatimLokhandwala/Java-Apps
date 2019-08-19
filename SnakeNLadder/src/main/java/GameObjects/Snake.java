package GameObjects;

/**
 * Created by hatim.lokhandwala on 14/08/19.
 */
public class Snake extends BasePiece {
	public Snake(int start, int end) {
		super(start, end);
	}

	public boolean isUpwardsPiece() {
		return false;
	}
}

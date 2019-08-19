package GameObjects;

/**
 * Created by hatim.lokhandwala on 14/08/19.
 */
public class Ladder extends BasePiece{
	public Ladder(int start, int end) {
		super(start, end);
	}

	public boolean isUpwardsPiece() {
		return true;
	}

}

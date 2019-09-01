package GameObjects;

/**
 * Created by hatim.lokhandwala on 14/08/19.
 */
public abstract class BasePiece implements  Piece {
	private int start;
	private int end;

	BasePiece(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getDestinationIndex() {
		return end;
	}


}

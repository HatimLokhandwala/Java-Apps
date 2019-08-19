import GameObjects.Ladder;
import GameObjects.Piece;
import GameObjects.Snake;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hatim.lokhandwala on 14/08/19.
 */
public class Board {
	private int size;
	private Slot[] slots;
	private HashMap<Integer, Piece> pieceHashMap;
	Board() {
		this(100);
	}

	/* creates a board with given size
	 if size <=0 , a board with size 100 is assumed
	 */

	Board(int size) {
		if(size <= 0 ) {
			size = 100;
		}
		this.size = size;
		slots = new Slot[size];
		for(int i = 0; i < size; i++) {
			slots[i] = new Slot(i + 1);
		}
		pieceHashMap = new HashMap<Integer, Piece>();
	}

	boolean addPiece(int start, int end) {
		if(start == end || start < 0 || start > this.size || end < 0 || end > this.size) {
			System.out.println("Invalid points");
			return false;
		}
		Piece piece = null;
		if(start < end) {
			piece = new Ladder(start, end);
		} else {
			piece = new Snake(start, end);
		}
		pieceHashMap.put(start, piece);
		return true;
	}

	public Slot getSlot(int index) {
		return slots[index];
	}

	Slot getFirstSlot() {
		return getSlot(0);
	}

	Slot getLastSlot(){
		return getSlot(size - 1);
	}

	public int getSize() {
		return this.size;
	}

	public List<Player> getPlayers(int index) {
		return slots[index].getPlayerList();
	}
}

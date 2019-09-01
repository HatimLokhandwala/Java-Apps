import GameObjects.Ladder;
import GameObjects.Piece;
import GameObjects.Snake;

import java.util.*;

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
			slots[i] = new Slot(i);
		}
		pieceHashMap = new HashMap<>();
	}

	/**
	 *
	 * @param start position where the start of the piece would belong
	 * @param end position where the end of the piece would belong
	 * @return true if the piece could be added to the map of obstacles
	 */
	boolean addPiece(int start, int end) {
		if(start == end || start < 0 || start > this.size || end < 0 || end > this.size) {
			System.out.println("Invalid points");
			return false;
		}
		Piece piece;
		if(start < end) {
			piece = new Ladder(start, end);
		} else {
			piece = new Snake(start, end);
		}
		pieceHashMap.put(start, piece);
		return true;
	}

	/**
	 *
	 * @param index position
	 * @return destination position based on the presence of an object
	 * at the current position
	 */
	int getDestinationPos(int index) {
		if(index >= size) {
			return size - 1;
		}
		if(pieceHashMap.containsKey(index)) {
			return pieceHashMap.get(index).getDestinationIndex();
		}
		return index;
	}

	int getSize() {
		return this.size;
	}

	List<Player> getPlayers(int index) {
		return slots[index].getPlayerList();
	}

	void removePlayer(int position, Player currentPlayer) throws Exception {
		slots[position].removePlayer(currentPlayer);
	}

	void addPlayer(int position, Player currentPlayer) throws Exception{
		slots[position].addPlayer(currentPlayer);
	}

	boolean isWinningPosition(int index) {
		return index == size - 1;
	}
}

import GameObjects.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hatim.lokhandwala on 14/08/19.
 */
public class Slot {
	private int index;
	private List<Player> playerList;

	Slot(int index) {
		this.index = index;
		this.playerList = new ArrayList<Player>();
	}

	public int getIndex() {
		return index;
	}

	boolean addPlayer(Player player) throws Exception {
		if(player == null) {
			throw new Exception("Empty player");
		}
		if(playerList.contains(player)) {
			return false;
		}
		playerList.add(player);
		return true;
	}

	boolean removePlayer(Player player) throws Exception {
		if(player == null) {
			throw new Exception("Empty player");
		}
		if(playerList.contains(player)) {
			playerList.remove(player);
			return true;
		}
		return false;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}
}

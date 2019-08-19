import java.util.List;

/**
 * Created by hatim.lokhandwala on 15/08/19.
 */
public class Game {
	private List<Player> playerList;
	private Board board;

	void addPieces() {
		board.addPiece(2, 20);
		board.addPiece(88, 100);
		board.addPiece(49, 61);
		board.addPiece(97, 50);
		board.addPiece(44, 32);
		board.addPiece(79, 54);
	}

	Game(List<Player> playerList) {
		this.playerList = playerList;
		board = new Board(100);
		addPieces();
	}

	void playGame() throws Exception {
		if(playerList == null || playerList.size() == 0) {
			throw new Exception("No players in the game");
		}

	}

	void addPlayer(Player p) {
		this.playerList.add(p);
	}

	List<Player> getPlayersAtASlot(int index) throws Exception {
		if(index < 0 || index >= board.getSize()) {
			throw new Exception("Invalid index");
		}
		return board.getPlayers(index);
	}

//	getSlotOfAPlayer() {
//
//	}

	List<Player> getWinners(){
		return null;
	}

}

import java.util.*;

/**
 * Created by hatim.lokhandwala on 15/08/19.
 */

class Dice {
	private static Random random;
	private static final int UPPER_BOUND = 6;
	static {
		random = new Random();
	}
	static int getNextMove(){
		return random.nextInt(UPPER_BOUND) + 1;
	}
}

public class Game {
	private List<Player> playerList;
	private HashSet<Player> leaderBoard; //used to maintain the order of the players completing game
	private Board board;

	private void addPieces() {
		board.addPiece(2, 20);
		board.addPiece(88, 100);
		board.addPiece(49, 61);
		board.addPiece(97, 50);
		board.addPiece(44, 32);
		board.addPiece(79, 54);
	}

	Game(List<Player> playerList) {
		if(playerList == null || playerList.size() == 0) {
			throw new IllegalArgumentException("No players in the game");
		}
		this.playerList = playerList;
		board = new Board(100);
		addPieces();
		leaderBoard = new LinkedHashSet<>();
	}

	void playGame() throws Exception {
		int current = 0;
		while(leaderBoard.size() != playerList.size()) {
			Player currentPlayer = playerList.get(current);
			if(!leaderBoard.contains(currentPlayer)) {
				System.out.println("turn of player " + currentPlayer);
				//roll dice
				int nextMove = Dice.getNextMove();
				int destPos = board.getDestinationPos(currentPlayer.getCurrentPosition() + nextMove);
				board.removePlayer(currentPlayer.getCurrentPosition(), currentPlayer);
				board.addPlayer(destPos, currentPlayer);
				currentPlayer.setCurrentPosition(destPos);
				//check if the player has reached the end pos in the board
				if(board.isWinningPosition(destPos)) {
					System.out.println("Player " + currentPlayer + " has reached the destination position");
					leaderBoard.add(currentPlayer);
				}
			}
			current = (current + 1) % playerList.size();
		}
		System.out.println("Game completed");
	}

	void printLeaderBoard() {
		int count = 1;
		for (Player p : leaderBoard) {
			System.out.println("Position: " + count++ + " Name: " + p);
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

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 14/08/19.
 */
public class SnakeNLadder {
	private static Scanner scanner;

	static{
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {

		System.out.println("Enter number of players");
		int nPlayers = scanner.nextInt();
		List<Player> playerList = new ArrayList<Player>();

		int index = 0;
		while(index < nPlayers) {
			System.out.println("Enter player name");
			String name = scanner.next();
			playerList.add(new Player(name));
			index++;
		}
		Game game = new Game(playerList);
		game.playGame();
	}
}

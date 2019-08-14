package TeamBuildingGame;

import TeamBuildingGame.Constants;
import TeamBuildingGame.Player;
import TeamBuildingGame.PlayerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by hatim.lokhandwala on 24/07/19.
 */
public class PlayerPool {
	private List<Player> playerList;

	PlayerPool() {
		playerList = new ArrayList<>();
		generatePlayers();
	}

	private void assignCredits() {
		Random r = new Random();
		for(Player p: playerList) {
			//generate credit for the player
			int credit = r.nextInt((Constants.MAX_PLAYER_CREDIT - Constants.MIN_PLAYER_CREDIT) + 1) + Constants.MIN_PLAYER_CREDIT;
			p.setCredit(credit);
		}
	}

	private void generatePlayers() {
		playerList.add(new Player("Sachin", PlayerType.BATSMAN));
		playerList.add(new Player("Rahul", PlayerType.BATSMAN));
		playerList.add(new Player("Virat", PlayerType.BATSMAN));
		playerList.add(new Player("yuvi", PlayerType.BATSMAN));
		playerList.add(new Player("dravid", PlayerType.BATSMAN));
		playerList.add(new Player("mohammed", PlayerType.BATSMAN));
		playerList.add(new Player("Ramesh", PlayerType.BOWLER));
		playerList.add(new Player("Suresh", PlayerType.BOWLER));
		playerList.add(new Player("Peterson", PlayerType.BOWLER));
		playerList.add(new Player("williamson", PlayerType.BOWLER));
		playerList.add(new Player("shami", PlayerType.BOWLER));
		playerList.add(new Player("Bhuvi", PlayerType.BOWLER));
		playerList.add(new Player("Dhoni", PlayerType.WICKETKEEPER));
		playerList.add(new Player("Gilchrist", PlayerType.WICKETKEEPER));
		assignCredits();
	}


	public List<Player> getPlayerPool() {
		return playerList;
	}
}

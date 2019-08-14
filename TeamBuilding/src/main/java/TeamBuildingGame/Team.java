package TeamBuildingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static TeamBuildingGame.Constants.TEAM_SIZE;

/**
 * Created by hatim.lokhandwala on 24/07/19.
 */
public class Team {
	private User owner;
	private int totalTeamValue;
	List<Player> playerList;

	Team(User owner) {
		this.owner = owner;
		totalTeamValue = 0;
		playerList = new ArrayList<>();
	}

	boolean addPlayer(Player p) throws Exception {
		if(playerList.size() == TEAM_SIZE) {
			throw new Exception("Team is build up to team size" + TEAM_SIZE + " Remove players");
		}
		if(playerList.contains(p)) {
			System.out.println("Player already in team");
			return false;
		} else {
			playerList.add(p);
			System.out.println("Player " + p  + "added in team");
			return true;
		}

	}

	boolean removePlayer(Player p) throws Exception {
		if(playerList.size() == 0) {
			throw new Exception("Team is empty");
		}
		if(playerList.contains(p)) {
			System.out.println("Player removed from team");
			playerList.remove(p);
			return true;
		} else {
			System.out.println("Player " + p  + "not in team");
			return false;
		}

	}

	void removePlayers(){
		playerList.clear();
	}


	boolean isValidTeam() {
		int wicketKeeper = 0;
		int batsmen = 0;
		int bowler = 0;
		for(Player p : playerList) {
			if(p.getPlayerType() == PlayerType.WICKETKEEPER) {
				wicketKeeper++;
			} else if (p.getPlayerType() == PlayerType.BATSMAN) {
				batsmen++;
			} else if(p.getPlayerType() == PlayerType.BOWLER) {
				bowler++;
			}
		}

		if(wicketKeeper != 1) {
			return false;
		}
		if(batsmen < 3) {
			return false;
		}
		if(bowler < 3) {
			return false;
		}
		return true;
	}


	int getScore() {
		return totalTeamValue;
	}


	void generateScore() {
		int total = 0;
		for(Player p : playerList) {
			total += p.getValue();
		}
		totalTeamValue = total;
	}


	int getSize(){
		return playerList.size();
	}

}

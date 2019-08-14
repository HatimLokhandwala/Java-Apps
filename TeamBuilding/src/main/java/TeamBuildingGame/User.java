package TeamBuildingGame;

import java.util.Objects;

/**
 * Created by hatim.lokhandwala on 24/07/19.
 */
public class User {
	private String name;
	private int totalCredits;
	private int usedCredits;
	private Team team;
	User(String name) {
		this.name = name;
		totalCredits = Constants.TOTAL_PLAYER_CREDITS;
		usedCredits = 0;
		team = new Team(this);
	}

	void setTeam(Team team) {
		this.team = team;
	}

	boolean addPlayer(Player p) throws Exception {
		if(totalCredits - usedCredits >= p.getValue()) {
			return team.addPlayer(p);
		} else {
			System.out.println("Not enough credits to buy");
			return false;
		}
	}

	void resetTeam() {
		team.removePlayers();
	}

	public Team getTeam() {
		return team;
	}

	public int getTeamSize(){
		return team.getSize();
	}

	boolean isValidTeam() {
		return team.isValidTeam();
	}

	int getScore() {
		return team.getScore();
	}

	void generateScore(){
		team.generateScore();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(name, user.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}

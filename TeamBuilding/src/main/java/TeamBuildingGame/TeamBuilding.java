package TeamBuildingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static TeamBuildingGame.Constants.TEAM_SIZE;

/**
 * Created by hatim.lokhandwala on 24/07/19.
 */
public class TeamBuilding {
	static PlayerPool playerPool;
	static List<User> userList;
	static Scanner sc;
	private static void init() {
		playerPool = new PlayerPool();
		userList = new ArrayList<>();
	}

	private static void buildTeam(User user) {
		printPlayers();
		int count = 0;
		while(count < TEAM_SIZE) {
			System.out.println("Enter Player Index");
			int index = sc.nextInt();
			Player p = playerPool.getPlayerPool().get(index);
			try {
				if (user.addPlayer(p)) {
					count++;
				}
			} catch(Exception e) {
				System.out.println("Player already in team");
			}
		}
		if(!user.isValidTeam()) {
			System.out.println("Invalid team according to constraints");
		} else {
			System.out.println("Team generated");
		}
	}

	private static void addValues() {
		printPlayers();
		while(true) {
			int index = sc.nextInt();
			int value = sc.nextInt();
			if(playerPool.getPlayerPool().size() <=index) {
				System.out.println("Invalid player index");
			} else {
				Player p = playerPool.getPlayerPool().get(index);
				p.setValue(value);
			}
			String flag = sc.next();
			if(flag.equals("no")) {
				break;
			}

		}
	}
	static void printPlayers() {
		List<Player> playerList = playerPool.getPlayerPool();
		int index = 0;
		for(Player p : playerList) {
			System.out.println("index " + index +  " Name " +  p.getName()  +  " Type " +  p.getPlayerType() + " CREDIT " + p.getCredit());
			index++;
		}
	}

	private static void generateTeamScores(){
		for(User user: userList) {
			user.generateScore();
		}
	}

	public static void main(String[] args) {
			init();
			sc = new Scanner(System.in);
			while(true) {
				System.out.println("enter user type: 1. GAMER 2. to check team score 3. admin");
				int type = sc.nextInt();
				if(type == 1) {
					System.out.println("Enter username");
					String userName = sc.next();
					User user = new User(userName);
					System.out.println("BuildTeam");
					//user has not build the team
					if(user.getTeamSize() == 0) {
						buildTeam(user);
						userList.add(user);
					} else {
						System.out.println("Team already there Do you want to reset and rebuild. Enter yes or no");
						String flag = sc.next();
						if(flag.equals("yes")) {
							user.resetTeam();
							buildTeam(user);
						}
					}

				} else if(type == 2) {
					String userName = sc.next();
					User user = new User(userName);
					if(userList.contains(user)) {
						int score = user.getScore();
						System.out.println("Score of player "  +  userName + " is " +  score);
					} else {
						System.out.println("User does not exist");
					}

				} else if(type == 3) {
					System.out.println("Enter values for the player, Give Index and value, Enter no to exit");
					addValues();
					generateTeamScores();
				} else {
					System.out.println("Invalid option");
				}


			}
	}
}

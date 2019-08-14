package TeamBuildingGame;

import java.util.Objects;

/**
 * Created by hatim.lokhandwala on 24/07/19.
 */

public class Player {
	private String name;

	private PlayerType playerType;

	private int value;

	private int credit;

	public Player(String name, PlayerType playerType) {
		this.name = name;
		this.playerType = playerType;
		this.value = 0;
		this.credit = 0;
	}

	Player(String name, PlayerType playerType, int value) {
		this(name, playerType);
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getCredit() {
		return credit;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return Objects.equals(name, player.name) &&
				playerType == player.playerType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, playerType);
	}
}

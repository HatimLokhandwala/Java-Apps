import java.util.Objects;

/**
 * Created by hatim.lokhandwala on 14/08/19.
 */
public class Player {
	private String name;
	private int currentPosition;
	Player(String name){
		this.name = name;
		currentPosition = -1;
	}

	public String getName() {
		return name;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return Objects.equals(name, player.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}

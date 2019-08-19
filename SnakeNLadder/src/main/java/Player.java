/**
 * Created by hatim.lokhandwala on 14/08/19.
 */
public class Player {
	private String name;
	private int currentPosition;
	Player(String name){
		this.name = name;
		currentPosition = 0;
	}

	public String getName() {
		return name;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}
}

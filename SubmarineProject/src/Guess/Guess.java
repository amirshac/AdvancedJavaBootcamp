package Guess;

import java.io.Serializable;

public class Guess implements Serializable {

	private static final long serialVersionUID = -8241208351777696789L;
	
	int x;
	int y;
	
	public Guess(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Guess [x=" + x + ", y=" + y + "]";
	}
}

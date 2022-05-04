package ScoreBoard;

import java.util.Random;

public class Utils {
	public static Random random = new Random();
	
	public static int getRandomInt(int min, int max) {
		return random.nextInt(min, max+1);
	}
	
	public static int getRandomInt(int min) {
		return random.nextInt(min, Integer.MAX_VALUE);
	}
}

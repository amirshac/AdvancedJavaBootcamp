package Testing.Shirts;

public class Utils {
	
	public static int setIntInRange(int value, int min, int max) {
		if (value > max)
			value  = max;
		else if (value < min)
			value = min;
		
		return value;
	}
	
	public static short setShortInRange(short value, int min, int max) {
		return (short)setIntInRange(value, min, max);
	}
	
	public static short setShortInRange(short value, short min, short max) {
		return (short)setIntInRange(value, min, max);
	}
}

package Testing.Shirts;

public class Utils {
	
	public static double setDoubleInRange(double value, double min, double max) {
		if (value > max)
			value  = max;
		else if (value < min)
			value = min;
		
		return value;		
	}
	
	public static int setIntInRange(int value, int min, int max) {
		return (int)setDoubleInRange(value, min, max);
	}
	
	public static short setShortInRange(short value, int min, int max) {
		return (short)setDoubleInRange(value, min, max);
	}
	
	public static short setShortInRange(short value, short min, short max) {
		return (short)setDoubleInRange(value, min, max);
	}
}

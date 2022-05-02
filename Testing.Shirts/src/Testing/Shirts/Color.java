package Testing.Shirts;

import java.util.Arrays;

public class Color {
	private static final short COLOR_MIN = 0;
	private static final short COLOR_MAX = 255;
	private static final short COLOR_DEFAULT = 100;
	private static final short COLOR_NUMBER = 3;
	
	private static final short INDEX_RED = 0;
	private static final short INDEX_GREEN = 1;
	private static final short INDEX_BLUE = 2;
	
	private static final String DOMINANT_RED = "Red";
	private static final String DOMINANT_GREEN = "Green";
	private static final String DOMINANT_BLUE = "Blue";
	
	protected short red;
	protected short green;
	protected short blue;
	
	protected float[] normalized;
	
	public Color() {
		this(COLOR_DEFAULT, COLOR_DEFAULT, COLOR_DEFAULT);
	}
	
	public Color(int red, int green, int blue) {
		this( (short)red, (short)green, (short)blue );
	}
	
	public Color(short red, short green, short blue) {
		super();
		setRed(red);
		setGreen(green);
		setBlue(blue);
		
		normalized = new float[COLOR_NUMBER];
		calculateNormalized();
	}

	protected short setColor(short color) {
		if (color > COLOR_MAX)
			color = COLOR_MAX;
		else if (color < COLOR_MIN)
			color = COLOR_MIN;
		
		return color;
	}
	
	public void setRed(short red) {
		this.red = Utils.setShortInRange(red, COLOR_MIN, COLOR_MAX);
	}


	public void setGreen(short green) {
		this.green = Utils.setShortInRange(green, COLOR_MIN, COLOR_MAX);
	}

	public void setBlue(short blue) {
		this.blue = Utils.setShortInRange(blue, COLOR_MIN, COLOR_MAX);
	}

	
	protected void calculateNormalized() {
		normalized[INDEX_RED] = (float)red/COLOR_MAX;
		normalized[INDEX_GREEN] = (float)green/COLOR_MAX;
		normalized[INDEX_BLUE] = (float)blue/COLOR_MAX;
	}
	
	protected float[] normalized() {
		calculateNormalized();
		return this.normalized;
	}
	
	public String getDominant() {
		String dominant = DOMINANT_RED;
		short biggest = red;
		
		biggest = (short) Math.max(red, Math.max(blue, green));
		
		if (biggest == red)
			return DOMINANT_RED;
		
		if (biggest == blue)
			return DOMINANT_BLUE;
		
		if (biggest == green)
			return DOMINANT_GREEN;
		
		return dominant;
	}
	
	@Override
	public String toString() {
		return "Color [red=" + red + ", green=" + green + ", blue=" + blue + ", normalized="
				+ Arrays.toString(normalized) + " + dominant: " + this.getDominant() + "]";
	}
	
	
	

}

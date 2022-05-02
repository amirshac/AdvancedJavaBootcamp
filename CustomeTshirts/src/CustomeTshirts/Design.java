package CustomeTshirts;

public class Design {
	private static final double MIN_WIDTH = 20;
	private static final double MAX_WIDTH = 30;
	private static final double DEF_WIDTH = MIN_WIDTH;
	private static final double MIN_HEIGHT = 10;
	private static final double MAX_HEIGHT = 25;
	private static final double DEF_HEIGHT = MIN_HEIGHT;
	private static final double MIN_COMPLEXITY = 1;
	private static final double MAX_COMPLEXITY = 100;
	private static final double DEF_COMPLEXITY = MIN_COMPLEXITY;
	private static final String DEF_SLOGAN = "Slogan";
	private static final Color DEF_COLOR = new Color();
	
	protected double width;
	protected double height;
	protected String slogan;
	protected double complexity;
	protected Color color;
	
	private double area;

	public Design(double width, double height, String slogan, double complexity, Color color) {
		super();
		setWidth(width);
		setHeight(height);
		setSlogan(slogan);
		setColor(color);
		setComplexity(complexity);
		
		this.area = calculateArea();
	}
	
	public Design(double width, double height, String slogan, double complexity, short colorR, short colorG, short colorB) {
		this(width, height, slogan, complexity, new Color(colorR, colorB, colorG));
	}
	
	public Design() {
		this (DEF_WIDTH, DEF_HEIGHT, DEF_SLOGAN, DEF_COMPLEXITY, DEF_COLOR);
	}

	@Override
	public String toString() {
		return "Design [width=" + width + ", height=" + height + ", slogan=" + slogan + 
				 ", complexity=" + complexity + ", area=" + area + ", color=" + color + "]";
	}
	
	protected double calculateArea() {
		area = width*height;
		return area;
	}
	
	protected double setValueWithinBounds(double value, double min, double max) {
		double result = value;
		if (result > max)
			result = max;
		else if (result < min)
			result = min;
		
		return result;
	}

	
	public void setWidth(double width) {
		this.width = setValueWithinBounds(width, MIN_WIDTH, MAX_WIDTH);
	}

	public void setHeight(double height) {
		this.height = setValueWithinBounds(height, MIN_HEIGHT, MAX_HEIGHT);
	}


	// TODO: implement only digits and letters
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setColor(short red, short green, short blue) {
		this.color = new Color(red, green, blue);
	}


	public void setComplexity(double complexity) {
		this.complexity = setValueWithinBounds(complexity, MIN_COMPLEXITY, MAX_COMPLEXITY);
	}
	
	
}

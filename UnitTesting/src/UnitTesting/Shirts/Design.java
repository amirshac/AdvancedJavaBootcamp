package UnitTesting.Shirts;

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
	
	protected double area;

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
		
	public void setWidth(double width) {
		this.width = Utils.setDoubleInRange(width, MIN_WIDTH, MAX_WIDTH);
		calculateArea();
	}

	public void setHeight(double height) {
		this.height = Utils.setDoubleInRange(height, MIN_HEIGHT, MAX_HEIGHT);
		calculateArea();
	}


	// TODO: implement only digits and letters
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setColor(int red, int green, int blue) {
		this.color = new Color(red, green, blue);
	}

	public void setComplexity(double complexity) {
		this.complexity = Utils.setDoubleInRange(complexity, MIN_COMPLEXITY, MAX_COMPLEXITY);
	}
	
}

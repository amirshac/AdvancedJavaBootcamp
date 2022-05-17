package xml.cars;

public class Plate {
	private static final Color DEF_COLOR;
	private static long counter;
	
	protected long number;
	protected Color color;
	
	static {
		counter = 0;
		DEF_COLOR = Color.YELLOW;
	}
	
	public Plate(Color color) {
		this.number = counter++;
		this.color = color;
	}
	
	public Plate() {
		this(DEF_COLOR);
	}

	@Override
	public String toString() {
		return "Plate [number=" + number + ", color=" + color + "]";
	}
	
}

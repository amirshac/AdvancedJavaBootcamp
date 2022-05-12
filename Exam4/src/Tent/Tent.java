package Tent;

public class Tent {
	protected int numPeople;
	protected double width;
	protected double height;
	protected double length;
	
	public Tent(int numPeople, double width, double length, double height) {
		super();
		this.numPeople = numPeople;
		this.width = width;
		this.length = length;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tent [numPeople=" + numPeople + ", width=" + width + ", length=" + length + ", height=" + height + "]";
	}

	public int getNumPeople() {
		return numPeople;
	}

	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getArea() {
		return width * length;
	}
}

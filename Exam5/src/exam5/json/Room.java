package exam5.json;

public class Room {
	double width;
	double length;
	boolean hasAC;
	
	// empty constructor for security during deserialization
	public Room() {
		
	}
	
	public Room(double width, double length, boolean hasAC) {
		super();
		this.width = width;
		this.length = length;
		this.hasAC = hasAC;
	}

	@Override
	public String toString() {
		return "Room [width=" + width + ", length=" + length + ", hasAC=" + hasAC + "]";
	}
}

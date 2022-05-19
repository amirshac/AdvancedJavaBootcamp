package exam5.json;

import java.util.List;

public class House {
	protected Address address;
	protected List<Room> rooms;
	boolean hasYard;
	boolean hasBasement;
	double area;
	
	// empty constructor for security during deserialization
	public House() {}
	
	public House(Address address, List<Room> rooms, boolean hasYard, boolean hasBasement, double area) {
		super();
		this.address = address;
		this.rooms = rooms;
		this.hasYard = hasYard;
		this.hasBasement = hasBasement;
		this.area = area;
	}

	@Override
	public String toString() {
		return "House [address=" + address + ", rooms=" + rooms + ", hasYard=" + hasYard + ", hasBasement="
				+ hasBasement + ", area=" + area + "]";
	}
	
	
}

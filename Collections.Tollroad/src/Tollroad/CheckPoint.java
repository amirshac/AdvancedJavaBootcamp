package Tollroad;

public class CheckPoint {
	protected String name;
	protected String address;
	protected int position;
	
	public CheckPoint(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.position = 0;
	}
	
	public void setPosition(int pos) {
		this.position = pos;
	}

	@Override
	public String toString() {
		return "CheckPoint [name=" + name + ", address=" + address + ", position=" + position + "]\n";
	}
	
	
}

package networking.tcp.ex2.tracking.client;

public class TrackingDevice {
	private static int counter = 0;
	
	private int ID;
	private Location location;
	
	public TrackingDevice() {
		ID = counter++;
		location = new Location(Location.randomLocation());
	}
	
	public void shiftLocationRandomly() {
		this.location.shiftLocationRandomly();
	}
	
	@Override
	public String toString() {
		return "TrackingDevice [ID=" + ID + ", location=" + location + "]";
	}
	
	public String reportString() {
		return (this.ID + location.reportString());
	}
}

package networking.tcp.ex2.tracking.server;

import networking.tcp.ex2.tracking.client.Location;

public class Report {
	private int ID;
	private Location location;
	
	public Report(int iD, Location location) {
		ID = iD;
		this.location = location;
	}
}

package networking.tcp.ex2.tracking.client;

import java.time.LocalDateTime;
import java.util.Random;

public class Location {
	
	private static final double DEFAULT_LONGITUDE = 0.0;
	private static final double DEFAULT_ALTITUDE = 0.0;
	
	private static Random random;
	
	static {
		random = new Random();
	}
	
	private double longitude;
	private double altitude;
	private LocalDateTime timeStamp;
	
	public Location(double longitude, double altitude, LocalDateTime timeStamp) {
		this.longitude = longitude;
		this.altitude = altitude;
		this.timeStamp = timeStamp;
	}
	
	public Location() {
		this(DEFAULT_LONGITUDE, DEFAULT_ALTITUDE, LocalDateTime.now());
	}
	
	public Location(Location location) {
		this(location.longitude, location.altitude, location.timeStamp);
	}
	
	public void updateStats() {
		timeStamp = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", altitude=" + altitude + ", timeStamp=" + timeStamp + "]";
	}
	
	public String reportString() {
		return " " + longitude + " " + altitude + " " + timeStamp;
	}
	
	public void shiftLocationRandomly() {
		final double MIN_SHIFT = -10;
		final double MAX_SHIFT = 10;
		
		double shift;
		shift = random.nextDouble(MIN_SHIFT,MAX_SHIFT);
		this.longitude += shift;
		
		shift = random.nextDouble(MIN_SHIFT,MAX_SHIFT);
		this.altitude += shift;
	}
	
	public static Location randomLocation() {
		final double MIN_RANDOM_LONGITUDE = -1000;
		final double MAX_RANDOM_LONGITUDE = 1000;
		final double MIN_RANDOM_ALTITUDE = -1000;
		final double MAX_RANDOM_ALTITUDE = 1000;
		
		double randomLogitude = random.nextDouble(MIN_RANDOM_LONGITUDE, MAX_RANDOM_LONGITUDE);
		double randomAltitude = random.nextDouble(MIN_RANDOM_ALTITUDE, MAX_RANDOM_ALTITUDE);
		return new Location(randomLogitude,randomAltitude, LocalDateTime.now());
	}
}

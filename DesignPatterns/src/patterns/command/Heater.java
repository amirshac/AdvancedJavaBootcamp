package patterns.command;

import java.time.LocalTime;

public class Heater {
	private static final int MAX_MINUTES = 90;
	protected int minutes;
	protected boolean active;
	
	public void turnOn(int minutes) {
		setMinutes(minutes);
		active = true;
		System.out.println("<Heater> turned on for " + this.minutes +" minutes at " + LocalTime.now());
	}
	
	public void turnOff() {
		active = false;
		System.out.println("<Heater> turned off at " + LocalTime.now());
	}
	
	public void setMinutes(int minutes) {
		if (minutes > MAX_MINUTES)
			minutes = MAX_MINUTES;
		else if (minutes < 0)
			minutes = 0;
		
		this.minutes = minutes;
	}

}

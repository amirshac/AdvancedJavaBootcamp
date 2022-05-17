package patterns.command;

import java.time.LocalTime;

public abstract class Command {
	
	protected Heater heater;
	protected LocalTime time;
	
	Command (Heater heater){
		this.heater = heater;
		this.time = LocalTime.now();
	}
	
	public abstract void execute();

	@Override
	public String toString() {
		return "Command [time=" + time + "]";
	}
	
	
}

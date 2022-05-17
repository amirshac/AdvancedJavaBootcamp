package patterns.command;

public class OnCommand extends Command {

	private static final int MAX_MINUTES = 90;
	
	protected int minutes;
	
	OnCommand(Heater heater, int minutes) {
		super(heater);
		setMinutes(minutes);
	}

	protected void setMinutes(int minutes) {
		if (minutes > MAX_MINUTES)
			minutes = MAX_MINUTES;
		else if (minutes < 0)
			minutes = 0;
		
		this.minutes = minutes;
	}
	
	@Override
	public void execute() {
		heater.turnOn(minutes);
	}

	@Override
	public String toString() {
		return "OnCommand [minutes=" + minutes + ", time=" + this.time +"]";
	}
}

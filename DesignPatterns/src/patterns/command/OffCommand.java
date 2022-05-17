package patterns.command;

public class OffCommand extends Command{

	OffCommand(Heater heater) {
		super(heater);
	}

	@Override
	public void execute() {
		heater.turnOff();
	}

	@Override
	public String toString() {
		return "OffCommand [time=" + time + "]";
	}

	
}

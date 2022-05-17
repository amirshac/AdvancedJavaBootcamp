package patterns.command;

public class HeaterApp {
	
	private static final int RECENT_HISTORY_SIZE = 5;
	
	protected Heater heater;
	protected CommandHistory history;
	
	
	public HeaterApp(Heater heater) {
		this.heater = heater;
		history = new CommandHistory();
	}
	
	public void turnOn(int minutes) {
		executeCommand(new OnCommand(heater, minutes));
	}
	
	public void turnOff() {
		executeCommand(new OffCommand(heater));
	}

	private void executeCommand(Command command) {
		command.execute();
		history.add(command);
	}
	
	public void showHistory() {
		history.getHistory().forEach(c->System.out.println(c));
	}
	
	public void showRecentHistory() {
		history.getRecentHistory(RECENT_HISTORY_SIZE).forEach(c->System.out.println(c));
	}
}

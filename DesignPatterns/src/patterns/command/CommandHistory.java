package patterns.command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
	
	protected List<Command> history;
	
	public CommandHistory() {
		history = new ArrayList<Command>();
	}
	
	public void add (Command c) {
		history.add(c);
	}
	
	public List<Command> getHistory(){
		return history;
	}
	
	public List<Command> getRecentHistory(int numberCommands){	
		List<Command> recentHistory = new ArrayList<Command>();
		
		if (history.size() <= numberCommands)
			return history;
		
		if (history.size() > numberCommands) {
			recentHistory = history.subList(history.size()-numberCommands, history.size());	
		}
		
		return recentHistory;
	}
	
	public boolean isEmpty() {
		return history.isEmpty();
	}
}

package patterns.state;

public abstract class State {
	Dispenser dispenser;
	
	public State(Dispenser dispenser) {
		this.dispenser = dispenser;
	}
	
	public abstract void onFive();
	public abstract void onTen();
	public abstract void onGet();

	@Override
	public String toString() {
		return "State";
	}
	
	
}

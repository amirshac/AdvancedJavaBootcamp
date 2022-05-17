package patterns.state;

public class EmptyState extends State{

	public EmptyState(Dispenser dispenser) {
		super(dispenser);
		dispenser.sum = 0;
	}

	@Override
	public void onFive() {
		dispenser.sum += 5;
		dispenser.changeState(new FillingState(dispenser));
	}

	@Override
	public void onTen() {
		dispenser.sum += 10;
		dispenser.changeState(new FillingState(dispenser));
	}

	@Override
	public void onGet() {
		System.out.println("Dispenser is empty");	
	}

	@Override
	public String toString() {
		return "State: EMPTY";
	}
}

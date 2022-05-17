package patterns.state;

public class FillingState extends State{
	
	public FillingState(Dispenser dispenser) {
		super(dispenser);
	}

	@Override
	public void onFive() {
		dispenser.sum += 5;
		checkAlmostFull();
	}

	@Override
	public void onTen() {
		dispenser.sum += 10;
		checkAlmostFull();
	}
	
	private void checkAlmostFull() {
		if (dispenser.sum - dispenser.getGumPrice() <= dispenser.MAX_COIN ) {
			dispenser.changeState(new AlmostFullState(dispenser));
		}
	}

	@Override
	public void onGet() {
		System.out.println("Dispenser still needs more money, price is " + dispenser.getGumPrice());	
	}

	@Override
	public String toString() {
		return "State: FILLING";
	}
}

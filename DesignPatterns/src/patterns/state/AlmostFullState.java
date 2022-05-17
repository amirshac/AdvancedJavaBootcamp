package patterns.state;

public class AlmostFullState extends State{

	public AlmostFullState(Dispenser dispenser) {
		super(dispenser);
	}
	
	@Override
	public void onFive() {
		dispenser.sum += 5;
		if (dispenser.getSum() == dispenser.getGumPrice()) {
			dispenser.changeState(new FullState(dispenser));
		}
	}

	@Override
	public void onTen() {
		if (dispenser.getSum() + 10 > dispenser.getGumPrice()) {
			System.out.println("Too much! Need exact change");
		} else if (dispenser.getSum() + 10 == dispenser.getGumPrice()) {
			dispenser.changeState(new FullState(dispenser));
		}
	}

	@Override
	public void onGet() {
		System.out.println("Dispenser still needs more money " + dispenser.getGumPrice());	
	}

	@Override
	public String toString() {
		return "State: ALMOST FULL";
	}
}

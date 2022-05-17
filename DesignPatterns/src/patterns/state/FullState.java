package patterns.state;

public class FullState extends State{

	public FullState(Dispenser dispenser) {
		super(dispenser);
	}

	@Override
	public void onFive() {
		System.out.println("Dispenser full, get your gum!");
		
	}

	@Override
	public void onTen() {
		System.out.println("Dispenser full, get your gum!");		
	}

	@Override
	public void onGet() {
		dispenser.dispenseGum();
		dispenser.changeState(new EmptyState(dispenser));
	}
	
	@Override
	public String toString() {
		return "State: FULL";
	}
}

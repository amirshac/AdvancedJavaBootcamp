package patterns.state;

public class Dispenser {
	private static final int GUM_PRICE = 25;
	static final int MAX_COIN = 10;
	
	private State state;
	protected int sum;
	
	public Dispenser(){
		this.state = new EmptyState(this);
		sum = 0;
	}
	
	public void changeState(State state) {
		this.state = state;
	}
	
	public void dispenseGum() {
		System.out.println("<Dispenser> dispensing gum");
	}
	
	public int getGumPrice() {
		return GUM_PRICE;
	}
	
	public int getSum() {
		return sum;
	}
	
	public State getState() {
		return state;
	}

	@Override
	public String toString() {
		return "Dispenser [state=" + state + ", sum=" + sum + ", gumprice =" + getGumPrice() + "]";
	}
	

}

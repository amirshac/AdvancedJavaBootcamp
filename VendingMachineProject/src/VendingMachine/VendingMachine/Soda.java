package VendingMachine.VendingMachine; 

public class Soda extends ColdDrink{
	
	protected ContainerType container;
	
	private static String DEF_NAME = "Soda";
	
	// constructors
	public Soda() {
		this(DEF_NAME);
	}
	
	public Soda(String name) {
		setName(name);
		setContainer(ContainerType.CAN);
	}
	
	public void setContainer(ContainerType container) {
		this.container = container;
	}
	
	@Override
	public String toString() {
		String msg = new String();
		msg = super.toString();
		msg += String.format("%n<SodaClass> container: %s", this.container);
		return msg;
	}
	
	@Override
	public void produce() {
		super.produce();
	}
	
	enum ContainerType{
		CAN,
		BOTTLE
	}
}

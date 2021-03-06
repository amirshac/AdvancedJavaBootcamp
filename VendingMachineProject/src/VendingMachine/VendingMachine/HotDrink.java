package VendingMachine.VendingMachine;

import VendingMachine.Runner.VendingMachine;

public abstract class HotDrink extends Drink{
	
	// fields
	private static int DEF_SUGAR = 1;
	private static int MIN_SUGAR = 0;
	private static int MAX_SUGAR = 5;

	private static int DEF_TEMPRATURE = 70;
	private static int MIN_TEMPRATURE = 60;
	private static int MAX_TEMPRATURE = 90;
	
	protected HotDrinkType type;
	protected HotDrinkBase base;
	
	protected int sugarTeaspoons;
	protected int milkVolume;
	
	// constructors
	public HotDrink() {
		setTemprature(DEF_TEMPRATURE);
		setSugarTeaspoons(DEF_SUGAR);
		this.milkVolume = 0;
		this.type = HotDrinkType.COFFEE;
		this.base = HotDrinkBase.WATER;
	}
	
	// setters
	
	public void setSugarTeaspoons(int sugarTeaSpoons) {
		if (sugarTeaSpoons > MAX_SUGAR)
			sugarTeaspoons = DEF_SUGAR;
		else if (sugarTeaSpoons < MIN_SUGAR)
			sugarTeaspoons = DEF_SUGAR;
		
		this.sugarTeaspoons = sugarTeaSpoons;
	}
	
	@Override
	public void setTemprature(int temprature) {
		if (temprature > MAX_TEMPRATURE)
			this.temprature = DEF_TEMPRATURE;
		else if (temprature < MIN_TEMPRATURE)
			this.temprature = DEF_TEMPRATURE;
	}
	
	public void setMilk(int milk) {
		this.milkVolume = milk;
	}
	
	@Override 
	public String toString() {
		String msg = new String();
		msg += super.toString();
		msg += String.format("%n<HotDrinkClass> Type: %s, Base: %s, Sugar: %d, Milk: %d", this.type, this.base, this.sugarTeaspoons, this.milkVolume);
		return msg;
	}
	
	@Override
	public void produce() {

		super.produce();
		
		if (this.milkVolume > 0)
			produceWithMilk();
	}
	
	private void produceWithMilk() {
		System.out.println("Using milk: "+ this.milkVolume);
		System.out.println();
		
		if (VendingMachine.milkQtt < this.milkVolume) {
			produced = false;
			VendingMachine.inService = false;
			System.out.println("Not enough Milk");
		}else {
			VendingMachine.milkQtt -= this.milkVolume;
			produced = true;
		}
	}
	
	enum HotDrinkType{
		COFFEE,
		CHOCOLATE
	}
	
	enum HotDrinkBase{
		WATER,
		MILK
	}
}

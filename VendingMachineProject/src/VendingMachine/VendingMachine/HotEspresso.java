package VendingMachine.VendingMachine;

public class HotEspresso extends HotDrink{
	
	private static String DEF_NAME = "Hot Espresso";
	private static int DEF_SHOT_VOLUME = 50;
	private static int MAX_SHOTS = 3;
	private static int MIN_SHOTS = 1;
	private static int DEF_SHOTS = 1;
	
	private static int DEF_MILK_VOLUME = 0;

	private int shots;
	private int coffeeVolume;
	
	public HotEspresso() {
		this(DEF_SHOTS);
	}
	
	public HotEspresso(int shots) {
		setName(DEF_NAME);
		setShotsAndCoffeeVolume(shots);
		setVolume(coffeeVolume);
		setMilk(DEF_MILK_VOLUME);
		this.type = HotDrinkType.COFFEE;
		this.base = HotDrinkBase.WATER;
	}
	
	public void setShotsAndCoffeeVolume(int shots) {
		if (shots > MAX_SHOTS) 
			shots = MAX_SHOTS; 
		else if (shots < MIN_SHOTS) 
			shots = MIN_SHOTS;	
			
		this.shots = shots;
		
		coffeeVolume = this.shots * DEF_SHOT_VOLUME;
	}
}

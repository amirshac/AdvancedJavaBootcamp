package VendingMachine.VendingMachine;

public class HotChocolate extends HotDrink{
	
	private static int DEF_MILK_VOLUME = 200;
	private static int DEF_WATER_VOLUME = 0;
	private static String DEF_NAME = "Hot Chocolate";
	
	public HotChocolate(){
		this.setName(DEF_NAME);
		this.volume = DEF_WATER_VOLUME;
		this.milkVolume = DEF_MILK_VOLUME;
		this.base = HotDrinkBase.MILK;
		this.type = HotDrinkType.CHOCOLATE;
	}

}

package VendingMachine.VendingMachine;

public class SoftDrink extends ColdDrink{
	
	private static String DEF_NAME = "SoftDrink";
	private static int DEF_SOFTDRINK_VOLUME = 150;
	
	SoftDrinkType drinkType;
	
	public SoftDrink() {
		setName(DEF_NAME);
		this.setVolume(DEF_SOFTDRINK_VOLUME);
		drinkType = SoftDrinkType.SQUEEZED;
	}
	
	@Override
	public String toString() {
		String msg = new String();
		msg += super.toString();
		msg += String.format("%n<SoftDrinkClass> type: %s", this.drinkType);
		return msg;
	}
	
	enum SoftDrinkType {
			SQUEEZED,
			PASTURIZED
	}
}

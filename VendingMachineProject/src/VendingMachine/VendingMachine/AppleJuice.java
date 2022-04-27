package VendingMachine.VendingMachine;

public class AppleJuice extends SoftDrink{
	private static String DEF_NAME = "Apple Juice";
	
	public AppleJuice() {
		this.setName(DEF_NAME);
		this.ingridient = IngridientType.APPLE;
		this.drinkType = SoftDrinkType.PASTURIZED;
	}
}

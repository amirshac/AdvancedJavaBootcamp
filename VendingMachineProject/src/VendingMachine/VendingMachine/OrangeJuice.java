package VendingMachine.VendingMachine;

public class OrangeJuice extends SoftDrink{

	private static String DEF_NAME = "Orange Juice";
	
	public OrangeJuice() {
		setName(DEF_NAME);
		this.setIngridient(IngridientType.ORANGE);
		this.drinkType = SoftDrinkType.SQUEEZED;
	}
}

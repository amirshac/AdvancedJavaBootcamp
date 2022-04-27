package VendingMachine.VendingMachine;

public class SodaWater extends Soda {
	private static String DEF_NAME = "SodaWater";
	
	private static float DEF_SODAWATER_PRICE = 3.5f;
	
	public SodaWater() {
		super(DEF_NAME);
		setPrice(DEF_SODAWATER_PRICE);
		setIngridient(IngridientType.WATER);
	}
}

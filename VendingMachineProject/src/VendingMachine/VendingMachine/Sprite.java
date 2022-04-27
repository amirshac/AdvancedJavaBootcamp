package VendingMachine.VendingMachine;

public class Sprite extends Soda {
	private static String DEF_NAME = "Sprite";
	private static float DEF_SPRITE_PRICE = 9f;
	
	public Sprite() {
		setName(DEF_NAME);
		setIngridient(IngridientType.LIME_SYRUP);
		setPrice(DEF_SPRITE_PRICE);
	}

	@Override
	public void produce() {
		super.produce();
	}

	

}

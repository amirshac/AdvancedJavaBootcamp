package VendingMachine.VendingMachine;

public class Cola extends Soda {
	
	private static String DEF_NAME = "Cola";
	private static float DEF_COLA_PRICE = 9f;
	private static int DEF_COLA_VOLUME = 200;
	
	public Cola() {
		setName(DEF_NAME);
		setIngridient(IngridientType.COLA_SYRUP);
		setContainer(ContainerType.BOTTLE);
		setPrice(DEF_COLA_PRICE);
		setVolume(DEF_COLA_VOLUME);
	}

}

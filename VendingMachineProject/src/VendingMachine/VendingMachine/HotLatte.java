package VendingMachine.VendingMachine;

public class HotLatte extends HotEspresso{
		
	private static String DEF_NAME = "Hot Latte";
	private static int DEF_TOTAL_VOLUME = 200;
	private static int ESPRESSO_SHOTS = 1;

	public HotLatte() {
			super(ESPRESSO_SHOTS);
			setName(DEF_NAME);
			setMilk(DEF_TOTAL_VOLUME - this.volume);
		}

}

package VendingMachine.VendingMachine;

public class ColdDrink extends Drink{
	
	//fields
	protected IngridientType ingridient;
	
	private static int MIN_TEMPRATURE = 2;
	private static int MAX_TEMPRATURE = 5;
	private static int DEF_TEMPRATURE = 3;
	
	private static String DEF_NAME = "ColdDrink";
	private static IngridientType DEF_INGRIDIENT = IngridientType.WATER;
	
	// contrustors
	public ColdDrink() {
		setName(DEF_NAME);
		setTemprature(DEF_TEMPRATURE);
		setIngridient(DEF_INGRIDIENT);
	}
	
	@Override
	public void setTemprature(int temprature) {
		if (temprature < MIN_TEMPRATURE)
			this.temprature = MIN_TEMPRATURE;
		else if (temprature > MAX_TEMPRATURE)
			this.temprature = MAX_TEMPRATURE;
	}
	
	public void setIngridient(IngridientType ingridient) {
		this.ingridient = ingridient;
	}
	
	
	@Override
	public String toString() {
		String msg = new String();
		msg = super.toString();
		msg += String.format("%n<ColdDrinkClass> ingridient: %s ", this.ingridient);
		return msg;
	}

	enum IngridientType{
		WATER,
		COLA_SYRUP,
		LIME_SYRUP,
		ORANGE,
		APPLE
	}
}

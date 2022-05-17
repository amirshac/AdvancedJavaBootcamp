package patterns.builder;

public class Director {
	
	private final String HAWAIIAN_PASTRY_NAME = "Hawaiian Pizza";
	private final String DOMINICAN_PASTRY_NAME = "Dominican Puff-Pastry";
	
	private final int HAWAIIAN_MOZARELLA_CHEESE = 100;
	private final int HAWAIIAN_FETA_CHEESE = 40;
	private final int HAWAIIAN_MUSHROOMS = 20;
	private final int HAWAIIAN_PINEAPPLE = 100;

	
	private final int DOMINICAN_MOZARELLA_CHEESE = 10;
	private final int DOMINICAN_FETA_CHEESE = 100;
	private final int DOMINICAN_MUSHROOMS = 20;
	private final int DOMINICAN_PINEAPPLE = 15;

	public void constructHawaiian(Builder builder) {
		builder.reset();
		builder.setName(HAWAIIAN_PASTRY_NAME);
		builder.setMozarellaCheese(HAWAIIAN_MOZARELLA_CHEESE);
		builder.setFetaCheese(HAWAIIAN_FETA_CHEESE);
		builder.setMushrooms(HAWAIIAN_MUSHROOMS);
		builder.setPineapple(HAWAIIAN_PINEAPPLE);
	}
	
	public void constructDominican(Builder builder) {
		builder.reset();
		builder.setName(DOMINICAN_PASTRY_NAME);
		builder.setMozarellaCheese(DOMINICAN_MOZARELLA_CHEESE);
		builder.setFetaCheese(DOMINICAN_FETA_CHEESE);
		builder.setMushrooms(DOMINICAN_MUSHROOMS);
		builder.setPineapple(DOMINICAN_PINEAPPLE);		
	}
}

package patterns.builder;

public abstract class BakeryIngridientProduct {
	protected String name;
	protected int mozzarellaCheese;
	protected int fetaCheese;
	protected int mushrooms;
	protected int pineapple;
	
	public BakeryIngridientProduct(String name, int mozzarellaCheese, int fetaCheese, int mushrooms, int pineapple) {
		this.name = name;
		this.mozzarellaCheese = mozzarellaCheese;
		this.fetaCheese = fetaCheese;
		this.mushrooms = mushrooms;
		this.pineapple = pineapple;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "IngridientProduct [name=" + name + ", mozzarellaCheese=" + mozzarellaCheese + ", fetaCheese=" + fetaCheese
				+ ", mushrooms=" + mushrooms + ", pineapple=" + pineapple + "]";
	}

}

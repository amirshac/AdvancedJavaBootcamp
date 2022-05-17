package patterns.builder;

public class Recipe extends BakeryIngridientProduct{

	public Recipe(String name, int mozzarellaCheese, int fetaCheese, int mushrooms, int pineapple) {
		super(name, mozzarellaCheese, fetaCheese, mushrooms, pineapple);
	}

	@Override
	public String toString() {
		return "Recipe " + super.toString();
	}
	
}

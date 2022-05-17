package patterns.builder;

public class Pastry extends BakeryIngridientProduct{

	public Pastry(String name, int mozzarellaCheese, int fetaCheese, int mushrooms, int pineapple) {
		super(name, mozzarellaCheese, fetaCheese, mushrooms, pineapple);
	}
	
	@Override
	public String toString() {
		return "Pastry " + super.getName();
	}
}

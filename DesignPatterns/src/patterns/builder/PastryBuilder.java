package patterns.builder;

public class PastryBuilder implements Builder{

	protected String name;
	protected int mozzarellaCheese;
	protected int fetaCheese;
	protected int mushrooms;
	protected int pineapple;
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setMozarellaCheese(int grams) {
		this.mozzarellaCheese = grams;
	}

	@Override
	public void setFetaCheese(int grams) {
		this.fetaCheese = grams;
	}

	@Override
	public void setMushrooms(int grams) {
		this.mushrooms = grams;		
	}

	@Override
	public void setPineapple(int grams) {
		this.pineapple = grams;
	}
	
	@Override
	public void reset() {
		this.mozzarellaCheese = 0;
		this.fetaCheese = 0;
		this.mushrooms = 0;
		this.pineapple = 0;
	}
	
	public Pastry getResult() {
		return new Pastry(name,mozzarellaCheese,fetaCheese,mushrooms,pineapple);
	}

}

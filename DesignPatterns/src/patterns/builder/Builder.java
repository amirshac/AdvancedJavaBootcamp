package patterns.builder;

public interface Builder {
	void setName(String name);
	void setMozarellaCheese(int grams);
	void setFetaCheese(int grams);
	void setMushrooms(int grams);
	void setPineapple(int grams);
	void reset();
}

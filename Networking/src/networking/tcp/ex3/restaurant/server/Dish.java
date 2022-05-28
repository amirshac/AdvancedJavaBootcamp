package networking.tcp.ex3.restaurant.server;

public class Dish {
	String name;
	double price;
	
	public Dish(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + "]";
	}
}


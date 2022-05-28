package networking.tcp.ex3.restaurant.server;

public class OrderPrice {
	protected double price;

	public OrderPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderPrice [price=" + price + "]";
	}

}

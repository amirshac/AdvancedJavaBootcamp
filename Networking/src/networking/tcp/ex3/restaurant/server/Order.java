package networking.tcp.ex3.restaurant.server;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private static int orderID = 0;
	
	protected int number;
	protected List<Dish> dishes;
	
	public Order() {
		number = orderID++;
		dishes = new ArrayList<Dish>();
	}
	
	public void addDish(Dish dish) {
		dishes.add(dish);
	}
	
	public List<Dish> getDishes(){
		return this.dishes;
	}
	
}

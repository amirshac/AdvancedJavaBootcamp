package networking.tcp.ex3.restaurant.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DishDB {
	private static Random random = new Random();
	
	private final static Map<String, Dish> dishes = new HashMap<>() {
		{
			put(DishName.JERKY.name(), new Dish(DishName.JERKY.name(), 15.5));
			put(DishName.SALAD.name(), new Dish(DishName.SALAD.name(), 28.5));
			put(DishName.ROAST.name(), new Dish(DishName.ROAST.name(), 66.4));
			put(DishName.BURGER.name(), new Dish(DishName.BURGER.name(), 45.5));
			put(DishName.POTATO.name(), new Dish(DishName.POTATO.name(), 17.3));
			put(DishName.TOAST.name(), new Dish(DishName.TOAST.name(), 22.8));
			put(DishName.MILKSHAKE.name(), new Dish(DishName.MILKSHAKE.name(), 32.4));
			put(DishName.COKE.name(), new Dish(DishName.COKE.name(), 8.8));
			put(DishName.LEMONADE.name(), new Dish(DishName.LEMONADE.name(), 9.9));
		}
	};
	
	public static Dish getDishByName(String name) throws IllegalArgumentException {
		Dish dish = dishes.get(name.toUpperCase());
		if (dish==null)
			throw new IllegalArgumentException("Dish not found in DB");
		
		return dish;
	}
	
	public static Dish getRandomDish() {
		int dishNumber = random.nextInt(DishName.values().length);
		String dishName = DishName.values()[dishNumber].name();
		Dish dish = dishes.get(dishName);
		
		return dish;
	}
	
	public static void printDB() {
		dishes.forEach( (k,v) -> System.out.println(k + ":" + v));
	}
	
	public static void main(String[] args) {
		printDB();
	}
}

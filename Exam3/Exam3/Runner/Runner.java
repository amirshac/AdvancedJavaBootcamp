package Runner;

import java.time.LocalDate;

import DragonDinner.Dragon;
import DragonDinner.Food;
import DragonDinner.Food.Macro;
import DragonDinner.Food.Taste;

public class Runner {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food food1 = new Food("Burger", Taste.SALTY, Macro.FAT);
		Food food2 = new Food("Chicken", Taste.SOUR, Macro.PROTEIN);
		Dragon dragon1 = new Dragon("Uzuki", LocalDate.of(888, 8, 8), 10);
		Dragon dragon2 = new Dragon("Uldiun", LocalDate.of(1934, 12, 5), 2);


	}

}

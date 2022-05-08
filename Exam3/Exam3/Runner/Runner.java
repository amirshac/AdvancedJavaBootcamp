package Runner;

import java.time.LocalDate;

import DragonDinner.Dragon;
import DragonDinner.Food;
import DragonDinner.ObjectReaderWriter;
import DragonDinner.Food.Macro;
import DragonDinner.Food.Taste;
import DragonDinner.NonCapitalizedException;

public class Runner {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food food1 = new Food("Burger", Taste.SALTY, Macro.FAT);
		Food food2 = new Food("Chicken", Taste.SOUR, Macro.PROTEIN);
		Dragon dragon1 = new Dragon("Uzuki", LocalDate.of(888, 8, 8), 10);
		Dragon dragon2 = new Dragon("Uldiun", LocalDate.of(1934, 12, 5), 2);
		
		
		Object objArr[] = new Object[] {
				food1,
				food2,
				dragon1,
				dragon2
		};
		
		int numObjectsToSave = 2;
		
		ObjectReaderWriter.saveRandomObjectsToFile(objArr, numObjectsToSave);
		
		ObjectReaderWriter.printObjectsFromFile();
		
		try {
			food1.setName("hotdog");
		} catch (NonCapitalizedException e) {
			System.out.println(e);
		}
		
		try {
			food1.setName("Hotdog");
		} catch (NonCapitalizedException e) {
			System.out.println(e);
		}
		
		// too young exception
		dragon1.setBirthDate(LocalDate.of(888, 8, 7));
		
	}

}

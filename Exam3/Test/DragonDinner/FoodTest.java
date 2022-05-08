package DragonDinner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import DragonDinner.Food.Macro;
import DragonDinner.Food.Taste;

@TestInstance(Lifecycle.PER_METHOD)

class FoodTest {

	protected Food[] foodArr;
	
	public FoodTest() {
		populateFoodArr();
	}
	
	void populateFoodArr() {
		foodArr = new Food[] {
				new Food("Burger", Taste.SALTY, Macro.FAT),
				new Food("Chicken", Taste.BITTER, Macro.PROTEIN),
				new Food("Milkshake", Taste.SWEET, Macro.CARB)
		};
	}
	
	@Test
	@DisplayName("setName sets name properly (no exceptions thrown)")
	
	void testSetName() {
		String[] expectedName = new String[] {
			"Murger",
			"Bicken",
			"Moonshake"
		};
		
		try {
			foodArr[0].setName("Murger");
			foodArr[1].setName("Bicken");
			foodArr[2].setName("Moonshake");
		}catch (Exception e) {
			System.out.println(e);
		}
		
		for (int i=0; i<foodArr.length; i++) {
			assertEquals(foodArr[i].name, expectedName[i]);
		}
	}

	@Test
	@DisplayName("setName throws exception")
	
	void testSetNameException() {
		Exception exception = null;
		exception = assertThrows(Exception.class, ()->foodArr[0].setName("little"));
	}
	
	@Test
	@DisplayName("Test isDesert")
	
	void testIsSweet() {
		boolean[] expectedDesert = new boolean[] {
				false,
				false,
				true
		};
		
		for (int i=0; i<foodArr.length; i++) {
			assertEquals(foodArr[i].isDesert(), expectedDesert[i]);
		}
	}
	
}

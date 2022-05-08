package DragonDinner;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_METHOD)

class DragonTest {

	protected Dragon[] dragonArr;
	
	public DragonTest() {
		populateDragonArr();
	}
	
	void populateDragonArr() {
		dragonArr = new Dragon[] {
				new Dragon("Uzuki", LocalDate.of(888, 8, 8), 10),
				new Dragon("Uldiun", LocalDate.of(1934, 12, 5), 2),
				new Dragon("Munchkin", LocalDate.of(1934, 12, 5), 0)
		};
	}
	
	@Test
	@DisplayName("setAge throws exception")
	
	void testSetAgeException() {
		Exception exception = null;
		LocalDate date;
		
		date = LocalDate.of(888, 8, 7);
		exception = assertThrows(Exception.class, ()-> dragonArr[0].setBirthDate(date) );		
	}

}

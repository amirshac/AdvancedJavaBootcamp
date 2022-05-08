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
	@DisplayName("setAge works properly")
	void testSetAge() {
		LocalDate date;
		date = LocalDate.of(888, 8, 8);
		
		try {
			dragonArr[0].setBirthDate(date);
		}catch (TooYoungException e) {
			fail("shouldn't throw exception");
		}
	}
	
	@Test
	@DisplayName("setAge throws exception")
	
	void testSetAgeException() {
		Exception exception;
		LocalDate date;
		
		date = LocalDate.of(888, 8, 7);
		exception = assertThrows(TooYoungException.class, ()-> dragonArr[0].setBirthDate(date) );		
	}
	
	@Test
	@DisplayName("setAge throws exception test 2")
	
	void testSetAgeException2() {
		LocalDate date;
		date = LocalDate.of(888, 7, 8);
		TooYoungException expectedException = new TooYoungException();
		
		try {
			dragonArr[0].setBirthDate(date);
			fail("SetAge didnt throw exception");
		}catch (TooYoungException e) {
			assertEquals(e.getClass(), expectedException.getClass() );
		}
				
	}

}

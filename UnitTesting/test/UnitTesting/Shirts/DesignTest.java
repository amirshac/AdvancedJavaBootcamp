package UnitTesting.Shirts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import UnitTesting.Shirts.Color;
import UnitTesting.Shirts.Design;

@TestInstance(Lifecycle.PER_CLASS)

class DesignTest {
	Design design;
	
	public DesignTest() {
		design = new Design();
	}
	
	
	@Test
	@DisplayName("Design empty constructor valid default values")

	void emptyConstructorValid() {
		assertNotNull(design);
		assertEquals(20, design.width);
		assertEquals(10, design.height);
		assertEquals(1, design.complexity);
		assertEquals("Slogan", design.slogan);
		assertEquals(20*10, design.area);
		assertTrue(design.color.equals(new Color(100, 100, 100)));
	}
	
	@Test
	@DisplayName("Design set method works as expected")
	
	void checkSetMethods() {
		design.setWidth(19);
		assertEquals(20, design.width);
		
		design.setWidth(200);
		assertEquals(30, design.width);
		
		design.setHeight(-100);
		assertEquals(10, design.height);
		
		design.setHeight(4332);
		assertEquals(25, design.height);
		
		design.setComplexity(0);
		assertEquals(1, design.complexity);
		
		design.setComplexity(102);
		assertEquals(100, design.complexity);
		
		design.setColor(10, 20, 30);
		assertEquals(10, design.color.red);
		assertEquals(20, design.color.green);
		assertEquals(30, design.color.blue);
		
		design.setColor(-122, -1, -24);
		assertEquals(0, design.color.red);
		assertEquals(0, design.color.green);
		assertEquals(0, design.color.blue);

		design.setColor(4441, 2422, 267);
		assertEquals(255, design.color.red);
		assertEquals(255, design.color.green);
		assertEquals(255, design.color.blue);
		
		design.setSlogan("NewSlog");
		assertEquals("NewSlog", design.slogan);
	}

	@Test
	@DisplayName("Design area is calculated properly")
	
	void testAreaCalculation() {
		design = new Design();
		assertEquals(20*10,design.area);
		
		design.setWidth(30);
		assertEquals(30*10,design.area);
		
		design.setHeight(25);
		assertEquals(30*25,design.area);
		
		design.setWidth(-10);
		design.setHeight(-1);
		assertEquals(20*10,design.area);
		
		design.setWidth(9000);
		design.setHeight(33223);
		assertEquals(30*25, design.area);
		
		for (int i=20; i<=30; i++){
			design.setWidth(i);
			for (int j=10; j<=25; j++) {
				design.setHeight(j);
				assertEquals(i*j, design.area);
			}
		}
		
	}
}

package Testing.Shirts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import Testing.Shirts.Shirt.SIZE;

@TestInstance(Lifecycle.PER_CLASS)

class ShirtTest {

	Shirt shirt;
	public ShirtTest() {
		shirt = new Shirt();
	}
	
	@Test
	@DisplayName("Shirt empty constructor field validation")
	void testEmptyConstructor() {
		assertNotNull(shirt);
		assertEquals(shirt.basePrice, 3);
		assertEquals(shirt.demandFactor, 1);
		assertEquals(shirt.size, SIZE.L);
	}

	@Test
	@DisplayName("Shirt set methods validation")
	void testSetMethods() {
		shirt = new Shirt();
	
		shirt.setBasePrice(987654);
		assertEquals(shirt.basePrice, 987654);
		
		shirt.setBasePrice(-10);
		assertEquals(shirt.basePrice, 3);
		
		shirt.setDemandFactor(-8);
		assertEquals(shirt.demandFactor, 0.1);
		
		shirt.setDemandFactor(0);
		assertEquals(shirt.demandFactor, 0.1);
		
		shirt.setDemandFactor(2);
		assertEquals(shirt.demandFactor, 1);
		
		shirt.setDemandFactor(0.512);
		assertEquals(shirt.demandFactor, 0.512);
		
		shirt.setSize(SIZE.XS);
		assertEquals(shirt.size, SIZE.XS);
		
		shirt.setSize(SIZE.XL);
		assertEquals(shirt.size, SIZE.XL);
	}

	@Test
	@DisplayName("Shirt is expensive check and final price calculation")
	void testIsExpensiveAndFinalPriceCalculation() {
		shirt = new Shirt();
		double finalPriceCalculation = 0;
		String msg = "";
		
		for (int i=3; i<100; i++) {
			shirt.setBasePrice(i);
			
			finalPriceCalculation = (i+shirt.design.complexity) * shirt.design.calculateArea() / shirt.demandFactor;
			
			msg = String.format("Base Price: %f -> FinalPrice: %f. isExpensive? %b", shirt.basePrice, finalPriceCalculation, shirt.isExpensive() );
			System.out.println(msg);
			
			assertEquals( (shirt.finalPrice >= 10000), shirt.isExpensive());
			assertEquals(shirt.finalPrice, finalPriceCalculation);
		}
		
	}
}

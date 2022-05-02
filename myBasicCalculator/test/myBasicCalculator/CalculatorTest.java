package myBasicCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myBasicCalculator.Calculator.Operation;

class CalculatorTest {
	private final int CONSTRUCTOR1 = 2;
	private Calculator calculator;
	
	
	public CalculatorTest() {
		calculator = new Calculator(2);
	}
	
	@Test
	void checkConstructor() {
		int actual = calculator.answer;
		int expected = CONSTRUCTOR1;
		assertEquals(expected, actual);
	}
	
	@Test
	void checkSum() {
		calculator.sum(3, 5);
		assertEquals(8, calculator.answer);
		assertTrue(calculator.lastOperation==Operation.ADD);
	}
	
	@Test
	void checkArray() {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 3};
		
		assertArrayEquals(arr1, arr2);
	}
	
	@Test
	void checkDivision() {
		
	}

}

package myBasicCalculator;

public class Calculator {
	int answer;
	Operation lastOperation;
	
	public Calculator(int answer) {
		this.answer = answer;
	}
	
	public enum Operation{
		ADD, SUBTRACT, MUILTIPY, DIVIDE;
	}

	public void sum(int x, int y) {
		answer = x + y;
		lastOperation = Operation.ADD;
	}
	
	public void divide(int x, int y) {
		if (y==0)
			throw new ArithmeticException("Zero division is not allowed");
		
		answer = x/y;
		lastOperation = Operation.DIVIDE;
	}
}

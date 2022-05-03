package javabootcamp.oop.basic;

public class Runner {

	public static void main(String[] args) {
		Clock clk1 = new Clock(100);
		Clock clk2 = new Clock();
		Clock clk3 = new Clock(2, 20);
		//clk1.printTime();
		clk3.printTime();		
	}
}

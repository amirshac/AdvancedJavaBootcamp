package multithreading.exercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

	private static final int ARR_SIZE = 1000;
	static List<Integer> randomNumberList = new ArrayList<Integer>(ARR_SIZE);
	static List<Integer> integerList = new ArrayList<Integer>();
	static List<String> stringList = new ArrayList<String>();
	static List<Double> doubleList = new ArrayList<Double>();

	static Random random = new Random();

	public static void populateRandomNumberList() {
		for (int i = 0; i < ARR_SIZE; i++) {
			randomNumberList.add(random.nextInt());
		}

		// set random nulls
		randomNumberList.set(900, null);
		randomNumberList.set(600, null);
		randomNumberList.set(500, null);
	}

	public static void main(String[] args) {
		populateRandomNumberList();
		
		Thread doublingThread = new Thread(new DoublingIntegerRunnable(), "Doubling integer thread");
		doublingThread.start();
		
		//Thread stringConversionThread = new Thread(new Runnable{()->{}};,"String thread");
		Thread stringThread = new Thread(new StringRunnable(), "String thread");
		stringThread.setUncaughtExceptionHandler( (t, exception) ->{
			System.out.println("Exception handler - exception happened ");
		});
		stringThread.start();
	}
	
	static class StringRunnable implements Runnable {
		@Override
		public void run() {
			randomNumberList.forEach(n -> stringList.add(Integer.toString(n+1)));
		}
	}

	static class DoublingIntegerRunnable implements Runnable {

		@Override
		public void run() {
			try {
				randomNumberList.forEach(n -> integerList.add(n * 2));
			} catch (Exception e) {
				System.out.println(Thread.currentThread().getName() + " inside thread exception occured :" + e);
			}
		}
	}
}

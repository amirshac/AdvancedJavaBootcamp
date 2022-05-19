package multithreading.exercise6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// race conditions

public class Runner {

	private static final int ARR_SIZE = 50;
	static List<Integer> numbers = new ArrayList<Integer>(ARR_SIZE);
	static int sum = 0;

	public static void populateList() {
		for (int i = 1; i <= ARR_SIZE; i++) {
			numbers.add(i);
		}
	}
	
	public static int sumElements(List<Integer> list, int startIndex, int endIndex) {
		for (int i=startIndex; i<=endIndex; i++) {
			sum += list.get(i);
		}
		
		return sum;
	}

	public static void main(String[] args) {
		populateList();
	
		int start = 0;
		int pivot = numbers.size()/2;
		int end = numbers.size()-1;
		
		Thread thread1 = new Thread(new SumRunnable(numbers, start, pivot), "First half thread");
		Thread thread2 = new Thread(new SumRunnable(numbers, pivot+1, end), "Second half thread");
		
		// normal sum 
		sumElements(numbers, 0, numbers.size()-1);
		System.out.println("Normal sum : " + sum);
		
		// ========================================
		// thread sum
		sum = 0;
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread sum : " + sum);
		
	}
	
	static class SumRunnable implements Runnable {

		int startIndex;
		int endIndex;
		List<Integer> list;
		
		public SumRunnable(List<Integer> list, int startIndex, int endIndex) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.list = list;
		}
		
		@Override
		public void run() {
			sumElements(list, startIndex, endIndex);
		}
	}
}

package pools.forkjoinpool.increment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final int ARR_SIZE = 10;
	private static double[] array = new double[ARR_SIZE];
	
	public static void populateArray() {
		for (int i=0; i<ARR_SIZE; i++) {
			array[i] = i;
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		populateArray();	
		ForkJoinPool pool = new ForkJoinPool();
		Future<Double> future = pool.submit(new SumTask(array, 0, array.length));
		double sum = future.get();
		
		pool.shutdown();
		pool.awaitTermination(3, TimeUnit.SECONDS);
		
		System.out.println("Sum: " + sum);
	}
	
	static class SumTask extends RecursiveTask<Double>{

		final int threshold = 1;
		private double[] arr;
		private int start, end;
		double sum;
		
		public SumTask(double[] arr, int start, int end) {
			this.arr = arr;
			this.start = start;
			this.end = end;
		}

		@Override
		protected Double compute() {
			sum = 0.0;
			if (end-start <= threshold) {
				for (int i = start; i < end; i++) {
					sum += arr[i];
				}
			}
			else {
				int middle = (start+end)/2;
				
				SumTask subtaskA = new SumTask(arr, start, middle);
				SumTask subtaskB = new SumTask(arr, middle, end);
				
				subtaskA.fork();
				subtaskB.fork();
				
				sum = subtaskA.join() + subtaskB.join();
			}
			
			return sum;
		}
		
	}
	
	public static void printArray(double[] arr) {
		for (double element : arr) {
			System.out.print("["+element+"]");
		}
		System.out.println();
	}
}

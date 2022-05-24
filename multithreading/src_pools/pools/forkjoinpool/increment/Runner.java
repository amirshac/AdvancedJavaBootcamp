package pools.forkjoinpool.increment;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class Runner {

	private static final int ARR_SIZE = 10;
	private static ArrayList<Double> array = new ArrayList<Double>(ARR_SIZE);
	
	public static void populateArray() {
		for (double i=1; i<=ARR_SIZE; i++) {
			array.add(i);
		}
	}
	
	public static void main(String[] args) {
		populateArray();
		
	}
	
	static class SumTask extends RecursiveTask<Double>{

		@Override
		protected Double compute() {
			// TODO Auto-generated method stub
			return 0d;
		}
		
	}

}

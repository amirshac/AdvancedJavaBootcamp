package networking.tcp.ex5.expenses.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnerClient {
	private static final int NUM_CLIENTS = 100;
	
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i=0; i<NUM_CLIENTS; i++) {
			executorService.execute(new ExpenseClient());	
		}
		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

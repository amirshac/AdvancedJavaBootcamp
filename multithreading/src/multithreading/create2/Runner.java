package multithreading.create2;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	static int counter = 0;
	static final int LOOPS = 1000;
	
	private static final Object synchronizer = new Object();
	
	// option2 - synchronized method, we're using a runner instance as the lock object
	private static final Runner runner = new Runner();
	private synchronized void incrementCounter() {
		counter++;
	}
	
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		
		ThreadGroup group = new ThreadGroup("Group1");
		
		for (int i=0; i<LOOPS; i++) {
			Thread thread = new Thread(group, new MyRunnable());
			thread.start();
			threads.add(thread);
		}
		
		group.interrupt();
		
		threads.forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		});
		
		System.out.println("total is " + counter);
	}
	
	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
			}
			// option 1 - synchronized block
			// locks to prevent race condition
			// we take the 'lock' from the synchronizer object
		//	synchronized(synchronizer) {
		//		counter++;
		//	}
			
			// option 2 - synchronized method
			runner.incrementCounter();
			
		}	
	}
}

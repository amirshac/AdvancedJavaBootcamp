package multithreading.threadpools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Runner {
	
	private static final int CORE_THREADS = 2;
	private static final int MAX_POOL_SIZE = 4;
	private static final long KEEP_ALIVE_TIME = 3;
	private static final int CAPACITY = 6;

	// thread pools executor
	
	private static final BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(CAPACITY); 
		
	private static RejectedExecutionHandler handler = (Runnable runnable, ThreadPoolExecutor executor)->{
		//runnable.run();
		//executor.execute(runnable);
		System.out.println("Rejected task");
	};
	
	//1 - wake up core threads from pool one by one up to CORE_THREADS
	//2 - fill up the queue with tasks one by one up to CAPACITY
	//3 - if necessary, wake up more threads up to a total of MAX_POOL_SIZE
	//4 - if queue is full all threads are running - a RejectedExectuionException is thrown 
	
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				CORE_THREADS, 
				MAX_POOL_SIZE, 
				KEEP_ALIVE_TIME, 
				TimeUnit.SECONDS, 
				tasks,
				// handler - use our custom handler
				new ThreadPoolExecutor.CallerRunsPolicy() // built in policy for 'handling'
			);
		
		Runnable task = () ->{
			sleep(1000);
			System.out.println("Java thread");
		};
		
		// option 1 - try catch every execute
//		for (int i = 0; i < 15; i ++) {
//			try {
//				pool.execute(task);
//				System.out.println(pool.getPoolSize());
//			}catch (Exception e) {
//				System.out.println("task is rejected");
//			}
//		}
		
		// option 2
		
		// gracefully shutdown
		pool.shutdown();
		
	}
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

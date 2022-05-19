package multithreading.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

	private static final int NUM_LOOPS = 100;
	private static final int DELAY = 100;
	static long num = 10;
	static List<Thread> threads = new ArrayList<Thread>();
	static Random random = new Random();
	
	public static void main(String[] args) {
		Thread thread; 
		
		thread = new Thread(new DoubleThread(), "Doubling thread");
		thread.setPriority(10);
		threads.add(thread);
		
		//======================================
		Runnable additionRunnable = new Runnable(){
			@Override
			public void run() {
				for (int i=0; i<NUM_LOOPS; i++) {
					num+=2;
					System.out.println(Thread.currentThread().getName() + i + ":"+ num);
					try {
						Thread.sleep(random.nextInt(DELAY));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		
		thread = new Thread(additionRunnable, "Addition thread");
		thread.setPriority(9);
		threads.add(thread);
		//===================================================
		
		thread = new Thread(()->{
			for (int i=0; i<NUM_LOOPS; i++) {
				num/=2;
				System.out.println(Thread.currentThread().getName()+i+":"+ num);
				try {
					Thread.sleep(random.nextInt(DELAY));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Division Thread");
		
		thread.setPriority(1);
		threads.add(thread);
		//=========================================
		
		System.out.println("Starting threads:");
		
		threads.forEach(t->t.start());
		
		System.out.println("Waiting for threads to finish...");
		threads.forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		System.out.println("Final value of num is " + num);
	}
	
	public static class DoubleThread extends Thread{
		@Override
		public void run() {
			for (int i=0; i<NUM_LOOPS; i++) {
				num*=2;
				System.out.println(Thread.currentThread().getName()+i +":"+ num);
				try {
					Thread.sleep(random.nextInt(DELAY));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

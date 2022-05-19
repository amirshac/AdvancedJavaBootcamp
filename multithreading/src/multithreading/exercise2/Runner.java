package multithreading.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

	private static final int DELAY = 100;
	private static final int DELAY_MAIN = 2000;
	private static final int GROUP_SIZE = 3;
	static int num = 1;
	static List<Thread> threads = new ArrayList<Thread>();
	
	public static void main(String[] args) {
		Thread thread; 
		ThreadGroup group = new ThreadGroup("group");
		
		for (int i=0; i<GROUP_SIZE; i++) {
			thread = new Thread(group, new DoubleThread(), "Group thread " + i);
			threads.add(thread);
		}
		
		threads.forEach(t->t.start());
		
		try {
			Thread.sleep(DELAY_MAIN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		group.interrupt();
		
		System.out.println("Final value of num is " + num);
	}
	
	public static class DoubleThread extends Thread{
		@Override
		public void run() {
			while (true)
			{
				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					break;
				}
				
				num*=2;
				System.out.println(Thread.currentThread().getName() +":"+ num);
			}
		}
	}

}

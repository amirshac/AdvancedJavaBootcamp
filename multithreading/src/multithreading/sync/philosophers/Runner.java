package multithreading.sync.philosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	static final int NUM_PHILO = 5;
	static List<Lock> forks = new ArrayList<>();
	static final long MIN_DELAY = 1000;
	static final long MAX_DELAY = 5000;
	static Random random = new Random();
	

	public static void main(String[] args) {
		
		for (int i=0; i<NUM_PHILO; i++) {
			forks.add(new ReentrantLock());
		}
		
		// we only allow up to 4 out of 5 to take forks
		Semaphore semaphore = new Semaphore(NUM_PHILO-1);
		
		for (int i=0; i<NUM_PHILO; i++) {
			new Thread(new Philosopher(i, semaphore)).start();
		}
		
	}
	
	static class Philosopher implements Runnable{

		int id;
		Semaphore semaphore;
		
		public Philosopher(int id, Semaphore semaphore) {
			this.id = id;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			
			try {
				think();
				pickForks();
				eat();
				putForks();
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
	
		private void pickForks() throws InterruptedException {
			
			semaphore.acquire();

			forks.get(id).lock();
			System.out.println(id + " is taking right fork");

			Thread.sleep(random.nextLong(MIN_DELAY, MAX_DELAY));

			forks.get((id+1)%NUM_PHILO).lock();
			System.out.println(id + " is taking left fork");
			
			Thread.sleep(random.nextLong(MIN_DELAY, MAX_DELAY));

		}

		private void putForks() throws InterruptedException {			
			forks.get(id).unlock();
			System.out.println(id + " is freeing right fork");

			Thread.sleep(random.nextLong(MIN_DELAY, MAX_DELAY));

			forks.get((id+1)%NUM_PHILO).unlock();
			System.out.println(id + " is freeing left fork");
			
			Thread.sleep(random.nextLong(MIN_DELAY, MAX_DELAY));

			semaphore.release();
		}
		
		private void think() throws InterruptedException {
			System.out.println(id + " is thinking....");
			Thread.sleep(random.nextLong(MIN_DELAY, MAX_DELAY));

		}
		
		private void eat() throws InterruptedException {
			System.out.println(id + " <IS EATING>!");
			Thread.sleep(random.nextLong(MIN_DELAY, MAX_DELAY));
		}
	}

}

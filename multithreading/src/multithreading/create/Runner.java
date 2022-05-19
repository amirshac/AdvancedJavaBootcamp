package multithreading.create;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		// get current thread
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName());
		
		// creating thread using extension
		//PrinterThread thread1 = new PrinterThread();
		
		Thread thread1 = new Thread(new PrinterThread(), "printer thread");
		thread1.start();
		
	//	thread1.join(); // waits for thread
		
		// creating thread using runnable interface 
		Runnable myRunnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Java is awesome");
				}
			}
		};
		
		Thread thread2 = new Thread(myRunnable);
		thread2.start();
		
		// runnable is functional iterface, we can use lambda
		Thread thread3 = new Thread(()->{
			for (int i = 0; i < 4; i++) {
				System.out.println("Hello from " + Thread.currentThread().getName());
			}
		}, "thread number 3");
		thread3.start();
	}

	
	static class PrinterThread extends Thread{
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Hello from " + Thread.currentThread().getName());
		}
	}
	
}

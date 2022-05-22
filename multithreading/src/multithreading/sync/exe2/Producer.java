package multithreading.sync.exe2;

import java.util.Queue;

public class Producer implements Runnable {

	private final Queue<String> queue;
	private final static int PRODUCE_TIME = 2000;
	private static int MAX_REPORT_SIZE = 5;
	private static int INFORM_CONSUMER = 1;

	public Producer(Queue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				produceReports();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * version 1 - with synchronized block private void produceReports() throws
	 * InterruptedException { synchronized(queue) { if (queue.size() ==
	 * MAX_REPORT_SIZE) { System.out.println(Thread.currentThread().getName() +
	 * " producer full, waiting..."); queue.wait(); }
	 * 
	 * Thread.sleep(PRODUCE_TIME);
	 * 
	 * System.out.println(Thread.currentThread().getName() + " producing report " +
	 * queue.size()); queue.add("Report_" + queue.size());
	 * 
	 * if (queue.size() == INFORM_CONSUMER) { queue.notify(); } }
	 */

	private void produceReports() throws InterruptedException {
		ReportHandler.lock.lock();
		if (queue.size() == MAX_REPORT_SIZE) {
			System.out.println(Thread.currentThread().getName() + " producer full, waiting...");
			ReportHandler.condition.await();
		}

		Thread.sleep(PRODUCE_TIME);

		System.out.println(Thread.currentThread().getName() + " producing report " + queue.size());
		queue.add("Report_" + queue.size());

		if (queue.size() == INFORM_CONSUMER) {
			ReportHandler.condition.signal();
		}
		
		ReportHandler.lock.unlock();

	}

}

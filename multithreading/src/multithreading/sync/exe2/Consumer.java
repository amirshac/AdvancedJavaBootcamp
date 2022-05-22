package multithreading.sync.exe2;

import java.util.Queue;

public class Consumer implements Runnable {

	private final Queue<String> queue;
	private final static int CONSUME_TIME = 1000;
	private static int MAX_REPORT_SIZE = 5;
	private static int INFORM_PRODUCER = 1;

	public Consumer(Queue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consumeReports();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * version 1 - done with synchronized private void consumeReports() throws
	 * InterruptedException { synchronized(queue) { if (queue.isEmpty()) {
	 * System.out.println(Thread.currentThread().getName() +
	 * " consumer queue empty, waiting..."); queue.wait(); }
	 * 
	 * Thread.sleep(CONSUME_TIME);
	 * 
	 * System.out.println(Thread.currentThread().getName() + " consuming report " +
	 * queue.remove());
	 * 
	 * if (queue.size() == INFORM_PRODUCER) { queue.notify(); } } }
	 */

	private void consumeReports() throws InterruptedException {
		ReportHandler.lock.lock();
		if (queue.isEmpty()) {
			System.out.println(Thread.currentThread().getName() + " consumer queue empty, waiting...");
			ReportHandler.condition.await();
		}

		Thread.sleep(CONSUME_TIME);

		System.out.println(Thread.currentThread().getName() + " consuming report " + queue.remove());

		if (queue.size() == INFORM_PRODUCER) {
			ReportHandler.condition.signal();
		}
	}
}

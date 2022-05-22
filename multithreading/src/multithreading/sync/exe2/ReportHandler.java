package multithreading.sync.exe2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReportHandler {
	
	public static Lock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	
	protected Queue<String> queue;
	protected Producer producer;
	protected Consumer consumer;

	public ReportHandler() {
		queue = new LinkedList<>();
	}
	
	public void go() {
		Thread producer = new Thread(new Producer(queue), "Producer");
		Thread consumer = new Thread(new Consumer(queue), "Consumer");
		
		producer.start();
		consumer.start();
	}
	
}

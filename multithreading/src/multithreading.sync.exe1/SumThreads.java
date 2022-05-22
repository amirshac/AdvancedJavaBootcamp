package multithreading.sync.exe1;

import java.util.ArrayList;
import java.util.List;

public class SumThreads {
	private static final int SIZE = 10000, NUM_THREADS = 100;
	
	protected List<Integer> list;
	private int sum;
	private List<Thread> threads;
	private int listSlice;
	
	public SumThreads() {
		list = new ArrayList<Integer>(SIZE);
		threads = new ArrayList<Thread>(NUM_THREADS);
		listSlice = SIZE / NUM_THREADS;
		sum = 0;
	}
	
	public void go() {
		initList();
		makeThreads();
		runThreads();
		joinThreads();
		
		System.out.println("Sum is " + sum);
	}
	
	public void initList() {
		for (int i=0; i<SIZE; i++) {
			list.add(i);
		}
	}
	
	public void makeThreads() {
		for (int i = 0; i < NUM_THREADS; i++) {
			Thread thread = new Thread(new SumListSection(i * listSlice, (i + 1) * listSlice, this));
			threads.add(thread);	
		}
	}
	
	public void runThreads() {
		threads.forEach(t->t.start());
	}
	
	public void joinThreads() {
		threads.forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
	
	public synchronized void addToSum(int num) {
		sum+=num;
	}
}

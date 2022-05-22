package multithreading.sync.exe1;

public class SumListSection implements Runnable{
	
	private int start;
	private int end;
	private SumThreads sumThreads;
	
	
	public SumListSection(int start, int end, SumThreads sumThreads) {
		this.start = start;
		this.end = end;
		this.sumThreads = sumThreads;
	}
	
	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			sumThreads.addToSum(sumThreads.list.get(i));
		}
	}

}

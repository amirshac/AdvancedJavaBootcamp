package multithreading.exe.alice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FileWordMapper {
	
	protected Map<String, Integer> map;
	FileHandler handler;
	
	private static final int CORE_THREADS = 4;
	private static final int MAX_POOL_SIZE = 8;
	private static final int CAPACITY = 20;
	private static final int KEEP_ALIVE = 1;
	
	public FileWordMapper() {
		map = new HashMap<String, Integer>();
		handler = new FileHandler();
	}
	
	public void go() {
		handler.openFile("myFiles/alice.txt");
	
	//	serialReadAndMap();
	//	printMap();
		
		threadReadAndMap();
		
		
		handler.closeFile();	
	}
	
	protected void threadReadAndMap() {
		BlockingQueue blockingQueue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE, TimeUnit.MINUTES, blockingQueue, new ThreadPoolExecutor.AbortPolicy());
		
		
//		Runnable action = new Runnable() {
//			public String localLine = null;
//			
//			@Override
//			public void run() {
//				List<String> words;
//				System.out.println(Thread.currentThread().getName() + " parsing line-> " + localLine);
//				words = WordParser.parse(localLine);
//				AddWordsToMap(words);	
//				sleep(1000);
//			}
//		};
		
		String line;
		while ( (line = handler.readLine()) != null) {
			final String innerLine = new String(line);
			
			threadPoolExecutor.execute(()->{
				List<String> words;
			//	System.out.println(Thread.currentThread().getName() + " parsing line-> " + innerLine);
				words = WordParser.parse(innerLine);
				AddWordsToMap(words);	
		//		System.out.println(Thread.currentThread().getName() + " parsed words " + words);
			});
			
		}
		
		threadPoolExecutor.shutdown();
		
		try {
			threadPoolExecutor.awaitTermination(1000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		printMap();
	}
	
	protected void serialReadAndMap() {
		String line;
		List<String> words;
		
		while ( (line = handler.readLine()) != null) {
			words = WordParser.parse(line);
			AddWordsToMap(words);
		}
	}
	
	protected void AddWordsToMap(List<String> list) {
		list.forEach(word->addWordToMap(word));
	}
	
	protected void addWordToMap(String word) {
		if (map.containsKey(word)){
			int value = map.get(word);
			map.replace(word, value+1);
		}else {
			map.put(word, 1);
		}
	}
	
	protected void printMap() {
		map.forEach( (t,u) -> System.out.println(t + ":" + u));
	}
	
	public void sleep(int mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

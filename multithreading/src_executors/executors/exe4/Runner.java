package executors.exe4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final String WEB_ADDRESS = "https://en.wikipedia.org/wiki/Java_(programming_language)";
	private static final String WORD_TO_SEARCH = "java";
	private static final int NUM_THREADS = 3;

	public static void serialVersion() throws MalformedURLException, IOException {
		URLConnection connection = new URL(WEB_ADDRESS).openConnection();
		Scanner scanner = new Scanner(connection.getInputStream());

		int counter = 0;

		while (scanner.hasNext()) {
			String line = scanner.nextLine().toLowerCase();

			String[] words = line.split(" ");

			for (String word : words) {
				if (word.equals(WORD_TO_SEARCH))
					counter++;
			}
		} // end while

		System.out.println(WORD_TO_SEARCH + " : " + counter);
	}

	public static void executorServiceVersion() throws MalformedURLException, IOException, InterruptedException, ExecutionException {
		URLConnection connection = new URL(WEB_ADDRESS).openConnection();
		Scanner scanner = new Scanner(connection.getInputStream());
		
		ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
		List <Future<Integer>> futures = new ArrayList<Future<Integer>>();
				
		while (scanner.hasNext()) {
			String line = scanner.nextLine().toLowerCase();
			
			// Callable lambda function
			Future<Integer> future = executorService.submit(()->{
				int taskCounter = 0;
				String[] words = line.split(" ");
				
				for (String word: words) {
					if (word.equals(WORD_TO_SEARCH)) 
						taskCounter ++;
				}
				
				if (taskCounter > 0) {
					System.out.println(Thread.currentThread().getName() + " result " + taskCounter);	
				}
				
				return taskCounter;
			});
			
			futures.add(future);
			
		}// end while
		
		int sum = 0;
		
		for (Future<Integer>future : futures) {
			sum += future.get();
		}

		System.out.println(WORD_TO_SEARCH + " : " + sum);
		
		executorService.shutdown();
		executorService.awaitTermination(3, TimeUnit.SECONDS);
	}

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException, ExecutionException {
		executorServiceVersion();
	}
}

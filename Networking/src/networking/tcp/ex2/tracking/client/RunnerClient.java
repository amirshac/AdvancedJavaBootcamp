package networking.tcp.ex2.tracking.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnerClient {

	private static final String SERVER_NAME = "localhost";
	private static final int SERVER_PORT = 8080;
	private static final int NUM_CLIENTS = 10;
	private static final int AWAIT_TERMINATION_SECONDS = 3;
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(NUM_CLIENTS);
		
		List<TrackingClient> clients = new ArrayList<TrackingClient>(NUM_CLIENTS);
		
		for (int i=0; i<NUM_CLIENTS; i++) {
			clients.add(new TrackingClient(SERVER_NAME, SERVER_PORT, new TrackingDevice()));
		}
		
		clients.forEach(c->executorService.execute(c));
		
		try {
			executorService.awaitTermination(AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}

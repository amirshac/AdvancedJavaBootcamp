package networking.tcp.ex3.restaurant.client;

public class RunnerClient {
	public static void main(String[] args) throws InterruptedException {
		
		for (int i=0; i<10; i++) {
			WaiterClient waiter = new WaiterClient();
			waiter.go();
			Thread.sleep(1000);
		}	
	}
}

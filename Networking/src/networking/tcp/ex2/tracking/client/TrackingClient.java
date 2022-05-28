package networking.tcp.ex2.tracking.client;

import java.util.Random;

import networking.tcp.TcpClient.TcpClient;

public class TrackingClient extends TcpClient implements Runnable{

	private static Random random = new Random();
	
	private static final int START_DELAY_MIN = 10000;
	private static final int START_DELAY_MAX = 40000;
	
	private static final int REPORT_DELAY_MIN = 10000;
	private static final int REPORT_DELAY_MAX = 30000;
	
	protected TrackingDevice device;
	
	
	public TrackingClient(String serverName, int serverPort, TrackingDevice device) {
		super(serverName, serverPort);
		this.device = device;
	}
		
	@Override
	public void run() {
		sleepRandomly(START_DELAY_MIN, START_DELAY_MAX);
		this.startClient();
		
		while (clientActive) {
			sendLineToServer(device.reportString());
			
			System.out.println(Thread.currentThread().getName() + " sent: " + device.reportString());
			
			sleepRandomly(REPORT_DELAY_MIN, REPORT_DELAY_MAX);
			
			device.shiftLocationRandomly();
			System.out.println(Thread.currentThread().getName() + " shifting location");
		}
	}
	
	void sleepRandomly(int start, int end) {
		int sleepTime = random.nextInt(start, end);
		System.out.println(Thread.currentThread().getName() + " sleeping for " + sleepTime);
		sleep(sleepTime);
	}

}

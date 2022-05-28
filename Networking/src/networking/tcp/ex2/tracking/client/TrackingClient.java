package networking.tcp.ex2.tracking.client;

import networking.tcp.TcpClient.TcpClient;

public class TrackingClient extends TcpClient implements Runnable{

	private static final int REPORT_DELAY = 10000;
	protected TrackingDevice device;
	
	
	public TrackingClient(String serverName, int serverPort, TrackingDevice device) {
		super(serverName, serverPort);
		this.device = device;
	}
		
	@Override
	public void run() {
		while (clientActive) {
			sendLineToServer(device.reportString());
			
			System.out.println(Thread.currentThread().getName() + " sent: " + device.reportString());
			
			sleep(REPORT_DELAY);
			
			device.shiftLocationRandomly();
			System.out.println(Thread.currentThread().getName() + " shifting location");
		}
	}

}

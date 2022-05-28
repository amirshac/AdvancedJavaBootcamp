package networking.tcp.ex2.tracking.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import networking.tcp.ex2.tracking.client.Location;
import networking.tcp.ex2.tracking.client.TrackingDevice;

public class TrackingServer {

	private final static int MAP_PRINT_DELAY = 10000;
	
	protected int port;
	protected HashMap<Integer, Location> reports;
	protected boolean serverActive;
	protected ServerSocket serverSocket;
	protected Socket clientSocket;

	public TrackingServer(int port) {
		this.port = port;
		reports = new HashMap<Integer, Location>();
		serverActive = true;
	}

	public void go() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("Server started on port " + port);
		int sessionNumber = 0;

		startPrinterThread();
		
		while (serverActive) {
			clientSocket = serverSocket.accept();
			Thread thread = new Thread(new Session(clientSocket), "Session " + sessionNumber++);
			thread.start();
		}
	}


	protected void parseReport(String transmission) {
		String[] splitted = transmission.split(" ");
		int id = Integer.parseInt(splitted[0]);
		double longitude = Double.parseDouble(splitted[1]);
		double altitude = Double.parseDouble(splitted[2]);
		LocalDateTime timeStamp = LocalDateTime.parse(splitted[3]);

		Location location = new Location(longitude, altitude, timeStamp);
		
		updateMap(id, location);

	}
	
	protected synchronized void updateMap(int id, Location location) {
		reports.put(id, location);
	}

	protected void startPrinterThread() {
		Thread printerThread = new Thread(()->{
			while (serverActive) {
				printMap();
				sleep(MAP_PRINT_DELAY);
			}
		}, "Printer Thread");
		
		printerThread.start();	
		System.out.println("Printer thread started");
	}
	
	protected synchronized void printMap() 
	{
		System.out.println();
		System.out.println(Thread.currentThread().getName());
		System.out.println("=============[LOCATION MAP]================");
		reports.forEach((id, location) -> System.out.println("ID: " + id + " " + location.toString()));
		System.out.println("===========================================");
		System.out.println();
	}
	
	protected void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
		
	
	protected class Session implements Runnable {

		private static final int SESSION_SLEEP_DELAY = 10000;
		protected BufferedReader reader;
		protected Socket clientSocket;
		String line;

		public Session(Socket clientSocket) throws IOException {
			this.clientSocket = clientSocket;
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " started");
			try {
				getDataFromTracker();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}

		protected void getDataFromTracker() throws IOException, InterruptedException {
			while (true) {
				try {
					line = reader.readLine();
					System.out.println("Received> " + line);

					parseReport(line);
					sleep(SESSION_SLEEP_DELAY);
				} catch (IOException e) {
					reader.close();
					System.out.println(Thread.currentThread().getName() + " closed");
					break;
				}
			}
		}

	} // end inner class
}
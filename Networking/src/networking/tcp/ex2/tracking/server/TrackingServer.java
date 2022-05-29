package networking.tcp.ex2.tracking.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import networking.tcp.ex2.tracking.client.Location;


public class TrackingServer {

	private final static int MAP_PRINT_DELAY = 10000;
	private final static int MAX_THREADS = 20;
	
	protected int port;
	protected HashMap<Integer, Location> reports;
	protected boolean serverActive;
	protected ServerSocket serverSocket;
	protected Socket clientSocket;
	ExecutorService executorService;
	List<Thread> threads;

	public TrackingServer(int port) {
		this.port = port;
		reports = new HashMap<Integer, Location>();
		serverActive = true;
		executorService = Executors.newFixedThreadPool(MAX_THREADS);
		threads = new ArrayList<Thread>();
	}

	public void go() throws IOException, InterruptedException {
		
		serverSocket = new ServerSocket(port);
		System.out.println("Tracker server started on port " + port);
		int sessionNumber = 0;

		startPrinterThread();
		startInputThread();
		
		while (serverActive) {
			clientSocket = serverSocket.accept();
			Thread thread = new Thread(new Session(clientSocket), "Session " + sessionNumber++);
			threads.add(thread);
			executorService.submit(thread);
		}
		
		System.out.println("Server shut down");
		threads.forEach(t->t.interrupt());
		executorService.awaitTermination(5, TimeUnit.SECONDS);
		executorService.shutdown();
	}

	protected void parseReport(String transmission) {
		if (transmission == null) return;
		
		String[] splitted = transmission.split(" ");
		int id = Integer.parseInt(splitted[0]);
		double longitude = Double.parseDouble(splitted[1]);
		double altitude = Double.parseDouble(splitted[2]);
		LocalDateTime timeStamp = LocalDateTime.parse(splitted[3]);

		Location location = new Location(longitude, altitude, timeStamp);
		
		updateMap(id, location);

	}
	
	protected void updateMap(int id, Location location) {
		reports.put(id, location);
	}

	protected void startPrinterThread() {
		Thread printerThread = new Thread(()->{
			while (serverActive) {
				printMap();
				sleep(MAP_PRINT_DELAY);
			}
		}, "Printer Thread");

		threads.add(printerThread);
		executorService.submit(printerThread);
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
	
	protected void startInputThread() {
		Thread inputThread = new Thread(new ServerInput(), "Input Thread");
		threads.add(inputThread);
		executorService.submit(inputThread);
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
			
			while (true) {
				try {
					line = reader.readLine();
					System.out.println("Received> " + line);
					parseReport(line);
					sleep(SESSION_SLEEP_DELAY);
				} catch (Exception e) {
					break;
				}
			}
			
			closeConnections();
			System.out.println(Thread.currentThread().getName() + " closed");
		}
		
		public void closeConnections() {
			System.out.println(Thread.currentThread().getName()+ " closing connections");
			try {
				if (clientSocket != null)
					clientSocket.close();
				if (reader != null)
					reader.close();
			}catch (IOException e) {
				System.out.println("Can't close connections");
			}
		}
	} // end inner class
	
	protected class ServerInput implements Runnable{

		Scanner scanner;
		boolean threadActive = true;
		String command;
		
		public ServerInput() {
			scanner = new Scanner(System.in);
		}
		
		@Override
		public void run() {
			System.out.println("Server console command:");
			
			while(threadActive) {
				command = scanner.nextLine();
				command = command.toUpperCase().trim();
				switch (command) {
				case "QUIT":
					shutDown();
					break;
				default:
					break;
				}
			}
			
			scanner.close();
		}
		
		public void shutDown() {
			threadActive = false;
			serverActive = false;
		}
		
	}
}
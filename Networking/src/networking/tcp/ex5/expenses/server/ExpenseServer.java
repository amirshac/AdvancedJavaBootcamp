package networking.tcp.ex5.expenses.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

public class ExpenseServer {
	private static final int PORT = 8080;
	
	protected ServerSocket serverSocket;
	protected Socket clientSocket;
	protected ExecutorService executorService;
	protected boolean serverActive;

	
	public ExpenseServer() {
		this.serverSocket = null;
		this.clientSocket = null;
		executorService = Executors.newCachedThreadPool();
		serverActive = true;
	}


	public void startServer() {
		
		executorService.execute(new saveDataBaseToFileThread());
		
		try (ServerSocket serverSocket = new ServerSocket(PORT);){
			this.serverSocket = serverSocket;
			
			System.out.println("Expense server waiting for connections");
			while(serverActive) {
				clientSocket = serverSocket.accept();
				executorService.execute(new ExpenseSession(clientSocket));
			}
			
		}catch (IOException e) {
			System.err.println("Failed to start server");
			System.out.println(e);
		}finally {
			executorService.shutdown();
			try {
				executorService.awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				System.out.println("Cant shutddown executor");
				e.printStackTrace();
			}
		}
	}
	
	protected class saveDataBaseToFileThread implements Runnable{

		private static final int SAVE_DELAY = 30000;
		@Override
		public void run() {
			while (true){
				ExpenseDB.saveToFile();
				System.out.println("Saved DB to file");
				try {
					Thread.sleep(SAVE_DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	protected class ExpenseSession implements Runnable {

		protected Socket clientSocket;
		protected BufferedReader reader;
		protected PrintWriter writer;
		protected Gson gson;
		protected Expense expense;
		protected UserRecord userRecord;
		
		public ExpenseSession(Socket clientSocket) {
			this.clientSocket = clientSocket;
			gson = new Gson();
		}

		@Override
		public void run() {
			
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);) {
				
				this.reader = reader;
				this.writer = writer;
								
				System.out.println(
						"Client is connected " + clientSocket.getInetAddress() + " port " + clientSocket.getPort());
				
				// reading data
				String line = reader.readLine();
				System.out.println("Client sent: " + line);
				
				processData(line);
				updateDB(userRecord);
				
				// sending data
				sendResult(userRecord);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void processData(String line) {
			expense = gson.fromJson(line, Expense.class);
			System.out.println("got " + expense);
			
			int clientID = expense.getClientID();
			userRecord = ExpenseDB.getRecordByID(clientID);
			
			// null means no record exists - create new record
			if (userRecord == null) {
				userRecord = new UserRecord(clientID);
			}
			
			Double amountInDB = userRecord.record.get(expense.category);
			
			if (amountInDB == null) {
				amountInDB = 0.0;
			}
			
			double amount = amountInDB + expense.amount;
			
			userRecord.record.put(expense.category, amount);
		}
		
		protected synchronized void updateDB(UserRecord record) {
			ExpenseDB.updateRecord(record.userID, record);
		}
		
		public void sendResult(UserRecord record) {
			String userRecordJson = gson.toJson(userRecord);
			writer.println(userRecordJson);
		}
		
	}
}

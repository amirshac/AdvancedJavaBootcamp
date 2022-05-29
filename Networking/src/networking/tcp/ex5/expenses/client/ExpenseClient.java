package networking.tcp.ex5.expenses.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

import com.google.gson.Gson;

import networking.tcp.ex5.expenses.server.Expense;
import networking.tcp.ex5.expenses.server.UserRecord;

public class ExpenseClient implements Runnable {
	private final static String SERVER_NAME = "localhost";
	private final static int SERVER_PORT = 8080;

	CountDownLatch latch;
	Expense expense;
	int clientID;
	Gson gson;
	UserRecord userRecord;

	public ExpenseClient() {
			//latch = latch;
			expense = Expense.randomExpense();
			clientID = expense.getClientID();
			gson = new Gson();
		}

	@Override
	public void run() {
		Socket clientSocket = null;
		PrintWriter writer = null;
		BufferedReader reader = null;

		try {
			clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
			System.out.println("Connected to server");

			// sending data
			String expenseJsonString = gson.toJson(expense);
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println(expenseJsonString);
			System.out.println("Client %d sent expense: ".formatted(clientID));
			System.out.println(expenseJsonString);

			// create reader
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// reading data
			String responseJsonString = reader.readLine();
			userRecord = gson.fromJson(responseJsonString, UserRecord.class);

			System.out.println("server says: " + responseJsonString);
			userRecord.print();

		} catch (UnknownHostException e) {
			System.err.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Socket failed");
			e.printStackTrace();
		} finally {
			if (clientSocket != null)
				try {
					clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (writer != null)
				writer.close();
			if (reader != null)
				writer.close();
		}
	}
}

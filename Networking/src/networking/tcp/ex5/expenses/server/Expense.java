package networking.tcp.ex5.expenses.server;

import java.time.LocalDateTime;
import java.util.Random;

public class Expense { 
	protected int clientID;
	protected Category category;
	protected double amount;
	protected String timeStamp;
	
	public Expense(int clientID, Category category, double amount, String timeStamp) {
		this.clientID = clientID;
		this.category = category;
		this.amount = amount;
		this.timeStamp = timeStamp;
	}
	
	public Expense() {
		this.clientID = 0;
		this.category = null;
		this.amount = 0.0;
		this.timeStamp = LocalDateTime.now().toString();
	}
		
	@Override
	public String toString() {
		return "Expense [clientID=" + clientID + ", category=" + category + ", amount=" + amount + ", timeStamp="
				+timeStamp+ "]";
	}

	public int getClientID() {
		return this.clientID;
	}

	public static Expense randomExpense() {
		final int MAX_USER_ID = 9999;
		final double MAX_EXPENSE = 1000;
		
		Random random = new Random();
		
		int clientID = random.nextInt(MAX_USER_ID+1);
		int categoryNumber = random.nextInt(Category.values().length);
		Category category = Category.values()[categoryNumber];
		double amount = random.nextDouble(MAX_EXPENSE);
		
		return new Expense(clientID, category, amount, LocalDateTime.now().toString());
	}
}


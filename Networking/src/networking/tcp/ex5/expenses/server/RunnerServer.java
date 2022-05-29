package networking.tcp.ex5.expenses.server;

public class RunnerServer {

	public static void main(String[] args) {
		ExpenseServer expenseServer = new ExpenseServer();
		expenseServer.startServer();
	}
}

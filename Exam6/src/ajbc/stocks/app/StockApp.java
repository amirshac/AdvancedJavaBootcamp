package ajbc.stocks.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import ajbc.stocks.app.Command.Operation;
import ajbc.stocks.db.StocksDB;

public class StockApp {
	private static int EXECUTOR_TERMINATION_TIME_SECONDS = 2;
	private List<Command> commands;
	
	private double dailySum;
	
	public StockApp() {
		dailySum = 0.0;
		commands = new ArrayList<Command>();
	}
	
	public void start(){
		populateCommands();
		ExecutorService executorService = Executors.newCachedThreadPool();	
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		
		StocksDB.printAllStocks();
		System.out.println("\nDaily transaction price: " + dailySum);
		
		System.out.println("==============================================\n");

		System.out.println("==========[ EXECUTING COMMANDS ] ==============\n");
		commands.forEach((command)->{
			futures.add(executorService.submit(command));
		});
		
		futures.forEach(future -> {
			try {
				dailySum+=future.get();
			} catch (InterruptedException | ExecutionException e1) {
				System.out.println("Error getting futures");
				e1.printStackTrace();
			}
		});
		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(EXECUTOR_TERMINATION_TIME_SECONDS, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println("Error terminating executorservice");
			e.printStackTrace();
		}
		
		System.out.println("==============================================\n");

		System.out.println("===========[ AFTER COMMANDS ] ================\n");
		StocksDB.printAllStocks();
		System.out.println("\nDaily transaction price: " + dailySum);
		
	}

	private void populateCommands() {
		commands.add(new Command("DOODLE", Operation.BUY));
		commands.add(new Command("DOODLE", Operation.SELL));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.SELL));
		commands.add(new Command("HEADBOOK", Operation.BUY));
		commands.add(new Command("HEADBOOK", Operation.SELL));
		commands.add(new Command("DOODLE", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("HEADBOOK", Operation.SELL));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		
		// stocks that don't exist in DB
		commands.add(new Command("unknown", Operation.BUY));
		commands.add(new Command("invidio", Operation.SELL));
		commands.add(new Command("somestock", Operation.SELL));

	}

}

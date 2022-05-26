package ajbc.stocks.app;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import ajbc.stocks.db.Stock;
import ajbc.stocks.db.StocksDB;

public class Command implements Callable<Double> {

	private static Lock mutex;
	
	static {
		mutex = new ReentrantLock();
	}
	
	private static double buyChangeOffset = 0.02d;
	private static double sellChangeOffset = -0.01d;

	String stockName;
	Operation operation;

	Stock stock;
	double transactionValue;

	public Command(String stockName, Operation operation) {
		this.stockName = stockName;
		this.operation = operation;

		transactionValue = 0.0;
	}

	public static enum Operation {
		BUY, SELL;
	}

	@Override
	public Double call() {

		try {
			stock = StocksDB.getStockByName(stockName);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return 0.0;
		}

		// critical section - Getting current price and updating offset in database
		mutex.lock();
		
		switch (operation) {
		case BUY:
			transactionValue = stock.getBuyPrice();
			stock.changeBuyPriceBy(buyChangeOffset);
			break;

		case SELL:
			transactionValue = stock.getSellPrice();
			stock.changeSellPriceBy(sellChangeOffset);
			break;

		default:
			break;
		}

		StocksDB.updateStockInDB(stock);

		mutex.unlock();

		return transactionValue;
	}

}

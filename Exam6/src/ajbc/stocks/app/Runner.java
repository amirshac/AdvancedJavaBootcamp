package ajbc.stocks.app;

public class Runner {

	public static void main(String[] args) {
		StockApp stockApp = new StockApp();
		stockApp.start();
	}

}

/*
 * OUTPUT:
 * 
<Stocks in DB>
Stock [name=BARVAZON, buyPrice=1.25, sellPrice=1.0]
Stock [name=HEADBOOK, buyPrice=9.52, sellPrice=9.33]
Stock [name=DOODLE, buyPrice=3.72, sellPrice=3.6]

Daily transaction price: 0.0
==============================================

==========[ EXECUTING COMMANDS ] ==============

java.lang.IllegalArgumentException: Stock is not found in DB
java.lang.IllegalArgumentException: Stock is not found in DB
java.lang.IllegalArgumentException: Stock is not found in DB
==============================================

===========[ AFTER COMMANDS ] ================

<Stocks in DB>
Stock [name=BARVAZON, buyPrice=1.5100000000000002, sellPrice=0.99]
Stock [name=HEADBOOK, buyPrice=9.54, sellPrice=9.31]
Stock [name=DOODLE, buyPrice=3.7600000000000002, sellPrice=3.5900000000000003]

Daily transaction price: 58.04000000000001
*/
package ajbc.stocks.db;

public class Stock {

	private String name;
	private double buyPrice;
	private double sellPrice;
	public Stock(String name, double buyPrice, double sellPrice) {
		setName(name);
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	private void setName(String name) {
		if(StockName.valueOf(name.toUpperCase()) != null) { //throws IllegalArgumentException
			this.name=name;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBuyPrice() {
		return buyPrice;
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	
	public void changeBuyPriceBy(double offset) {
		this.buyPrice += offset;
		if (buyPrice < 0)
			buyPrice = 0;
	}
	
	public void changeSellPriceBy(double offset) {
		this.sellPrice += offset;
		if (sellPrice < 0)
			sellPrice = 0;
	}
	
	@Override
	public String toString() {
		return "Stock [name=" + name + ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice + "]";
	}

}

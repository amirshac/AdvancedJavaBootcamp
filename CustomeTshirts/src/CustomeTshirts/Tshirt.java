package CustomeTshirts;

public class Tshirt {
	
	private static SIZE DEF_SIZE = SIZE.L;
	private static double MIN_DEMAND = 0.1;
	private static double MAX_DEMAND = 1;
	private static double DEF_DEMAND = MAX_DEMAND;
	private static double MIN_PRICE = 3;
	private static double DEF_PRICE = MIN_PRICE;
	private static double EXPENSIVE_PRICE = 10000;
	
	protected double basePrice;
	protected double demandFactor;
	protected SIZE size;
	protected Design design;
	protected double finalPrice;
	
	
	public Tshirt() {
		this(DEF_PRICE, DEF_DEMAND, DEF_SIZE, new Design());
	}
	
	public Tshirt(double basePrice, double demandFactor, SIZE size, Design design) {
		super();
		this.basePrice = basePrice;
		this.demandFactor = demandFactor;
		this.size = size;
		this.design = design;
		this.finalPrice = calculateFinalPrice();
	}
	
	public void setBasePrice(double basePrice) {
		this.basePrice = setValueWithinBounds(basePrice, MIN_PRICE, Double.MAX_VALUE);
		finalPrice = calculateFinalPrice();
	}

	public void setDemandFactor(double demandFactor) {
		this.demandFactor = setValueWithinBounds(demandFactor, MIN_DEMAND, MAX_DEMAND);
		finalPrice = calculateFinalPrice();
	}

	public void setSize(SIZE size) {
		this.size = size;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	protected double setValueWithinBounds(double value, double min, double max) {
		double result = value;
		if (result > max)
			result = max;
		else if (result < min)
			result = min;
		
		return result;
	}
	
	protected double calculateFinalPrice() {
		double result = (basePrice + design.complexity) * design.calculateArea() / demandFactor;
		finalPrice = result;
		return result;
	}
	
	protected boolean isExpensive() {
		return (finalPrice >= EXPENSIVE_PRICE);
	}
	
	
	@Override
	public String toString() {
		return "Tshirt [basePrice=" + basePrice + ", demandFactor=" + demandFactor + ", size=" + size + ", design="
				+ design + ", finalPrice=" + finalPrice + ", isExpensive? " + this.isExpensive() +"]";
	}


	public enum SIZE{
		XS, S, M, L, XL
	}
}

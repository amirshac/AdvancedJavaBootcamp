package VendingMachine.VendingMachine;

import VendingMachine.Runner.VendingMachine;

public abstract class Drink implements Produceable{

	// fields
	protected String name;
	protected float price;
	protected int volume;
	protected int temprature;
	protected boolean produced;
	
	private static final String DEF_NAME = "EMPTYDRINK";
	
	private static final int DEF_VOLUME = 100;
	private static final int MIN_VOLUME = 50;
	private static final int MAX_VOLUME = 200;
	
	private static final float DEF_PRICE = 5f;
	private static final float MIN_PRICE = 0f;
	private static final float MAX_PRICE = 300f;
	
	private static final int DEF_TEMPRATURE = 5;
	
	// constructor
	public Drink(String name, int volume, float price, int temprature) {
		this.name = name;
		setPrice(price);
		setVolume(volume);
		setTemprature(temprature);
		produced = false;
	}
	
	public Drink(String name, int volume, float price) {
		this(name, volume, price, DEF_TEMPRATURE);
	}
	
	public Drink(String name, int volume) {
		this (name, volume, DEF_PRICE);
	}
	
	public Drink(String name) {
		this(name, DEF_VOLUME);
	}
	
	public Drink() {
		this(DEF_NAME);
	}
	
	// setters

	public void setPrice(float price) {
		if ( price < MIN_PRICE)
			price = MIN_PRICE;
		else if (price > MAX_PRICE)
			price = MAX_PRICE;
		
		this.price = price;
	}

	public void setVolume(int volume) {	
		if ( volume < MIN_VOLUME )
			volume = MIN_VOLUME;
		else if ( volume > MAX_VOLUME )
			volume = MAX_VOLUME;
		
		this.volume = volume;
	}

	public void setTemprature(int temprature) {
		this.temprature = temprature;
	}
	
	public void setName(String name) {
		String newName = String.valueOf(name);
		this.name = newName;
	}

	@Override
	public void produce() {
		System.out.println();
		System.out.println("<Producing> ");
		System.out.println(this);
		
		if (this.volume > 0)
			produceWithWater();
	}
	
	private void produceWithWater(){
		System.out.println("Using water: "+ this.volume);
		System.out.println();
		
		if (VendingMachine.waterQtt < this.volume) {
			produced = false;
			VendingMachine.inService = false;
			System.out.println("Not enough water");
		}else {
			VendingMachine.waterQtt -= this.volume;
			produced = true;
		}
	}
	
	@Override
	public String toString() {
		String msg = String.format("<DrinkClass> Name:%s, Price:%.1f, Volume:%d, Temprature:%d",
				name, price, volume, temprature);
		return msg;
	}
}

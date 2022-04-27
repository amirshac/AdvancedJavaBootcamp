package javabootcamp.oop.exercise;
import javabootcamp.oop.abstraction.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public abstract class HomeAppliance implements Appliable {
	protected String manufacturer;
	protected int purchaseYear;
	protected int powerConsumption;
	
	// constructors
	
	public HomeAppliance(String manufacturer, int purchaseYear, int powerConsumption){
		setManufacturer(manufacturer);
		setPurchaseYear(purchaseYear);
		setPowerConsumption(powerConsumption);
	}
	
	public abstract int getConsumption (int hoursWorked);
	
	// setters getters
	
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public int getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(int powerConsumption) {
		if (powerConsumption > 0) {
			this.powerConsumption = powerConsumption;	
		}
	}

	public void setManufacturer(String manufacturer) {
		if (manufacturer!=null) {
			this.manufacturer = manufacturer.toUpperCase();
		}
		
		this.manufacturer = manufacturer;
	}
	
	public int getPurchaseYear() {
		return purchaseYear;
	}
	
	public void setPurchaseYear(int purchaseYear) {
		int currentYear = (Calendar.getInstance()).get(Calendar.YEAR);
		
		if (purchaseYear > 1900 && purchaseYear <= currentYear)
			this.purchaseYear = purchaseYear;
		else
			this.purchaseYear = currentYear;
	}

	@Override
	public String toString() {
		return "HomeAppliance manufacturer=" + manufacturer + ", purchaseYear=" + purchaseYear + ", consumption: " + powerConsumption;	
	}
	
	@Override
	public LocalTime turnOn(){
		LocalTime turnOnTime = LocalTime.now();
		System.out.println("Turned on at " + turnOnTime);
		return turnOnTime;
	}
	 
	@Override
	public long turnOffSec(LocalTime on) {
		LocalTime off = LocalTime.now(); 
		long duration = on.until(LocalTime.now(),ChronoUnit.SECONDS);
		
		System.out.println("Turned off at " + off + " Duration since turned on: " + duration);
		
		return duration;
	}
	
}

package javabootcamp.oop.polymorphism;

public class Delivery {
	private static long counter = 0;
	protected String clientName;
	protected String address;
	protected final long ID;
		
	public Delivery(String clientName, String address) {
		this.clientName = clientName;
		this.address = address;
		ID = ++counter;
	}
	
	void deliver() {
		String msg = String.format("Hi I have a delivery for %s at %s", clientName, address);
		System.out.println(msg);
	}
	
	@Override
	public String toString() {
		String msg = "Delivery";
		return msg;
	}
}

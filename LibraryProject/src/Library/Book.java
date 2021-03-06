package Library;

import java.util.Random;

public abstract class Book implements Readable {
	protected int quantity;
	protected String name;
		
	public Book(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		String msg = new String();
		msg += String.format("<Book> Name: %s, Quantity: %d", name, quantity);
		return msg;
	}
	
	public void approach() {
		Random random = new Random();
		int randomAction = random.nextInt(0, 2);
		switch(randomAction) {
		case 0: 
			read();
			break;
		case 1:
			returnBook();
			break;
		default:
			break;
		}
	}
	
	public void read() {
		System.out.println("I would like to read " + this);
		
		if (quantity > 0) {
			System.out.println("Reading -> " + this.name);
			quantity --;
		} else
			System.out.println("Not in inventory " + this.name);
	}
	
	public void returnBook() {
		quantity ++;
		System.out.println("Returning " + this);
	}
	
	enum BookType{
		COOKING,
		NOVEL,
		DICTIONARY
	}
}


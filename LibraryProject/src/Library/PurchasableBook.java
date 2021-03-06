package Library;

import java.util.Random;

public class PurchasableBook extends BorrowableBook implements Purchasable{
	private int price;
	
	public PurchasableBook(String name, int quantity, int borrowingDays, int price){
		super(name, quantity, borrowingDays);
		this.price = price;
	}

	@Override
	public void approach() {
		Random random = new Random();
		int randomAction = random.nextInt(0, 4);
		switch(randomAction) {
		case 0: 
			read();
			break;
		case 1:
			returnBook();
			break;
		case 2:
			borrow();
			break;
		case 3:
			purchase();
			break;
		default:
			break;
		}		
	}
	
	public void purchase() {
		System.out.println("I would like to purchase " + this);
		
		if (quantity > 0) {
			System.out.println("purchasing -> " + this.name);
			quantity --;
		} else
			System.out.println("Not in inventory " + this.name);		
	}
	
	@Override
	public String toString() {
		String msg = new String();
		msg = super.toString();
		msg += String.format(" <Purchasable> Price: %d", price);
		return msg;
	}
	
}

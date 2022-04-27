package Library;

import java.util.Random;

public class BorrowableBook extends Book implements Borrowable {

	private int borrowingDays;
	
	public BorrowableBook(String name, int quantity, int borrowingDays) {
		super(name, quantity);
		this.borrowingDays = borrowingDays;
	}
	
	@Override
	public void approach() {
		Random random = new Random();
		int randomAction = random.nextInt(0, 3);
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
		default:
			break;
		}		
	}

	public void borrow() {
		System.out.println("I would like to Borrow " + this);
		
		if (quantity > 0) {
			System.out.println("Borrowing -> " + this.name);
			quantity --;
		} else
			System.out.println("Not in inventory " + this.name);
	}
	
	public String toString() {
		String msg = new String();
		msg = super.toString();
		msg += String.format(" <Borrowing> Days: %d", borrowingDays);
		return msg;
	}
}

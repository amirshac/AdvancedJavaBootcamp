package Library.Runner;
import Library.*;

public class Library {

	public static void main(String[] args) {
		
		Book[] bookArray = {
			new ReadableBook("ReadMe", 3),
			new ReadableBook("ReadMoo", 2),
			new BorrowableBook("BorrowMe", 5, 10),
			new BorrowableBook("BorrowMoo", 1, 20),
			new PurchasableBook("BuyMe", 1, 10, 59),
			new PurchasableBook("BuyMoo", 3, 10, 69)
		};
		
		for (Book book : bookArray) 
			book.approach();
		
	}

/*RUN

Returning <Book> Name: ReadMe, Quantity: 4
Returning <Book> Name: ReadMoo, Quantity: 3
I would like to Borrow <Book> Name: BorrowMe, Quantity: 5 <Borrowing> Days: 10
Borrowing -> BorrowMe
Returning <Book> Name: BorrowMoo, Quantity: 2 <Borrowing> Days: 20
I would like to Borrow <Book> Name: BuyMe, Quantity: 1 <Borrowing> Days: 10 <Purchasable> Price: 59
Borrowing -> BuyMe
I would like to purchase <Book> Name: BuyMoo, Quantity: 3 <Borrowing> Days: 10 <Purchasable> Price: 69
purchasing -> BuyMoo

 * 
 Run2:
Returning <Book> Name: ReadMe, Quantity: 4
Returning <Book> Name: ReadMoo, Quantity: 3
I would like to read <Book> Name: BorrowMe, Quantity: 5 <Borrowing> Days: 10
Reading -> BorrowMe
Returning <Book> Name: BorrowMoo, Quantity: 2 <Borrowing> Days: 20
I would like to Borrow <Book> Name: BuyMe, Quantity: 1 <Borrowing> Days: 10 <Purchasable> Price: 59
Borrowing -> BuyMe
I would like to Borrow <Book> Name: BuyMoo, Quantity: 3 <Borrowing> Days: 10 <Purchasable> Price: 69
Borrowing -> BuyMoo

 */
}

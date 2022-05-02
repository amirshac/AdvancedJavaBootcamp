package Testing.Shirts;

public class Runner {

	
	public static void printShirts() {
		Shirt[] shirtArr = new Shirt[3];
		
		for (Shirt shirt : shirtArr) {
			System.out.println(shirt);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shirt shirt;
		shirt = new Shirt();
		System.out.println(shirt);
	}

}

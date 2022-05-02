package CustomeTshirts;

public class Runner {

	
	public static void printShirts() {
		Tshirt[] shirtArr = new Tshirt[3];
		
		for (Tshirt shirt : shirtArr) {
			System.out.println(shirt);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tshirt shirt;
		shirt = new Tshirt();
		System.out.println(shirt);
	}

}

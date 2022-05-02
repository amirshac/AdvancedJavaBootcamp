package Testing.Shirts;

import Testing.Shirts.Shirt.SIZE;

public class Runner {

	
	public static void printShirts() {
		Shirt[] shirtArr = new Shirt[3];
		
		Shirt shirt;
		Design design;
		Color color;
		
		shirt = new Shirt();
		shirtArr[0] = shirt;
		
		
		color = new Color((short)200, (short)201, (short)10);		
		design = new Design(15, 20, "Blue May", 10, color);
		shirt = new Shirt(20, 0.5, SIZE.S, design);
		shirtArr[1] = shirt;
		
		color = new Color((short)200, (short)201, (short)250);		
		design = new Design(30, 40, "Green Beans", 20, color);
		shirt = new Shirt(40, 0.9, SIZE.XL, design);
		shirtArr[2] = shirt;
		
		
		
		for (Shirt element : shirtArr) {
			System.out.println(element);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printShirts();
	}

}

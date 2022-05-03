package javabootcamp.basic.user_input;
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		
		// question 1 - calculate circle circumfarance from a given radius
		
		/*
		System.out.println("Enter radius:");
		float radius = scanner.nextFloat();
		final float pi = 3.14f;
		float circ = 2* pi* radius;
		System.out.printf("The circumference is: %.2f", circ);
		*/
		
		// Question 2 - Cafeteria price calculator
		/*
		final int TOASTPRICE = 12;
		final int CHEAPADDITIONPRICE = 2;
		final int EXPENSIVEADDITIONPRICE = 3;
		
		int orderPrice = 0;
		int howManyCheapAdditions = 0;
		int howManyExpensiveAdditions = 0;
		
		System.out.println("Your starting toast price is " + TOASTPRICE + "NIS");
		
		System.out.println("How many cheap additions? (" + CHEAPADDITIONPRICE + " NIS):");
		howManyCheapAdditions = scanner.nextInt();
		
		System.out.println("How many expensive additions? (" + EXPENSIVEADDITIONPRICE + " NIS):");
		howManyExpensiveAdditions = scanner.nextInt();
		
		orderPrice = TOASTPRICE + 
				(howManyCheapAdditions * CHEAPADDITIONPRICE) +
				(howManyExpensiveAdditions * EXPENSIVEADDITIONPRICE);
		
		System.out.println("Your order total is: " + orderPrice + " NIS");
		*/
		
		/*
		// Question 3 - Transport service calculator
		final int PRICEFOREACHKM = 5;
		final int PRICEFOREACHFLOORPERKG = 1;
		final int TIPPERCENTAGE = 10;
		
		int furniturePrice = 0;
		int weight = 0;
		int distanceFromStore = 0;
		int floorNumber = 0;
		int totalPrice = 0;
		
		// intermediate calculators
		int tipForMovers = 0 ;
		int priceForWeight = 0;
		int priceForDistance = 0;
		
		// inputs
		System.out.println("Furniture price: ");
		furniturePrice = scanner.nextInt();
		
		System.out.println("Furniture weight in KGs: ");
		weight = scanner.nextInt();
		
		System.out.println("Floor number: ");
		floorNumber = scanner.nextInt();
		
		System.out.println("Disance from store in KMs: ");
		distanceFromStore = scanner.nextInt();
		
		// calculations
		priceForDistance = PRICEFOREACHKM * distanceFromStore;
		priceForWeight = PRICEFOREACHFLOORPERKG * weight * floorNumber;
		tipForMovers = furniturePrice * TIPPERCENTAGE / 100;
		
		totalPrice = furniturePrice + priceForDistance + priceForWeight + tipForMovers;
		
		System.out.println("Total price for purchase and moving: " + totalPrice + " NIS");
		
		
		
		scanner.close();
		*/
		
	}
}

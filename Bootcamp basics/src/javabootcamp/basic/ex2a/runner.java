package javabootcamp.basic.ex2a;
import java.util.Scanner;

public class runner {

	public static void main(String[] args) {
		
		/*
		// question 1 - Minor or adult age
		Scanner scanner = new Scanner(System.in);
		final int ADULTAGE = 18;
		int age = 0;
		
		System.out.println("Enter age: ");
		age = scanner.nextInt();
		
		if (age >= ADULTAGE)
		{
			System.out.println("You are an adult");
		}
		else if (age > 0)
		{
			System.out.println("You are a minor");
		}
		else
		{
			System.out.println("Invalid age");
		}
		scanner.close();
		*/
		
		/*
		// Question 3 - Is identical digits on a 2 digit number, example 11 22 33
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		int digit1=0, digit2=0;
		
		System.out.println("Enter 2 digit number: ");
		num = scanner.nextInt();
		
		digit1 = num / 10;
		digit2 = num % 10;
		
		if ( digit1 == digit2 )
		{
			System.out.println("Identical digits");
		}
		else
		{
			System.out.println("NON identical digits");
		}
		
		scanner.close();
		*/
		
		/*
		// Question 5 - Is following digits in 2 digit number. example 45, 67
		Scanner scanner = new Scanner(System.in);
		int num, digit1, digit2;
		
		System.out.println("Enter 2 digit number: ");
		num = scanner.nextInt();
		
		digit1 = num / 10;
		digit2 = num % 10;
		
		if (digit1 == digit2-1)
		{
			System.out.println("Number has following digits");
		}
		else
		{
			System.out.println("Number DOES NOT HAVE following digits");
		}
		
		scanner.close();
		 */
		
		/*
		// Question 7 - Fuel capacity
		Scanner scanner = new Scanner(System.in);
		float fuelCapacity = 0;
		float warningFuel = 0;
		float currentFuel = 0;
		final float WARNINGPERCENT = 15;
		
		System.out.println("Enter your fuel capacity: ");
		fuelCapacity = scanner.nextFloat();
		
		System.out.println("Enter your current fuel meter: ");
		currentFuel = scanner.nextFloat();
		
		// calculate warning fuel range
		warningFuel = fuelCapacity * WARNINGPERCENT / 100;
		System.out.println("Your warning fuel level is: " + warningFuel);
		
		if (currentFuel <= warningFuel)
		{
			System.out.println("You need to fuel up");
		}
		else
		{
			System.out.println("You have enough fuel, safe drive!");
		}
		scanner.close();
		*/
		
		// Question 9 - Date parsing, for example 08062014 = day 8, month 6, year 2014
		/*
		Scanner scanner = new Scanner(System.in);
		int fullDate = 0;
		int tempDate = 0;
		int day, month, year;
		
		final int MONTHMASK = 100;
		final int YEARMASK = 10000;
		
		System.out.println("Enter date [ddmmyyyy]: ");
		fullDate = scanner.nextInt();
		
		tempDate = fullDate;
		
		/*
		 * example for tempdate:
		 * 01021999 % YEARMASK -> 1999
		 * 01021999 / YEARMASK -> 0102
		 * 0102 % MONTHMASK -> 02
		 * 0102 / MONTHMASK -> 01
		 * 01 -> day
		 */
		/*
		// extract year
		year = tempDate % YEARMASK;
		tempDate /= YEARMASK;

		// extract month from remaining date
		month = tempDate % MONTHMASK;  
		tempDate /= MONTHMASK; 
		
		day = tempDate; // remaining is day
		
		System.out.println("The year is: " + year + ", the month is: " + month + " and the day is " + day);
		
		scanner.close();
		*/
		
		// Exercise - size of parts. 
		// Detector. larger part prints 1, smaller part reject -1, perfect part 0
		
		Scanner scanner = new Scanner(System.in);
		int parts = 0;
		int input = 0;
		int largers=0, smallers=0, perfects=0;
		
		System.out.println("Enter number of parts: ");
		parts = scanner.nextInt();
		
		input = 1;
		for (int i=1; i<=parts; i++)
		{
			while (true)
			{
				System.out.print("Part " + i + "(-1,0,1):");
				input = scanner.nextInt();
			
				switch(input){
			
					case -1:
						smallers++;
						break;
					
					case 0:
						perfects++;
						break;
					
					case 1:
						largers++;
						break;
						
					default:
						System.out.println("Incorrect input, try again");
						break;
				} // end switch
			} // end while
		} // end for
		
		System.out.println("Smaller parts: " + smallers);
		System.out.println("Larger parts: " + largers);
		System.out.println("Perfect parts: " + perfects);
		
		scanner.close();
	}
}

package javabootcamp.basic.loops;
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		
		/*
		// check if a number is prime
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		boolean isPrime = true;
		
		System.out.println("Enter number to check if prime: ");
		num = scanner.nextInt();
		
		for (int i=2; i<num; i++)
		{
			if (num%i == 0)
			{
				isPrime = false;
				return;
			}
		}
		
		scanner.close();
		*/
		
		/*
		// construct number until negative is given 
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		int input = 0;
		
		do{			
			num *= 10;	
			num += input;
			
			System.out.println("Enter integers (negative number to terminate: ");
			input = scanner.nextInt();
		}while (input >= 0);
		
		System.out.println("The number created is: " + num);
		scanner.close();
		*/
		
		Scanner scanner = new Scanner(System.in);
		int num = 1, prevNum = 1;
		int multi = 0;
		
		System.out.println("Enter number: ");
		multi = scanner.nextInt();
		
		do {
			prevNum = num;
			for (int i=1; i<multi; i++)
			{
				num+=prevNum;
			}

			System.out.println("Enter number to multiply: ");
			multi = scanner.nextInt();
			
			if (multi == 0)
			{
				num = 0;
			}
			
			}while (multi > 0);
		
		System.out.println("Product is: " + num);
		
		scanner.close();
		
	}	
}

package javabootcamp.basic.conditions;
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		
	/*	
		// Question 4 - division by 1 2 3 and 4
		Scanner scanner = new Scanner(System.in);
	
		int num = 0;
		
		System.out.println("Enter number: ");
		num = scanner.nextInt();
		
		// naive solution
//		if ( num%3==0 && num%4==0 )
//		{
//			System.out.println(num + " is divided by 1,2,3 and 4");
//		}
		
		/*
		// common divisor of 3 and 4 is 12
		final int DIVISOR = 12;
		String result = "";
		
		if (num%DIVISOR==0){
	
		}
		else {
			result = "NOT ";
		}
		System.out.println(num+" is "+result+"dividable");
		System.out.println("Goodbye");
		
		
		// ternary operator
		final int DIVISOR = 12;
		String result = (num%DIVISOR==0) ? " is" : " IS NOT";
		System.out.println(num + result + " dividable");
		
		scanner.close();
		*/
		
		/*
		
		// Question - checks if number is within range of two other numbers
		Scanner scanner = new Scanner(System.in);
		
		int numToCheck, start, end;
		
		System.out.println("Enter number to check within range: ");
		numToCheck = scanner.nextInt();
		
		System.out.println("First range: ");
		start = scanner.nextInt();
		
		System.out.println("Second range: ");
		end = scanner.nextInt();
		
		// swap if range is opposite
		if (start > end) {
			int temp = end;
			end = start;
			start = temp;
		}
		
		String res = "";
		if (numToCheck < start) {
			res = "Smaller than ";
		} 
		else if (numToCheck > end){
			res = "Greater than ";
		} 
		else {
			res = "in ";
		}
		
		String finalRes = numToCheck + " is " + res + "the range " + start + " to" + end;
		System.out.println(finalRes);
		
		scanner.close();
		
		*/
		
		// QUESTION - takes in year and month number and outputs name of the month and number of days in it
		/*
		int year, month=0, daysInMonth=0;
		String monthName = "";
		boolean isLeapYear = false;
		boolean isValidMonth = true;
		boolean isValidYear = true;
		
		Scanner scanner = new Scanner(System.in);
	
		// handle year
		System.out.println("Enter year: ");
		year = scanner.nextInt();
		if (year < 1 || year > 9999)
		{
			isValidYear = false;
		}

		if (!isValidYear)
		{
			System.out.println("Invalid year");
			return;
		}
		
		// handle month
		System.out.println("Enter month number: ");
		month = scanner.nextInt();
		
		switch (month) {
		
		case 1 :
			monthName = "Jan";
			daysInMonth = 31;
			break;
			
		case 2:
			monthName = "Feb";
			daysInMonth = 28;
			
			// checks leap year, 2020 was a leap year and its every 4 years
			if (year%4==0)
			{
				daysInMonth = 29;
				isLeapYear = true;
			}
			
			break;
			
		case 3:
			monthName = "Mar";
			daysInMonth = 31;
			break;
			
		case 4:
			monthName = "Apr";
			daysInMonth = 30;
			break;

		case 5:
			monthName = "May";
			daysInMonth = 31;
			break;
			
		case 6:
			monthName = "Jun";
			daysInMonth = 30;
			break;
			
		case 7:
			monthName = "Jul";
			daysInMonth = 31;
			break;
			
		case 8:
			monthName = "Aug";
			daysInMonth = 31;
			break;
			
		case 9:
			monthName = "Sep";
			daysInMonth = 30;
			break;
			
		case 10:
			monthName = "Oct";
			daysInMonth = 31;
			break;
			
		case 11:
			monthName = "Nov";
			daysInMonth = 30;
			break;
			
		case 12:
			monthName = "Dec";
			daysInMonth = 31;
			break;
			
		default:
			monthName = "INVALID";
			isValidMonth = false;
		}
	
		if (!isValidMonth)
		{
			System.out.println("Invalid month");
			return;
		}
		
		// result string
		String res = "";
		res = monthName + " " + year + " has " + daysInMonth + " days.";
		if (isLeapYear) res+= "It was a leap year.";
		
		System.out.println(res);
		
		scanner.close();
		
		*/
		

	}
	
}

package javabootcamp.basic.exam;

/*
 * AMIR SHACHAR JAVA BASIC EXAM 7.4.2022
 * 
 *Question 1 - 
 * JDK - Java Development Kit - 
 * Collection of software components for development in java, includes runtime environment, complier
 * interpreter and other tools to develop in java
 * JDK includes the JRE and JVM
 * 
 * JRE - Java Runtime Environment - software components that run java - this is what the end user needs   
 * JRE includes the JVM
 * 
 * JVM - Java virtual machine - is how the computer runs java, it loads and runs the java bytecode
 * using the interpreter.
 * Different JVMs are made for different operation systems but run the same bytecode. 
 * This way the code its OS independent
 * 
 * 
 * Question 2 - 
 * The complier turns the java code into bytecode classes (intermediery code that will be run by the JVM)
 * At runtime - the JVM runs the code. 
 * Class loader loads the classes (bytecode) into memory 
 * (with security methods built in to make sure the code is safe)
 * then the code is executed by the interpreter 
 */

public class Runner {

	// Question 3 Methods 
	public static int reverseNumber(int num)
	{
		int reversedNumber = 0;
		int tempNumber = num;
		int digit = 0;
		
		while (tempNumber > 0) {
			digit = tempNumber % 10;
			
			reversedNumber *= 10;
			reversedNumber += digit;
			
			tempNumber /= 10;
		}
		
		return reversedNumber;
	}
	
	public static boolean isPalindrome(int num) {
		
		if (num <= 0) {
			return false;
		}
		
		int reversedNum = reverseNumber(num);
		boolean result = (num == reversedNum) ? true : false;
		
		return result;
	}
	
	// ------------------------------------------------------------------------------------
	
	// Question 4 methods -
	public static void printArray(int[] arr) {
		for (int element : arr) {
			System.out.print("["+element+"] ");
		}
		System.out.println();
	}
	
	public static int sumArray(int[] arr)
	{
		int sum = 0;
		
		for (int element : arr) {
			sum += element;
		}
		
		return sum;
	}
	
	// Constructs array from two arrays
	// smaller sum array in the beginning, 
	// larger sum array in the end, 
	// Two last spots for arrays sum and difference
	public static int[] constructArrayFromTwoArraysWithSumAndDiffereceAtTheEnd(int[] arr1, int[] arr2) {
		final int EXTRA_ALLOCATION_FOR_RESULTS = 2;
		int sum1, sum2, sumDifference;
		int indexResult;
		
		int[] smallerSumArray;
		int[] biggerSumArray;
		
		int[] resultArray = new int[arr1.length + arr2.length + EXTRA_ALLOCATION_FOR_RESULTS];
		
		sum1 = sumArray(arr1);
		sum2 = sumArray(arr2);
		sumDifference = Math.abs(sum1 - sum2);
		
		// Decide which array sum is larger
		if (sum1 > sum2) {
			biggerSumArray = arr1;
			smallerSumArray = arr2;
		}else {
			biggerSumArray = arr2;
			smallerSumArray = arr1;
		}
		
		// construct new array from both
		indexResult = 0;
		
		for (int element : smallerSumArray) {
			resultArray[indexResult] = element;
			indexResult ++;
		}
		
		for (int element : biggerSumArray) {
			resultArray[indexResult] = element;
			indexResult ++;
		}
		
		// two additions at the end of the new array - sum and difference
		resultArray[indexResult] = sum1 + sum2;
		resultArray[indexResult+1] = sumDifference;
		
		return resultArray;
	}
	

	// ---------------------------------------------------------------------------------------------
	
	
	// Question 3 is here
	public static void executeQuestion3()
	{
		boolean isPal = false;
		
		int[] testArr = { 
				123454321,
				121,
				3443,
				5,
				91,
				12320
		};
		
		for (int element : testArr) {
			isPal = isPalindrome(element);
			System.out.println(element + " is palindrome? - " + isPal);		
		}

		/*
		 * Run:
		 *	123454321 is palindrome? - true
			121 is palindrome? - true
			3443 is palindrome? - true
			5 is palindrome? - true
			91 is palindrome? - false
			12320 is palindrome? - false
		 */
	}
	
	// Question 4 is in here
	public static void executeQuestion4()
	{
		// Question 4
		int[] arr1 = { 7, 8, -4 };
		int[] arr2 = { -5, 7, 3, 2};
		
		int[] resultArray = constructArrayFromTwoArraysWithSumAndDiffereceAtTheEnd(arr1, arr2);
		
		printArray(arr1);
		printArray(arr2);
		printArray(resultArray);
		
		/*
			Run: 
			[7] [8] [-4] 
			[-5] [7] [3] [2] 
			[-5] [7] [3] [2] [7] [8] [-4] [18] [4]
		 */		
	}
	
	public static void main(String[] args) {
		
		executeQuestion3();
		executeQuestion4();
	}

}

package javabootcamp.basic.ex5;
import java.util.Scanner;

public class runner {
	
	public static void printArray(int[] arr) {
		for (int element : arr) {
			System.out.print("[" + element + "] ");
		}
		System.out.println();
	}
	
	public static void execute51()
	{
		/*
		 
		// EX 5.1 - reverse strings
		final int ARRAY_SIZE = 5;
		int[] arrA = new int[ARRAY_SIZE];
		int[] arrB = new int[ARRAY_SIZE];
		int input = 0;
		
		int indexA=0, indexB=arrB.length-1;
		
		boolean isReverse = true;
		boolean keepGoing = true;

		Scanner scanner = new Scanner(System.in);
		
		for (int i=0; i<arrA.length; i++) {
			System.out.println("Array A, position " + i + " :");
			input = scanner.nextInt();
			arrA[i] = input;
		}
		
		for (int i=0; i<arrB.length; i++) {
			System.out.println("Array B, position " + i + " :");
			input = scanner.nextInt();
			arrB[i] = input;
		}
		
		while (keepGoing) {
			if (arrA[indexA] == arrB[indexB]) {
				indexA++;
				indexB--;
			} else {
				isReverse = false;
				keepGoing = false;
				break;
			}
			
			// if we reached the end of any array, quit
			if (indexA >= arrA.length || indexB < 0)
			{
				keepGoing = false;
				break;
			}
		} // end while
		
		if (isReverse) System.out.println("Reverse arrays");
		else System.out.println("Not reverse arrays");
		
		scanner.close();
		*/		
	}

	public static void execute53() {
		/*
		// EX 5.3 - fibonachi array
		Scanner scanner = new Scanner(System.in);
		final int ARRAY_SIZE = 10;
		int input;
		
		int[] arr = new int[ARRAY_SIZE];
		
		System.out.println("First number: ");
		input = scanner.nextInt();
		arr[0] = input;
		
		System.out.println("Second number: ");
		input = scanner.nextInt();
		arr[1] = input;
		
		for (int i=2; i<arr.length; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		// print array
		for (int element : arr) {
			System.out.println(element + " ");
		}
		
		scanner.close();	
		
		*/	
	}
	
	public static void execute55() {
		/*
		// EX 5.5 - array shifted right [1,2,3] -> [3,2,1]
		Scanner scanner = new Scanner(System.in);
		
		final int ARRAY_SIZE = 3;
		
		int[] arrA = new int[ARRAY_SIZE];
		int[] arrB = new int[ARRAY_SIZE];
		
		boolean isShifted = true;
		boolean keepGoing = true;
		
		// input
		for (int i=0; i<arrA.length; i++)
		{
			System.out.println("Array A, position " + i + ":");
			arrA[i] = scanner.nextInt();
		}
		
		for (int i=0; i<arrB.length; i++)
		{
			System.out.println("Array B, position " + i + ":");
			arrB[i] = scanner.nextInt();
		}

		// endcase 
		if (arrA[arrA.length-1] != arrB[0]) {
			isShifted = false;
		} 
		
		if (isShifted) {
			for (int i=0; i<arrA.length-1; i++)
			{
				if (arrA[i] != arrB[i+1])
				{
					isShifted = false;
					break;
				}
			}	
		}
		
		System.out.println(isShifted);
		scanner.close();
		
		*/		
	}
	
	public static void execute57() {
		// Ex 5.7 - copy same numbers from two arrays into array C
		
		Scanner scanner = new Scanner(System.in);
		final int ARRAY_SIZE = 5;
		
		int[] arrA = new int[ARRAY_SIZE];
		int[] arrB = new int[ARRAY_SIZE];		
		int[] arrC = new int[ARRAY_SIZE];
		int arrCSize = 0;
		
		int indexA=0, indexB=0, indexC=0;
		
		// input
		for (int i=0; i<arrA.length; i++)
		{
			System.out.println("Array A, position " + i + ":");
			arrA[i] = scanner.nextInt();
		}
		
		for (int i=0; i<arrB.length; i++)
		{
			System.out.println("Array B, position " + i + ":");
			arrB[i] = scanner.nextInt();
		}

		boolean keepGoing = true;
		
		while (keepGoing)
		{
			if (arrA[indexA] < arrB[indexB]) {
				indexA ++;
			} else if ( arrA[indexA] > arrB[indexB] ){
				indexB ++;
			}
			else {
				arrC[indexC] = arrA[indexA];
				indexC++;
			}
			
			if (indexA > arrA.length-1 || indexB > arrB.length-1) {
				keepGoing = false;
			}
			
		}
		
		arrCSize = indexC+1;
		
		scanner.close();
	}
	
	// EX 5.9
	public static int sumOfDigits(int num) {
		int sumOfDigits = 0;
		int digit = 0;
		
		while ( num > 0 ) {
			digit = num % 10;
			sumOfDigits += digit;
			num /= 10;
		}
		
		return sumOfDigits;
	}
	
	public static boolean isSumOfDigitsInTwoArraysIdenticalForEachCell(int[] arr1, int[] arr2) {		
		boolean result = true;
		
		for (int i=0; i<arr1.length; i++) {
			if ( sumOfDigits(arr1[i]) != sumOfDigits(arr2[i]) ) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	
	public static void execute59() {
		int[] arr1 = {14, 61, 227};
		int[] arr2 = {23, 43, 92};
		int[] arr3 = {23, 43, 0};
		boolean result;
		
		printArray(arr1);
		printArray(arr2);
		
		result = isSumOfDigitsInTwoArraysIdenticalForEachCell(arr1, arr2);
		System.out.println("Is sum of digits identical for each cell? - " + result);
		
		printArray(arr2);
		printArray(arr3);
		
		result = isSumOfDigitsInTwoArraysIdenticalForEachCell(arr2, arr3);
		System.out.println("Is sum of digits identical for each cell? - " + result);
		
/*run:
[14] [61] [227] 
[23] [43] [92] 
Is sum of digits identical for each cell? - true
[23] [43] [92] 
[23] [43] [0] 
Is sum of digits identical for each cell? - false
 */
	}
	// ---------------------------------------------------------------------------------
	
	// EX 5.11
	
	public static void printMatrix(int[][] matrix, int rows, int cols) {	
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				System.out.printf("[%3d]", matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int element : row) {
				System.out.printf("[%3d]", element);
			}
			System.out.println();
		}
	}
	
	public static boolean isValueInRange(int value, int i, int j) {
		boolean result = (value>=i) && (value<=j);
		return result;
	}
	
	public static int maxValueInRow(int[][] matrix, int rowIndex) {
		int max = matrix[rowIndex][0];
		
		for (int i=0; i<matrix[rowIndex].length; i++) {
			max = Math.max(max, matrix[rowIndex][i]);
		}
		
		return max;
	}
	
	public static int maxValueInCol(int[][] matrix, int colIndex) {
		int max = matrix[0][colIndex];
		
		for (int i=0; i<matrix.length; i++) {
			max = Math.max(max, matrix[i][colIndex]);
		}
		
		return max;
	}
	
	public static int maxValueInOuterFrame(int[][] matrix, int rows, int cols) {
		int max = maxValueInRow(matrix, 0);
		max = Math.max(max, maxValueInRow(matrix, rows-1) );
		max = Math.max(max, maxValueInCol(matrix, 0) );
		max = Math.max(max, maxValueInCol(matrix, cols-1) );
		
		return max;
	}
	
	public static int getInputWithRange(String msg, int min, int max, Scanner scanner) {
		int inputNum = 0;
		boolean isInRange = false;
		final String ERROR_MSG = "Value range is %d-%d. Try again.%n";
			
		do {
			System.out.print(msg);
			inputNum = scanner.nextInt();
			
			isInRange = isValueInRange(inputNum, min, max);
			
			if (!isInRange) {
				System.out.printf(ERROR_MSG, min, max);
			}
		} while (!isInRange);
		
		return inputNum;
	}
		
	public static void inputIntoArray (int[] arr, int size, Scanner scanner) {
		System.out.printf("Enter %d numbers: ", size);
		
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();	
		}
	}
	
	public static void inputIntoMatrix(int[][] matrix, int rows, int cols, Scanner scanner) {
		for (int i=0; i < rows; i++) {
			System.out.printf("Row %d: ", i);
			inputIntoArray(matrix[i], cols, scanner);
		}
	}
	
	public static void execute511() {
		final int MAX_MATRIX_SIZE = 10;
		final int MIN_MATRIX_SIZE = 1;
		int[][] matrix = new int[MAX_MATRIX_SIZE][MAX_MATRIX_SIZE];
		int rows=0, cols=0;
		int frameMaxValue = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		/*
		TEST MATRIX
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 200, 7, 8},
				{9, 30, 11, 12}
		};
		
		rows = 3;
		cols = 4;
		*/

		
		rows = getInputWithRange("Enter rows --> ", MIN_MATRIX_SIZE, MAX_MATRIX_SIZE, scanner);
		cols = getInputWithRange("Enter cols --> ", MIN_MATRIX_SIZE, MAX_MATRIX_SIZE, scanner);
		
		inputIntoMatrix(matrix, rows, cols, scanner);
		
		printMatrix(matrix, rows, cols);
		
		frameMaxValue = maxValueInOuterFrame(matrix, rows, cols);
		System.out.printf("Outer frame max value: %d%n", frameMaxValue);
		
		scanner.close();
		
/*run1: with demo matrix
 
[  1][  2][  3][  4]
[  5][200][  7][  8]
[  9][ 30][ 11][ 12]
Outer frame max value: 30

run2: with input

Enter rows --> 4
Enter cols --> 3
Row 0: Enter 3 numbers: 10 20 30
Row 1: Enter 3 numbers: -18 2 41
Row 2: Enter 3 numbers: 22 12 2
Row 3: Enter 3 numbers: 0 0 -1
[ 10][ 20][ 30]
[-18][  2][ 41]
[ 22][ 12][  2]
[  0][  0][ -1]
Outer frame max value: 41
 */
	}
	
	// ----------------------------------------------------------------
	// EX 5.15 - folded matrix
	
	public static boolean isFoldedMatrix(int[][] matrix) {
		boolean isFolded = true;
		
		for (int i=0; i<matrix.length; i++) {
			
			if (!isFolded) break;
			
			for (int j=0; j<matrix.length; j++) {
				
				// skip diagnal line
				if ( i == j ) {
					break;
				}
				
				if (matrix[i][j] != matrix[j][i]) {
					isFolded = false;
					break;
				}
			}
		}
		
		return isFolded;
	}
	
	public static void execute515() {
		
		int[][] matrix = {
				{9, 2, 3, 4},
				{2, 9, 6, 3}, 
				{3, 6, 9, 2},
				{4, 3, 2, 9}
		};
		
		int[][] matrix2 = {
				{9, 2, 3, 4},
				{2, 9, 0, 3}, 
				{3, 6, 9, 2},
				{4, 3, 2, 9}
		};
		
		boolean isFolded = false;
		
		isFolded = isFoldedMatrix(matrix);
		
		printMatrix(matrix);
		System.out.printf("Is folded? - %b%n%n", isFolded);
		
		isFolded = isFoldedMatrix(matrix2);
		
		printMatrix(matrix2);
		System.out.printf("Is folded? - %b%n", isFolded);
		
/* Run:
[  9][  2][  3][  4]
[  2][  9][  6][  3]
[  3][  6][  9][  2]
[  4][  3][  2][  9]
Is folded? - true

[  9][  2][  3][  4]
[  2][  9][  0][  3]
[  3][  6][  9][  2]
[  4][  3][  2][  9]
Is folded? - false
 */
		
	}
	
	public static void main(String[] args) {
		execute515();
		//execute511();
		//execute59();
		//execute57();		
	} // end main

		
} // end class

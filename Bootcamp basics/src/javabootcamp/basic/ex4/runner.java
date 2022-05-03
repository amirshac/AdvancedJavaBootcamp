package javabootcamp.basic.ex4;
import java.util.Scanner;

public class runner {

	// EX 4.2 - construct number from 'even' positions
	public static void execute42() {
		Scanner scanner = new Scanner(System.in);
		
		int num = 0;
		int newNum = 0;
		int digit = 0;
		int position = 0;
		int positionInNewNum = 1;
		
		System.out.println("Enter number: ");
		num = scanner.nextInt();
		
		while (num > 0)
		{
			digit = num % 10;
			num /= 10;
			
			// only construct new number from even positions
			if (position%2 == 0) {
				newNum += digit * positionInNewNum;
				positionInNewNum *= 10;
			}
			
			position++;
		} // end while 
		
		System.out.println("Constructed number: " + newNum);
		scanner.close();
	}
	
	//--------------------------------------------------------------------------
	
	// EX 4.4
	public static void execute44() {
		// EX 4.4 - Luhn ID algorithm
		
		final int EIGHT_DIGITS = 9999999;
		
		int digit = 0;
		int controlDigit = 0;
		int controlNumber = 0;
		int weight = 0;
		int sum = 0;
		int digitWeight = 0;
		int number = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		number = scanner.nextInt();
		
		// 9 digits -> right most digit weight is 2
		// 8 digits -> right most digit weight is 1
		digitWeight = (number > EIGHT_DIGITS) ? 2 : 1;
		
		// first digit on the right is control digit
		controlDigit = number % 10;
		number /= 10;
		
		while (number > 0)
		{
			digit = number % 10;
			
			weight = digit * digitWeight;
			
			if (weight < 10)
			{
				sum += weight;
			}
			// if weight >= 10 then sum weight digits again. Example: 16 -> 1+6
			else
			{
				sum += (weight % 10) + (weight / 10);
			}
			
			// alternate between digit weight 1 and 2
			digitWeight = (digitWeight==1) ? 2 : 1;
			
			number /= 10;
		}
		
		// reach the gap to the closest multiplication of 10. Example: 41 -> 1 -> 10-1 -> 9
		controlNumber = 10 - sum%10;
		
		if (controlNumber == controlDigit)
		{
			System.out.println("Valid control digit");
		} else {
			System.out.println("INVALID CONTROL DIGIT");
		}
		
		scanner.close();
		
	}
	
	//-------------------------------------------------------------------------
	
	// EX 4.6 - Original + reversed number. Example: 123 -> 123321
	public static void execute46() {
		int result=0, digit=0, tempNumber=0, inputNumber = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number: ");
		inputNumber = scanner.nextInt();
		
		tempNumber = inputNumber;
		result = inputNumber;
		
		while (tempNumber > 0) {
			digit = tempNumber % 10;
			result *= 10;
			result += digit;
			
			tempNumber /= 10;
		}
		
		System.out.println("Result number: " + result);
		
		scanner.close();
		
	}
	
	//--------------------------------------------------------------------------
	
	// EX 4.12 - print triangle
	public static void execute412() {
		int triangleSize = 0;
		int line=0, spaces=0, stars=0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter triangle size: ");
		triangleSize = scanner.nextInt();
		
		scanner.close();
		
		for (line = 0; line < triangleSize; line ++){
			
			for (spaces = 0; spaces < line; spaces ++){
				System.out.print(" ");
			}
			
			for (stars = triangleSize; stars > line; stars --)
			{
				System.out.print("* ");
			}
			
			System.out.println();
		}	
	}
	
	// -------------------------------------------------------------------------
	
	// EX 4.14 - Print rug
	public static void execute414() {
		int rugSize = 0;
		int line=0, square=0, patch=0, rug=0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter rug size: ");
		rugSize = scanner.nextInt();
		
		scanner.close();

		for (rug = 0; rug < rugSize; rug++) {

			for (patch = 0; patch < rugSize; patch++) {
				
				for (square = 0; square < rugSize; square ++) {
					
					for (line = 0; line < rugSize; line ++){
						System.out.print("*");
					} // line
				
					System.out.print(" ");
				} // square
				
				System.out.println();
			} // patch

			System.out.println();
		} // rug		
	}
	
	//-----------------------------------------------------------------------------
	
	// EX 4.16 - mate numbers
	public static int sumOfDividers(int num) {
		int divider = 1;
		int sum = 0;
		
		for (divider=1; divider<num; divider++) {
			if (num % divider == 0) {
				sum += divider;
			}
		}
		
		return sum;
	}
	
/*	
	public static boolean isMateNumbers(int num1, int num2) {
		int sum1, sum2;
		boolean isMates = false;
		
		sum1 = sumOfDividers(num1);
		sum2 = sumOfDividers(num2);
		
		isMates = (sum1==sum2);
		return isMates;
	}
	*/
	
	public static void printMateNumbers(int numOfNumbersToFind) {
		int numbersFound = 0;
		final int SMALLEST_MATE_1 = 220;
		final int SEARCH_SCOPE = 100000;
		
		int num = SMALLEST_MATE_1;
		int sum = 0;
		int numToCheck = 0;
		int sumToCheck = 0;
		
		boolean keepGoing = true;
		
		while (keepGoing) {
			sum = sumOfDividers(num);
			numToCheck = sum;
			sumToCheck = sumOfDividers(numToCheck);
			
			if  ( (num == sumToCheck) && (num != numToCheck) ){
				System.out.printf("%d and %d are mates%n", num, numToCheck);
				
				num = numToCheck+1;
				
				numbersFound ++;
			}
			
			
			num ++;
			
			if ( (numbersFound > numOfNumbersToFind) || (num > SEARCH_SCOPE) ){
				keepGoing = false;
			}
			
		}
	}
	
	public static void execute416() {
		printMateNumbers(10);

		/* Run:
		220 and 284 are mates
		1184 and 1210 are mates
		2620 and 2924 are mates
		5020 and 5564 are mates
		6232 and 6368 are mates
		10744 and 10856 are mates
		12285 and 14595 are mates
		17296 and 18416 are mates
		63020 and 76084 are mates
		79750 and 88730 are mates		
		 */
		
	}
	
	// --------------------------------------------
	
	public static void execute48() {
		final int SCOPE_MIN = 10;
		final int SCOPE_MAX = 99;
		
		int moneDigit, mechaneDigit;
		double fractionA, fractionB;
		int numbersFound = 0;
		
		for (int mone = SCOPE_MIN; mone < SCOPE_MAX; mone++) {
			for (int mechane = mone+1; mechane <= SCOPE_MAX; mechane++) {
				moneDigit = mone/10;
				mechaneDigit = mechane%10;
				
				fractionA = (double)mone/(double)mechane;
				fractionB = (double)moneDigit/(double)mechaneDigit;
				
				if (fractionA == fractionB) {
					numbersFound++;
					System.out.printf("%d/%d == %d/%d -> %f%n", mone, mechane, moneDigit, mechaneDigit, fractionA);	
				}
			}
		}
		
		System.out.println("Numbers found: " + numbersFound);
		
		/*Run:
11/22 == 1/2 -> 0.500000
11/33 == 1/3 -> 0.333333
11/44 == 1/4 -> 0.250000
11/55 == 1/5 -> 0.200000
11/66 == 1/6 -> 0.166667
11/77 == 1/7 -> 0.142857
11/88 == 1/8 -> 0.125000
11/99 == 1/9 -> 0.111111
13/65 == 1/5 -> 0.200000
15/75 == 1/5 -> 0.200000
16/32 == 1/2 -> 0.500000
16/64 == 1/4 -> 0.250000
16/96 == 1/6 -> 0.166667
17/85 == 1/5 -> 0.200000
19/95 == 1/5 -> 0.200000
22/33 == 2/3 -> 0.666667
22/44 == 2/4 -> 0.500000
22/55 == 2/5 -> 0.400000
22/66 == 2/6 -> 0.333333
22/77 == 2/7 -> 0.285714
22/88 == 2/8 -> 0.250000
22/99 == 2/9 -> 0.222222
26/65 == 2/5 -> 0.400000
27/54 == 2/4 -> 0.500000
33/44 == 3/4 -> 0.750000
33/55 == 3/5 -> 0.600000
33/66 == 3/6 -> 0.500000
33/77 == 3/7 -> 0.428571
33/88 == 3/8 -> 0.375000
33/99 == 3/9 -> 0.333333
38/76 == 3/6 -> 0.500000
39/65 == 3/5 -> 0.600000
44/55 == 4/5 -> 0.800000
44/66 == 4/6 -> 0.666667
44/77 == 4/7 -> 0.571429
44/88 == 4/8 -> 0.500000
44/99 == 4/9 -> 0.444444
49/98 == 4/8 -> 0.500000
55/66 == 5/6 -> 0.833333
55/77 == 5/7 -> 0.714286
55/88 == 5/8 -> 0.625000
55/99 == 5/9 -> 0.555556
66/77 == 6/7 -> 0.857143
66/88 == 6/8 -> 0.750000
66/99 == 6/9 -> 0.666667
77/88 == 7/8 -> 0.875000
77/99 == 7/9 -> 0.777778
88/99 == 8/9 -> 0.888889
Numbers found: 48
		 * 
		 */
	}
	
	public static void main(String[] args) {
		
		execute48();
		
		// execute416();

		
		// EX 4.10 - Divide and reverse number. LATER
			
					
	} 
}

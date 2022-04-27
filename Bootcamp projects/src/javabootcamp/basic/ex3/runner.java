package javabootcamp.basic.ex3;
import java.util.Scanner;

public class runner {

	public static void main(String[] args) {
		
		// EX 3.3 - Wedding cheque planner
		/*
		final int BASEFRIENDS = 500;
		final int BASEFAMILY = 1000;
		final int BASEDEFAULT = 250;
		final int ADDITIONTHREEYEARS = 50;
		final int ADDITIONOVERHOURDRIVE = -50;
		
		boolean isFamily = false;
		boolean isOverThreeYears = false;
		boolean isOverHourDrive = false;
		
		int sumToBring = 0;
		int input = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How close are you? - [1]Normal [2]Friends [3]Family");
		input = scanner.nextInt();
		
		switch (input) {
		case 1:
			sumToBring = BASEDEFAULT;
			break;
			
		case 2:
			sumToBring = BASEFRIENDS;
			break;
			
		case 3:
			sumToBring = BASEFAMILY;
			isFamily = true;
			break;
		
		default:
			break;
			
		} // end switch
		
		System.out.println("How many years have you known eachother?");
		input = scanner.nextInt();
		
		if (input > 3) {
			isOverThreeYears = true;
			if (!isFamily) {
				sumToBring += ADDITIONTHREEYEARS;
			}
		}
		
		System.out.println("How many minutes drive to the wedding?");
		input = scanner.nextInt();
		if (input > 60)
		{
			isOverHourDrive = true;
			if (!isFamily){
				sumToBring += ADDITIONOVERHOURDRIVE;
			}
		}
		
		System.out.println("You need to bring: " + sumToBring);
		
		scanner.close();
		*/
	
		//--------------------------------------------------------------------------------
		
		
		// EX 3.7 - grade calculator
		Scanner scanner = new Scanner(System.in);
		
		int testScore = 0;
		int avgScore = 0;
		int assignments = 0;
		double finalGrade = 0;
		
		System.out.println("Enter test score (0-100): ");
		testScore = scanner.nextInt();
		
		System.out.println("Enter average assignments score (0-100): ");
		avgScore = scanner.nextInt();
		
		System.out.println("Enter number of assignments handed in (0-8): ");
		assignments = scanner.nextInt();
		
		// less than 4 assignemnts
		if (assignments <= 4)
		{
			finalGrade = 0;
		}
		
		// 5 or 6 assignments
		else if ( assignments == 5 || assignments == 6)
		{
			if (testScore >= 55)
			{
				finalGrade = testScore*0.8 + avgScore*0.2;
			}
			// testscore <= 54
			else
			{
				finalGrade = testScore;
			}
		}
		
		// 7 or 8 assignments
		else if ( assignments == 7 || assignments == 8)
		{
			if (testScore >= 55)
			{
				finalGrade = testScore*0.7 + avgScore*0.3;
			}
			// testscore <= 54
			else
			{
				if (avgScore >= 80)
				{
					finalGrade = testScore*0.75 + avgScore*0.25;
				}
				// avgscore <= 79
				else
				{
					finalGrade = testScore*0.8 + avgScore*0.2;
				}
			}
		}
		
		System.out.println("Final grade is:" + finalGrade);
		
		scanner.close();
	}

}

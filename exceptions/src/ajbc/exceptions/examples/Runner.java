package ajbc.exceptions.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void readFile(String path) throws FileNotFoundException {
		FileReader file = new FileReader(path);
	}
	
	public static void mathException() {		
		int res = 0;
		int num = 0;
		boolean success = false;
		String str;
		
		do {
			System.out.println("enter num:");
			str = scanner.nextLine();
			try {
				num = (int)Double.parseDouble(str);
				res = 100 / num;
			}
			catch ( java.lang.NumberFormatException e) {
				System.out.println(e);
				System.out.println("must be an integer");
				continue;
			}
			catch (java.lang.ArithmeticException e){
				System.out.println(e);
				System.out.println("can't divide by 0");
				continue;
			}
		
			success = true;
		}while (!success);
		
		System.out.println(res);
	}
	
	public static void mathException2() {		
		int res = 0;
		int num = 0;
		boolean success = false;
		
		do {
			System.out.println("enter num:");
			try {
				num = scanner.nextInt();
				res = num / num;
			}
			catch ( java.util.InputMismatchException e) {
				System.out.println(e);
				System.out.println("must be an integer");
				continue;
			}
			catch (java.lang.ArithmeticException e){
				System.out.println(e);
				System.out.println("can't divide by 0");
				continue;
			}finally {
				scanner.nextLine();
			}
		
			success = true;
		}while (!success);
		
		System.out.println("done");
	}
	
	public static void main(String[] args) {
		/*
		String path = "myFile.txt";
		try {
			readFile(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		mathException();
		//mathException2();
		scanner.close();
	}

}

package Input;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Input {
	public static Scanner scanner = new Scanner(System.in);
	private static Random random = new Random();
	
	public static int getInt(String msg) {
		System.out.print(msg);
		return getInt();
	}
	
	public static int getInt() {
		int num = 0;
		boolean success = false;
		final String ERROR_NOT_NUMBER = "Not an integer, try again";
		
		while (!success) {
			
			try {
				num = Integer.parseInt(scanner.next());
			}
			catch (NumberFormatException nfe) {
				System.out.println(ERROR_NOT_NUMBER);
				continue;
			}
			catch (Exception e) {
				System.out.println(e);
				continue;
			}
			
			success = true;
		}
		
		return num;
	}
	
	public static void pressEnter() {
		System.out.println("Press enter");
		scanner.nextLine();
	}
	
	public static int getRandomInt(int min, int max) {
		return random.nextInt(min, max+1);
	}
	
	
	public static void wait(int miliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(miliseconds);
		}catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
}

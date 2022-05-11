package Factory;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Theme theme = null;
		int input = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. bright theme. 2. dark theme");
		
		input = Integer.parseInt(scanner.nextLine());
		
		if (input == 1) {
			theme = new BrightTheme();
		}else {
			theme = new DarkTheme();
		}
		
		theme.render();
		
		scanner.close();
	}

}

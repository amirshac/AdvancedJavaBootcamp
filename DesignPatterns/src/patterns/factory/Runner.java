package patterns.factory;

import java.util.Scanner;

public class Runner {

	private static ThemeFactory themeFactory;
	
	public static void main(String[] args) {
		
		int input = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. bright theme. 2. dark theme");
		
		input = Integer.parseInt(scanner.nextLine());
		
		if (input == 1) {
			themeFactory = new BrightThemeFactory();
		}else {
			themeFactory = new DarkThemeFactory();
		}
		
		Theme theme = themeFactory.createTheme();
		theme.render();
		
		scanner.close();
	}

}

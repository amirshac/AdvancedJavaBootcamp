package Utils;

import java.util.Random;

public class StringGenerator {
	
	private static Random random = new Random();
	
	private static String[] firstNames = {
			"Amrita", "Bonnie", "Mathilde", "Donnie", "Davey",
			"Lya", "Jia", "Sam", "Allen", "Elsa", "Dory"
	};
	
	private static String[] lastNames = {
			"Houdini", "Griffin", "Shepard", "Sanchez", "Hilton",
			"Norman", "Frye", "Kim", "Kirk", "Morris"
	};
	
	private static String[] countryNames = {
			"Albania", "Belarus", "Canada", "Denmark", "Greece",
			"Germany", "Israel", "Italy", "Libya", "Nepal",
			"United States"
	};
	
	public static String firstName() {
		int index = random.nextInt(0, firstNames.length);
		return new String(firstNames[index]);
	}
	
	public static String lastName() {
		int index = random.nextInt(0, lastNames.length);
		return new String(lastNames[index]);
	}
	
	public static String fullName() {
		return new String(firstName() + " " + lastName());
	}
	
	public static String country() {
		int index = random.nextInt(0, countryNames.length);
		return new String(countryNames[index]);
	}
}

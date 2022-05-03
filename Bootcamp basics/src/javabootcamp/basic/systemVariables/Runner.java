package javabootcamp.basic.systemVariables;

import java.time.LocalDate;
import java.time.LocalTime;

public class Runner {
	public static void main(String[] args) {
		
		System.out.println("Day of the week: " + LocalDate.now().getDayOfWeek() );
		System.out.println("Time: " + LocalTime.now());
				
		System.setProperty("user.email", "shachar.amir@gmail.com");
		System.setProperty("user.phone", "0525403091");
		
		System.out.println("Username: " + System.getProperty("user.name") );
		System.out.println("OS type: " + System.getProperty("os.name") );
		System.out.println("OS arch: " + System.getProperty("os.arch") );
		System.out.println("Phone number: " + System.getProperty("user.phone") );
		System.out.println("Email: " + System.getProperty("user.email") );
	}
}

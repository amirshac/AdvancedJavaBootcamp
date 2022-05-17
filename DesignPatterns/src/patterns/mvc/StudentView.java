package patterns.mvc;

import java.util.List;
import java.util.Scanner;

public class StudentView {
	
	private final static double EXCELLENT_AVERAGE = 90;
	private final static int NUM_GRADES_TO_GET = 3;
	
	String id, firstName, lastName;
	List<Double> grades;
	double grade;
	double average;
	Student student;
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Student - Enter information:");
		System.out.println("ID: ");
		id = scanner.nextLine();

		System.out.println("FirstName: ");
		firstName = scanner.nextLine();
		
		System.out.println("LastName: ");
		lastName = scanner.nextLine();
		
		student = new Student(id, firstName, lastName);
		
		for (int i=1; i<=NUM_GRADES_TO_GET; i++) {
			System.out.println("Grade " + i +":");
			grade = Double.parseDouble(scanner.nextLine());
			student.grades.add(grade);
		}
		
		scanner.close();
	}
	
	public void displayStudentStatus() {
		String msg = null;
		System.out.println("Average " + average);
		msg = (average >= EXCELLENT_AVERAGE) ? "Excellent student" : "Great student";
		System.out.println(msg);
	}
}

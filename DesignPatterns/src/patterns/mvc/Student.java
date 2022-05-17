package patterns.mvc;

import java.util.ArrayList;
import java.util.List;

public class Student {
	String id;
	String firstName;
	String lastName;
	List<Double> grades;
	
	public Student(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		grades = new ArrayList<Double>();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", grades=" + grades + "]";
	}
	
	public List<Double> getGrades(){
		return grades;
	}
	
}

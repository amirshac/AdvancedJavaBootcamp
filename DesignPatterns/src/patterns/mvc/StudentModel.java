package patterns.mvc;

import java.util.List;

public class StudentModel {
	double average;
	
	public double calculateAverage(List<Double> numbers) {
		//numbers.forEach(number -> average+=number);
		//average/=numbers.size();
		
		average = numbers.stream().reduce(0.0, (a,b)->a+b)/numbers.size();
		return average;
	}
}

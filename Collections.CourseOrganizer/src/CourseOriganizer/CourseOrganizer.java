package CourseOriganizer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class CourseOrganizer {
	
	protected HashMap<String, Course> courseMap;
	protected HashMap<String, Float> deviationMap;
	
	protected float average;
	protected float standardDeviation;
	
	public CourseOrganizer() {
		courseMap = new HashMap<String, Course>();
		deviationMap = new HashMap<String, Float>();
		populateCourseMap();
	}
	
	protected void populateCourseMap() {
		Course[] courses = {
				new Course("Algorithms", 1, "Computer Science", 90),
				new Course("Linear Aljebra", 2, "Computer Science", 100),
				new Course("Electronics", 3, "Computer Science", 80),
				new Course("Cell logic", 23, "Biology School", 90),
				new Course("Blood", 28, "Biology School", 90)
		};
		
		for (Course course : courses) {
			courseMap.put(course.name, course);
		}
	}
	
	protected void printCourses() {
		System.out.println(courseMap);
	}
	
	protected float calculateAverageScore() {
		float average = 0;
		
		for (Course course : courseMap.values()) {
			average += course.grade;
		}
		
		average /= (float)courseMap.size();
		
		this.average = average;
		
		return average;
	}
	
	protected float getAverageScore() {
		return (calculateAverageScore());
	}
	
	protected float calculateStandardDeviation() {
		float result = 0;
		float deviation = 0;
		
		calculateAverageScore();
		
		deviationMap.clear();
		
		for (Course course : courseMap.values()) {
			deviationMap.put(course.name, (float)course.grade - this.average);
		}
		
		return result;
	}
}

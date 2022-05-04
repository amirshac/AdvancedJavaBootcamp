package CourseOriganizer;

public class Course {
	protected String name;
	protected int number;
	protected String schoolName;
	protected int grade;
	
	public Course(String name, int number, String schoolName, int grade) {
		super();
		this.name = name;
		this.number = number;
		this.schoolName = schoolName;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", number=" + number + ", schoolName=" + schoolName + ", grade=" + grade + "]";
	}
	
	
}

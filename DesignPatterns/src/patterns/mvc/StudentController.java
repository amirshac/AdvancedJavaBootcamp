package patterns.mvc;

public class StudentController {
	private StudentModel model;
	private StudentView view;
	
	public StudentController(StudentModel model, StudentView view) {
		this.model = model;
		this.view = view;
	}
	
	public void start() {
		view.getInput();
		
		model.calculateAverage(view.student.grades);
		
		view.average = model.average;	
		view.displayStudentStatus();
	}
	
}

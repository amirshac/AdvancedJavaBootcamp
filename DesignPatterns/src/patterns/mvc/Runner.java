package patterns.mvc;

public class Runner {

	public static void main(String[] args) {
		StudentModel model = new StudentModel();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(model, view);
		
		controller.start();
	}

}

package Exceptions;

public class OutOfTargetsException extends RuntimeException{

	private static final long serialVersionUID = 7793096441846629998L;
	
	public OutOfTargetsException() {
		super();
	}
	
	public OutOfTargetsException(String msg) {
		super(msg);
	}

}

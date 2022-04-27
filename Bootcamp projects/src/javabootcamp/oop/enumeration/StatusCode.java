package javabootcamp.oop.enumeration;


public class StatusCode {
	private String msg;
	private final Status status;
	
	public StatusCode(String msg, Status status) {
		this.msg = msg;
		this.status = status;
	}
	
	public static enum Status{
		MISSING_INFO(100),
		ILLEGAL_NAME(101),
		OK(400),
		FAIL(500);
		
		int code;
		
		Status(int code){
			this.code = code;
		}
	}

}

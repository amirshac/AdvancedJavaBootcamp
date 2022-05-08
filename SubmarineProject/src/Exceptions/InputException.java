package Exceptions;

public class InputException extends RuntimeException {

	private static final long serialVersionUID = 3505936405181991142L;
	
	private final ErrorCode code;
	
	public InputException(ErrorCode code) {
		super();
		this.code = code;
	}

	public InputException(String msg) {
		super(msg);
		this.code = ErrorCode.GENERAL_INPUT_ERROR;
	}
	
	public static enum ErrorCode{
		GENERAL_INPUT_ERROR(100),
		OUT_OF_BOARD(101),
		NOT_A_NUMBER(102),
		USER_WANTS_TO_QUIT(103);
		
		private int errorCode;
		
		private ErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}
		
		public int getErrorCode() {
			return errorCode;
		}
	}
}


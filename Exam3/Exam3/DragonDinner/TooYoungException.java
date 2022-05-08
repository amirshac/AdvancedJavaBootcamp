package DragonDinner;

public class TooYoungException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1396929929703190688L;
	private static final String ERRORMSG = "Exception: Dragon must be older than 8/8/888";
	
	public TooYoungException() {
		super(ERRORMSG);
	}
}

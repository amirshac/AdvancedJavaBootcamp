package DragonDinner;

public class NonCapitalizedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2052881095827990208L;
	private static final String ERRORMSG = "Exception: Food name must be capitalized";

	public NonCapitalizedException() {
		super(ERRORMSG);
	}
}

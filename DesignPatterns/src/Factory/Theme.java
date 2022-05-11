package Factory;

public abstract class Theme {
	
	Text text;
	Background background;
	
	public Theme() {
		
	}
	
	public enum Text{
		WHITE, BLACK
	}
	
	public enum Background{
		BRIGHT, DARK
	}

	@Override
	public String toString() {
		return "Theme [text=" + text + ", background=" + background + "]";
	}
	
}

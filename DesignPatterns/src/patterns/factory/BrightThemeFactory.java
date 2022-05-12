package patterns.factory;

public class BrightThemeFactory implements ThemeFactory{

	@Override
	public Theme createTheme() {
		return new BrightTheme();
	}

}

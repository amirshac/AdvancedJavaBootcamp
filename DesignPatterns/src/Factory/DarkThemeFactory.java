package Factory;

public class DarkThemeFactory implements ThemeFactory{

	@Override
	public Theme createTheme() {
		return new DarkTheme();
	}

}

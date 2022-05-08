package DragonDinner;

import java.io.Serializable;

public class Food implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1974888952607638963L;
	
	protected String name;
	protected Taste taste;
	protected Macro macro;
	
	public Food(String name, Taste taste, Macro macro) {
		this.name = name;
		this.taste = taste;
		this.macro = macro;
	}
	
	public enum Taste{
		SWEET,
		SOUR,
		SALTY,
		BITTER,
		UMAMI
	};
	
	public enum Macro{
		PROTEIN,
		CARB,
		FAT
	};

	@Override
	public String toString() {
		return "Food [name=" + name + ", taste=" + taste + ", macro=" + macro + "]";
	};
	
}

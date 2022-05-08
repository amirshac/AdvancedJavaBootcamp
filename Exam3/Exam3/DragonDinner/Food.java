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
		try {
			setName(name);
		} catch (NonCapitalizedException e) {
			System.out.println(e);
		}
		this.taste = taste;
		this.macro = macro;
	}
	
	public boolean isDesert() {
		return (this.taste == Taste.SWEET && this.macro == Macro.CARB );
	}
	
	public void setName(String name) throws NonCapitalizedException {
		if (name == null)
			throw new NonCapitalizedException();
		
		Character firstLetter = name.charAt(0);
		if (!Character.isUpperCase(firstLetter))
			throw new NonCapitalizedException();
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

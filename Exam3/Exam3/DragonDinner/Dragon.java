package DragonDinner;

import java.io.Serializable;
import java.time.LocalDate;

public class Dragon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7411252254917150802L;
	
	String name;
	LocalDate birthDate;
	int flameIntensity;
	
	public Dragon(String name, LocalDate birthDate, int flameIntensity) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.flameIntensity = flameIntensity;
	}

	@Override
	public String toString() {
		return "Dragon [name=" + name + ", birthDate=" + birthDate + ", flameIntensity=" + flameIntensity + "]";
	}
	
}

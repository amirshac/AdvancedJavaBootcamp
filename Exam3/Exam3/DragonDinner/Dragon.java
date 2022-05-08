package DragonDinner;

import java.io.Serializable;
import java.time.LocalDate;

public class Dragon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7411252254917150802L;
	private static final LocalDate TOOYOUNG_DATE = LocalDate.of(888, 8, 8);
	
	String name;
	LocalDate birthDate;
	int flameIntensity;
	
	public Dragon(String name, LocalDate birthDate, int flameIntensity) {
		super();
		this.name = name;
		
		try {
			setBirthDate(birthDate);
		}catch (TooYoungException e) {
			System.out.println(e);
		}
		
		this.flameIntensity = flameIntensity;
	}

	@Override
	public String toString() {
		return "Dragon [name=" + name + ", birthDate=" + birthDate + ", flameIntensity=" + flameIntensity + "]";
	}
	
	public void setBirthDate(LocalDate date) throws TooYoungException{
		if (date.isBefore(TOOYOUNG_DATE))
			throw new TooYoungException();
		
		this.birthDate = date;
	}
	
}

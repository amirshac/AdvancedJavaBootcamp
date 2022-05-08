package DragonDinner;

import java.io.Serializable;
import java.time.LocalDate;

public class Dragon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7411252254917150802L;
	private static final LocalDate TOOYOUNG_DATE = LocalDate.of(888, 8, 8);
	private static final int FLAME_MIN = 0;
	private static final int FLAME_MAX = 10;
	
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
		
		setFlameIntensity(flameIntensity);
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
	
	public void setFlameIntensity(int num) {
		if (num < FLAME_MIN) num = FLAME_MIN;
		else if (num > FLAME_MAX) num = FLAME_MAX;
		
		this.flameIntensity = num;
	}
	
}

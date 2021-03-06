package javabootcamp.oopexam.Toy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javabootcamp.oopexam.Kid.Kid;
import javabootcamp.oopexam.Playable.*;

public class Toy implements Playable{
	private static int IDPool;
	private int ID;
	private String name;
	private LocalDate purchaseDate;
	private boolean isBroken;
	protected AgeGroup ageGroup;
	private int toyAgeMonths;
	private Kid kid;
	private boolean isPlayable;
	
	static {
		IDPool = 0;
	}
	
	// constructors
	
	public Toy(String name, LocalDate purchaseDate, AgeGroup ageGroup, Kid kid) {
		ID = ++IDPool;
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.ageGroup = ageGroup;
		this.kid = kid;
		isBroken = false;
		toyAgeMonths = 0;
		isPlayable = true;
		setToyAgeAccordingToToday();
		setStatsToyLogic();		
	}
	
	public Toy(String name, LocalDate purchaseDate, AgeGroup ageGroup) {
		this(name, purchaseDate, ageGroup, null);
	}
	
	public Toy(String name, LocalDate purchaseDate) {
		this(name, purchaseDate, AgeGroup.ABC);
	}
	
	public Toy(String name) {
		this(name, LocalDate.now());
	}
	
	public Toy() {
		this("GenericToy");
	}
	
	/**
	 * Checks todays date and set toy age accordingly
	 * @param date
	 */
	private void setToyAgeAccordingToDate(LocalDate date) {
		int monthsDifference = (int)ChronoUnit.MONTHS.between(this.purchaseDate, date);
		this.setToyAge(monthsDifference);
	}
	
	private void setToyAgeAccordingToToday() {
		setToyAgeAccordingToDate(LocalDate.now());
	}
	
	
	private void setIsBrokenAccordingToAge() {
		if (this.toyAgeMonths > 12) {
			this.isBroken = true;
		}
	}
	
	private void setStatsToyLogic() {
		setIsBrokenAccordingToAge();
	}
	
	@Override
	public String toString() {
		return "<Toy> [ID=" + ID + ", name=" + name + ", purchaseDate=" + purchaseDate + ", isBroken=" + isBroken
				+ ", ageGroup=" + ageGroup + ", toyAgeMonths=" + toyAgeMonths + "]";
	}

	@Override
	public boolean isPlayable() {
		return this.isPlayable;
	}
	
	@Override
	public void Play() {
		if (toyAgeMonths > 12) {
			System.out.println(this);
			System.out.println("Can't play, toy broken since its older than a year");
			this.isPlayable = false;
			return;
		}
		
		if (!IsAgeWithinAgeGroup()) {
			System.out.println(this.getKid());
			System.out.println("Can't play, kid is not in the proper age group " + this.getAgeGroup());
			this.isPlayable = false;
			return;			
		}
		
		if (isBroken) {
			System.out.println(this);
			System.out.println("Can't play, toy is broken");
			this.isPlayable = false;
			return;
		}
		
		System.out.println(getKid() + " is playing with " + this);
		this.isPlayable = true;
	}
	
	public boolean IsAgeWithinAgeGroup() {
		return IsAgeWithinAgeGroup(this.kid.getAge());
	}
	
	public boolean IsAgeWithinAgeGroup(int age) {
		int minAge = 0;
		int maxAge = 0;
		boolean result = false;
		
		switch (ageGroup) {
		case A:
			minAge = 0;
			maxAge = 1;
			break;
			
		case B:
			minAge = 2;
			maxAge = 4;
			break;
		
		case C:
			minAge = 5;
			maxAge = 10;
			break;
			
		case AB:
			minAge = 0;
			maxAge = 4;
			break;
		
		case BC:
			minAge = 2;
			maxAge = 10;
			break;
		
		case ABC:
			minAge = 0;
			maxAge = 10;
			break;
			
		} // end switch
		
	if (age >= minAge && age <= maxAge)
		result = true;
	
	return result;
}
	

	// setters / getters
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public boolean isBroken() {
		return isBroken;
	}

	public void setBroken(boolean isBroken) {
		this.isBroken = isBroken;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getToyAge() {
		return toyAgeMonths;
	}

	public void setToyAge(int toyAgeMonths) {
		if (toyAgeMonths < 0)
			toyAgeMonths = 0;
		
		this.toyAgeMonths = toyAgeMonths;
	}

	public Kid getKid() {
		return kid;
	}

	public void setKid(Kid kid) {
		this.kid = kid;
	}
	
}
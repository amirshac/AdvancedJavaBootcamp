package javabootcamp.oopexam.DollToy;

import java.time.LocalDate;

import javabootcamp.oopexam.Toy.*;

public class DollToy extends Toy {
	private Softness softness;
	private int dirtyness;
	
	
	public DollToy(String name, LocalDate purchaseDate) {
		super(name, purchaseDate);
		setDirtyness(0);
		setSoftness(Softness.SOFT);
		setAgeGroup(AgeGroup.AB);
	}
	
	public DollToy(String name) {
		this(name, LocalDate.now());
	}
	
	@Override
	public void Play() {
		super.Play();
		if (isPlayable()) {
			setDirtyness(this.dirtyness+1);
			System.out.println("<DollToy> Dirtyness increased to " + getDirtyness());	
		}
	}

	// setters getters
	public Softness getSoftness() {
		return softness;
	}

	public void setSoftness(Softness softness) {		
		this.softness = softness;
	}

	public int getDirtyness() {
		return dirtyness;
	}

	public void setDirtyness(int dirtyness) {
		if (dirtyness < 0)
			dirtyness = 0;
		else if (dirtyness > 10)
			dirtyness = 10;
		
		this.dirtyness = dirtyness;
	}

	@Override
	public String toString() {
		String msg = super.toString();
		msg += " <DollToy> [softness=" + softness + ", dirtyness=" + dirtyness + "]";
		return msg;
	}	
}

enum Softness{
	SOFT,
	HARD
};
package javabootcamp.oopexam.ElectricToy;

import java.time.LocalDate;

import javabootcamp.oopexam.Toy.*;

public class ElectricToy extends Toy{
	private int batteries;
	private int soundLevel;
	
	public ElectricToy(String name, LocalDate purchaseDate) {
		super(name, purchaseDate);
		setBatteries(2);
		setSoundLevel(3);
	}
	
	public ElectricToy(String name) {
		this(name, LocalDate.now());
	}
	
	@Override
	public void Play() {
		super.Play();
		if (isPlayable())
		{
			setSoundLevel(this.soundLevel-1);
			System.out.println("<ElectricToy> decreased sound level to " + getSoundLevel());
		}
	}
	
	@Override
	public String toString() {
		String msg = super.toString();
		msg += " <ElectricToy> [batteries=" + batteries + ", soundLevel=" + soundLevel + "]";
		return msg;
	}
	
	// setters getters
	public int getBatteries() {
		return batteries;
	}
	public void setBatteries(int batteries) {
		this.batteries = batteries;
	}
	public int getSoundLevel() {
		return soundLevel;
	}
	
	public void setSoundLevel(int soundLevel) {
		if (soundLevel < 0)
			soundLevel = 0;
		else if (soundLevel > 3)
			soundLevel = 3;
		
		this.soundLevel = soundLevel;
	}
	
	
	
}

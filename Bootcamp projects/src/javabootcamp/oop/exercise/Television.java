package javabootcamp.oop.exercise;

import java.util.Calendar;
import javabootcamp.oop.abstraction.*;

public class Television extends HomeAppliance implements Flatable, Smartable {
	
	protected float size;
	protected String model;
	protected RemoteControl remoteControl;

	//constructors
	public Television(String man, int purchaseYear, float size, int powerConsumption, String transmitMethod){
		super(man, purchaseYear, powerConsumption);
		setSize(size);
		setModel("A12");
		remoteControl = new RemoteControl(transmitMethod);
	}
	
	public Television (float size){
		this("Generic", (Calendar.getInstance()).get(Calendar.YEAR), size, 100, "IR");
	}
	
	public Television() {
		this(40);
	}
	
	public float getSize() {
		return size;
	}
	
	public void setSize(float size) {
		if (size<2.5f || size>120f)
			size = 10f;
			
		this.size = size;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		
		if (model.length()<3) {
			System.out.println("Exception in setModel");
			return ;
		}

		char ch = model.charAt(0);
		
		if (!Character.isLetter(ch))
			model = "A"+model;
		
		char ch1 = model.charAt(1);
		char ch2 = model.charAt(2);
		
		if (!Character.isDigit(ch1) || !Character.isDigit(ch2)) {
			model = ch + "00";
		}
		
		this.model = model;
	}
	
	public String getRemoteControlTransmitMethod() {
		String result = remoteControl.getTransmitMethod();
		return result;
	}

	public void setRemoteControlTransmitMethod(String transmitMethod) {
		remoteControl.setTransmitMethod(transmitMethod);
	}

	@Override
	public String toString() {
		String msg;
		msg = super.toString();
		msg += "\n";
		msg += "TV Size: "+size+", model: "+ model;
		msg += "\n"; 
		if (isSmart()) msg+="Is smart ";
		if (isFlat()) msg+="Is flat";
		
		return msg;
	}
	
	public float sizeInCM() {
		return size*2.54f;
	}

	public int isBigger(Television other) {
		float diff = this.size - other.size;
		
		if (diff > 0)
			return 1;
		else if (diff<0)
			return -1;
		else
			return 0;
	}
	
	@Override
	public int getConsumption (int hoursWorked) {
		int result = hoursWorked * powerConsumption;
		return result;
	}
	
	@Override
	public boolean isSmart() {
		if (purchaseYear > 2015)
			return true;
		return false;
	}
	
	@Override
	public boolean isFlat() {
		if (purchaseYear > 2020)
			return true;
		return false;
		
	}
	
	
	
}

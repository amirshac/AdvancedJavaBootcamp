package javabootcamp.oop.exercise;

public class RemoteControl {
	
	// fields
	protected String transmitMethod;
	
	// constructors
	public RemoteControl(String transmitMethod) {
		setTransmitMethod(transmitMethod);
	}
	
	public RemoteControl(){
		this("IR");
	}

	// setters getters
	public String getTransmitMethod() {
		return transmitMethod;
	}

	public void setTransmitMethod(String transmitMethod) {
		
		switch (transmitMethod) {
		case "IR":
			break;
		case "RF":
			break;
		default:
			transmitMethod = "IR";
			break;
		}
		
		this.transmitMethod = transmitMethod;
	}


}

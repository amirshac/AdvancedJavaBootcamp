package javabootcamp.oop.lights;

public class Light {
	// fields
	private int numOfBulbs;
	private boolean isOn;
	
	// constructors
	public Light() {		
		this(3, true);
	}

	public Light(int numOfBulbs, boolean isOn) {
		this.setNumOfBulbs(numOfBulbs);
		this.setIsOn(isOn);
	}
	
	// setters / getters
	public int getNumOfBulbs() {
		return this.numOfBulbs;
	}
	
	public void setNumOfBulbs(int numOfBulbs) {
		if (numOfBulbs >= 0) {
			this.numOfBulbs = numOfBulbs;
		}
		else{
			System.out.println("Invalid num of bulbs");
		}
	}
	
	public boolean getIsOn() {
		return this.isOn;
	}
	
	public void setIsOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	// methods
	void turnOn() {
		this.setIsOn(true);
		System.out.println(this + " On");
	}
	
	void turnOff() {
		this.setIsOn(false);
		System.out.println(this + " Off");
	}

	void toggle(Light light) {
		boolean currentState = light.getIsOn();
		light.setIsOn(!currentState);
	}
	
	void toggle() {
		this.toggle(this);
	}
	
	void printLightStatus(Light light) {
		System.out.println(light + " isOn: " +light.getIsOn() + ". Bulbs: " + light.getNumOfBulbs() );
	}
	
	void printLightStatus(){
		this.printLightStatus(this);	
	}
	
}

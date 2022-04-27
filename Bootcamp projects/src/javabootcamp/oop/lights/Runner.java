package javabootcamp.oop.lights;

public class Runner {
	
	public static void main(String[] args) {
		Light light1 = new Light();
		Light light2 = new Light(7, false);

		light1.printLightStatus();
		light2.printLightStatus();

		System.out.println();
		System.out.println("Changing variables:");
		light1.setIsOn(false);
		light2.setNumOfBulbs(10);
		
		light1.printLightStatus();
		light2.printLightStatus();
		
		System.out.println();
		System.out.println("Turning on:");
		light1.turnOn();
		light2.turnOn();
		
		System.out.println();
		System.out.println("Turning off:");
		light1.turnOff();
		light2.turnOff();
		
		System.out.println();
		System.out.println("Toggling:");
		light1.toggle(light2);
		light1.toggle();
		
		light1.printLightStatus();
		light2.printLightStatus();
	}

}

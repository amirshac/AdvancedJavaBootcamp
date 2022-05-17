package xml.cars;

public class Car {
	String manufacturer;
	String model;
	int year;
	Plate plate;
	
	public Car(String manufacturer, String model, int year, Plate plate) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.plate = plate;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", model=" + model + ", year=" + year + ", plate=" + plate + "]";
	}
	
}

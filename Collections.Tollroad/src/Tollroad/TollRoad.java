package Tollroad;

import java.util.LinkedList;
import java.util.ListIterator;

public class TollRoad {
	protected LinkedList<CheckPoint> checkPointList;
	protected LinkedList<Car> carList;
	
	protected ListIterator<CheckPoint> itCheckPoint;
	protected ListIterator<Car> itCar;
	
	protected int checkPointLength;

	public TollRoad() {
		checkPointList = new LinkedList<CheckPoint>();
		carList = new LinkedList<Car>();
		
		itCheckPoint = checkPointList.listIterator();
		itCar = carList.listIterator();
		
		populateCheckPoints();
		populateCars();
	}
	
	public void populateCheckPoints() {
		addCheckPoint(new CheckPoint("Farsa First", "Tel Aviv"));
		addCheckPoint(new CheckPoint("Sami Second", "Rishon"));
		addCheckPoint(new CheckPoint("Talya Third", "Lod"));
		addCheckPoint(new CheckPoint("Fortis Fourth", "Ramla"));
		addCheckPoint(new CheckPoint("Fabby Fifth", "Jerusalem"));
	}
	
	public void populateCars() {
		carList.add(new Car("11111", this));
		carList.add(new Car("22222", this));
		carList.add(new Car("33333", this));
		carList.add(new Car("44444", this));
		carList.add(new Car("55555", this));
	}
	
	/*
	 * Adds checkpoint to the end of the list
	 */
	public void addCheckPoint(CheckPoint checkPoint) {
		checkPointList.add(checkPoint);
		checkPoint.setPosition(checkPointList.size());
	}
	
	public void printCheckPoints() {
		System.out.println(checkPointList);
	}
	
	public void printCars() {
		System.out.println(carList);
	}
	
	// TODO: implement remove checkpoint 
	public void removeCheckPoint(int index) {
		
	}
	
	/**
	 * Goes through every car and runs a cycle
	 */
	public void run() {
		for (Car car : carList) {
			car.travelBackOrForth();
			car.visitCheckPoint();
		}
	}
	
}

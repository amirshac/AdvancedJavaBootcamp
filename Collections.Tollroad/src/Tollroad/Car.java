package Tollroad;

import java.util.ListIterator;
import java.util.Random;

public class Car {
	protected String plateNumber;
	protected TollRoad currentRoad;
	protected ListIterator<CheckPoint> iterator;
	protected CheckPoint currentCheckPoint;
	
	public Car(String plateNumber, TollRoad road) {
		this.plateNumber = plateNumber;
		this.currentRoad = road;
		this.iterator = road.checkPointList.listIterator();
		this.currentCheckPoint = road.checkPointList.getFirst();
	}
	
	public void visitCheckPoint() {
		System.out.println(this + "visiting " + currentCheckPoint);
	}

	public void travelNextCheckPoint() {
		if (iterator.hasNext() ) {
			System.out.println(this + "traveling to next checkpoint");
			currentCheckPoint = iterator.next();	
		}
		else 
			System.out.println(this + " reached last checkpoint, can't travel further");
	}
	
	public void travelPreviousCheckPoint() {
		if (iterator.hasPrevious()) {
			System.out.println(this + "traveling to previous checkpoint");
			currentCheckPoint = iterator.previous();
		}
		else
			System.out.println(this + " already at first checkpoint, can't travel back");
	}
	
	public void travelBackOrForth() {
		int direction;
		int min=1, max=2;
		
		if (!iterator.hasNext())
			min = 2;
		if (!iterator.hasPrevious())
			max = 1;
			
		Random random = new Random();
		direction = random.nextInt(min, max+1);
		
		if (direction == 1) {
				travelNextCheckPoint();
		} else if (direction == 2) {
				travelPreviousCheckPoint();
		}
		
	}
	
	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + "]";
	}
	
}

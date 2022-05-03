package Tollroad;

import java.util.LinkedList;

public class TollRoad {
	protected LinkedList<CheckPoint> checkPointList;
	protected int checkPointLength;

	public TollRoad() {
		checkPointList = new LinkedList<CheckPoint>();
		checkPointLength = 0;
		
		populateCheckPoints();
	}
	
	public void populateCheckPoints() {
		addCheckPoint(new CheckPoint("Farsa First", "Tel Aviv"));
		addCheckPoint(new CheckPoint("Sami Second", "Rishon"));
		addCheckPoint(new CheckPoint("Talya Third", "Lod"));
		addCheckPoint(new CheckPoint("Fortis Fourth", "Ramla"));
		addCheckPoint(new CheckPoint("Fabby Fifth", "Jerusalem"));
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
	
	// TODO: implement remove checkpoint 
	public void removeCheckPoint(int index) {
		
	}
	
}

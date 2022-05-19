package Runner;

import exam5.json.HouseLoader;
import exam5.design.*;

public class Runner {
	
	// Exam 5 question 2 - loading json into class
	public static void loadHousesFromJson() {
		HouseLoader houseLoader = new HouseLoader();
		houseLoader.load();
		houseLoader.printHouses();
	}
	
	/**
	 * Exam 5 question 1 - Using the adapter design pattern we create a "bad helicopter" to "enemy" adapter, 
	 * inorder to get the "bad helicopter" class to work with 'good' enemy interface
	 */
	public static void showBadHelicopterAdapter() {	
		TestAdapter.go();
	}
	
	public static void main(String[] args) {
		// question 1
		showBadHelicopterAdapter();
		
		// question 2
		loadHousesFromJson();
	}
}


/* OUTPUT - Question 1
<Tank enemy:>
Tank turning left
Tank turning right
Tank driving forward
Tank driving backwards
Tank firing weapon pewpew
===================

<Bad Helicopter enemy:>
Helicopter yawing right
Helicopter yawing left
Helicopter flying up
Helicopter flying down
Helicopter flying missing *BOOM*
===================

<HelicopterToEnemyAdapter using enemy methods:>
<Adapter> Turning left
Helicopter yawing left

<Adapter> Turning right
Helicopter yawing right

<Adapter> Driving forward
Helicopter flying up

<Adapter> Driving backwards
Helicopter flying down

<Adapter> Firing weapon pewpew
Helicopter flying missing *BOOM*


OUTPUT - Question 2
House [address=Address [street=Atalantic BLVD, number=230, state=Alabama, city=Montgomery], rooms=[Room [width=12.5, length=10.2, hasAC=true], Room [width=5.5, length=10.7, hasAC=true]], hasYard=true, hasBasement=false, area=1200.9]
House [address=Address [street=Sunset BLVD, number=555, state=California, city=Los Angeles], rooms=[Room [width=9.9, length=10.9, hasAC=false], Room [width=18.5, length=11.2, hasAC=true], Room [width=8.7, length=13.1, hasAC=true]], hasYard=false, hasBasement=true, area=1801.8]

 */
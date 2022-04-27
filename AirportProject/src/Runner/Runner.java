package Runner;
import Airport.*;

public class Runner {

	public static void main(String[] args) {
		Flyer flyer = new Flyer("Moshe", "Ivgi");
		
		Flight flight = new Flight(101, 60);
		flight.setEstimatedDeparture(2022, 04, 14, 17, 30);
		
		flight.addFlyer(flyer);
		
		System.out.println(flight);
		flight.printFrequentFlyers();

		System.out.println("***********************************");
		
		Flyer flyer2 = new Flyer("Tom", "Cruise");
		Flight flight2 = new Flight(202, 90);
		Flight flight3 = new Flight(303, 390);

		System.out.println(flyer2);
		
		flyer.printMileageCredit();
		System.out.println();
		System.out.println("Adding flights to credit mileage...");
		flyer2.addFlightToMileageCredit(flight);
		flyer2.printMileageCredit();
		flyer2.addFlightToMileageCredit(flight2);
		flyer2.printMileageCredit();
		flyer2.addFlightToMileageCredit(flight3);
		flyer2.printMileageCredit();

	}
/*
Run:

Flight Number: 101
Flight Duration: 60 
Estimated Departure: 2022-04-14T17:30, Estimated Arrival: 2022-04-14T18:30
Mileage: 509.0
<Frequent Flyers>:
<Flyer> ID:0, Moshe Ivgi
***********************************
<Flyer> ID:1, Tom Cruise
<MileageCredit> Credit: 0.0, Miles: 0.0

Adding flights to credit mileage...
<MileageCredit> Credit: 256.8, Miles: 509.0
<MileageCredit> Credit: 725.9, Miles: 1301.1
<MileageCredit> Credit: 2872.2, Miles: 4329.6

*/
}

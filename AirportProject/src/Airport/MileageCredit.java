package Airport;

import java.util.Stack;

public class MileageCredit {
	
	private static final float DEF_CREDIT_PER_MILE = 0.5f;
	private static final float DEF_CREDIT_PER_BONUS_MILE = 0.75f;
	private static final float DEF_BONUS_MILE_SINCE = 500f; 
	
	private float totalCredit;
	private float totalMileage;
	
	private Stack<Flight> flightStack;
	private Flight latestFlight;
	private Flyer flyer;
	
	private float creditsPerMile = DEF_CREDIT_PER_MILE;
	private float creditsPerBonusMile = DEF_CREDIT_PER_BONUS_MILE;
	private float bonusMilesSince = DEF_BONUS_MILE_SINCE;
	
	
	// constructors	
	public MileageCredit() {
		flightStack = new Stack<Flight>();
		flyer = null;	
		totalCredit = 0;
		totalMileage = 0;
	}

	// setters getters
	public Flight getLatestFlight() {
		return flightStack.peek();
	}

	public Flyer getFlyer() {
		return flyer;
	}

	public void setFlyer(Flyer flyer) {
		this.flyer = flyer;
	}

	// [METHODS]
	/**
	 * Calculates how much customer credit needs to be given according to milleage
	 * @param float
	 * @return float 
	 */
	private float calculateCreditAccordingToMileage(float flightMileage) {
		float totalCreditToAdd = 0;
		float normalMileage = flightMileage;
		float bonusMileage = 0;
		
		if (flightMileage > bonusMilesSince) {
			normalMileage = bonusMilesSince;
			bonusMileage = flightMileage - bonusMilesSince;
		}
		
		totalCreditToAdd = creditsPerMile * normalMileage + creditsPerBonusMile * bonusMileage;
		return totalCreditToAdd;
	}
	
	/**
	 * Adds flight to flight stack, keeps latest flight in memory
	 * @param flight
	 */
	private void addFlight(Flight flight) {
		flightStack.push(flight);
		latestFlight = flight;	
	}
	
	/**
	 * Updates total mileage according to flight
	 * @param flight
	 * @return
	 */
	private void addMileage(Flight flight) {
		totalMileage += flight.getMileage();	
	}
	
	/**
	 * Updates credit according to flight mileage
	 * @param flight
	 */
	private void addCredit(Flight flight) {
		float creditToAdd = calculateCreditAccordingToMileage(flight.getMileage());
		totalCredit += creditToAdd;
	}
	
	/**
	 * Adds flight to stack and updates mileage and credit
	 * @param flight
	 */
	public void addFlightAndUpdateStats(Flight flight) {
		addFlight(flight);
		addMileage(flight);
		addCredit(flight);
	}
	
	@Override
	public String toString() {
		String str = new String();
		str += String.format("<MileageCredit> Credit: %.1f, Miles: %.1f", this.totalCredit, this.totalMileage);
		return str;
	}
}

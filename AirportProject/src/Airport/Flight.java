package Airport;
import java.time.LocalDateTime;
import java.util.Random;

public class Flight {

	private static int MAX_FLYERS_NUMBER = 200;
	// Fields
	private int flightNumber;
	private LocalDateTime estimatedDeparture;
	private LocalDateTime actualDeparture;
	private LocalDateTime estimatedArrival;
	private LocalDateTime actualArrival;

	private int flightDurationMinutes;

	private boolean isDeparted;
	private boolean isArrived;
	
	private Flyer[] flyerArray;
	private int numOfFlyers;
	
	private float mileage;
	
	// Constructors
	public Flight(int flightNumber, int flightDurationMinutes, LocalDateTime departure, LocalDateTime arrival) {
		this.flightNumber = flightNumber;
		this.estimatedDeparture = departure;
		this.estimatedArrival = arrival;
		this.flightDurationMinutes = flightDurationMinutes;
		isDeparted = false;
		isArrived = false;
		actualDeparture = null;
		actualArrival = null;
		
		flyerArray = new Flyer[MAX_FLYERS_NUMBER];
		numOfFlyers = 0;
		mileage = 0;
		
		simulateAndSetMileageAccordingToFlightTime();
	}
	
	public Flight(int flightNumber, int flightDurationMinutes, LocalDateTime departure){
		this(flightNumber, flightDurationMinutes, departure, null);
	}
	
	public Flight(int flightNumber, int flightDurationMinutes) {
		this(flightNumber, flightDurationMinutes, null, null); 
	}
	
	public Flight(int flightNumber) {
		this(flightNumber, 0);
	}
	
	// setters getters
	public void setEstimatedDeparture(int year, int month, int day, int hour, int minute) {
		LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute);
		this.estimatedDeparture = newDateTime;
		calculateEstimatedArrival();
	}
	
	public void setEstimatedArrival(int year, int month, int day, int hour, int minute) {
		LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute);
		this.estimatedArrival = newDateTime;
	}
	
	public void setActualDeparture(int year, int month, int day, int hour, int minute) {
		LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute);
		this.actualDeparture = newDateTime;	
	}
	
	public void setActualArrival(int year, int month, int day, int hour, int minute) {
		LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute);
		this.actualArrival = newDateTime;	
	}
	
	public void setFlightDuration(int minutes) {
		this.flightDurationMinutes = minutes;
		calculateEstimatedArrival();
	}
	
	// methods
	private void calculateEstimatedArrival() {
		calculateEstimatedArrival(this.flightDurationMinutes);
	}
	
	private void calculateEstimatedArrival(int flightDurationMinutes) {
		if (estimatedDeparture == null)
			return;
		
		estimatedArrival = estimatedDeparture.plusMinutes(flightDurationMinutes);
	}
	
	private void calculateActualArrival() {
		calculateActualArrival(this.flightDurationMinutes);
	}
	
	private void calculateActualArrival(int flightDurationMinutes) {
		if (actualArrival == null)
			return;
		
		actualArrival = actualDeparture.plusMinutes(flightDurationMinutes);
	}
	
	public void depart() {
		actualDeparture = LocalDateTime.now();
		depart(actualDeparture);
	}
	
	public void depart(LocalDateTime departure) {
		calculateEstimatedArrival();
		this.isDeparted = true;
		this.isArrived = false;
	}
	
	public void land() {
		land(LocalDateTime.now());
	}
	
	public void land(LocalDateTime arrival) {
		calculateActualArrival();
		this.isDeparted = false;
		this.isArrived = true;
	}
	
	public void delayDeparture(int minutes) {
		this.estimatedDeparture = estimatedDeparture.plusMinutes(minutes);
		calculateEstimatedArrival();
	}
	
	public void addFlyer(Flyer flyer) {
		if (numOfFlyers > MAX_FLYERS_NUMBER)
			return;
		
		numOfFlyers++;
		flyerArray[numOfFlyers-1] = flyer;
	}	
	
	public void removeLastFlyer() {
		if (numOfFlyers > 0) {
			numOfFlyers --;
		}
	}
	
	@Override
	public String toString() {
		String str = new String();
		str += String.format("Flight Number: %d%n"
				+ "Flight Duration: %d %n"
				+ "Estimated Departure: %s, Estimated Arrival: %s%n"
			//	+ "Actual Departure %s, Actual Arrival: %s%n"
				+ "Mileage: %.1f",
				flightNumber, flightDurationMinutes, estimatedDeparture, estimatedArrival, mileage );		
		return str;
	}
	
	public void printFrequentFlyers() {
		if (numOfFlyers <= 0)
			return;
			
		System.out.println("<Frequent Flyers>:");
		
		for (int i=0; i<numOfFlyers; i++) {
			System.out.println(flyerArray[i]);
		}
	}

	/**
	 * Sets flight mileage randomly according the flight's flight duration field
	 */
	public void simulateAndSetMileageAccordingToFlightTime() {
		final int MIN_MPH = 460;
		final int MAX_MPH = 575;
		Random random = new Random();
		float randomMPH = random.nextFloat(MIN_MPH,MAX_MPH);
		float mileage = randomMPH * this.flightDurationMinutes / 60;
		
		this.mileage = mileage;
	}
	
	public float getMileage() {
		return mileage;
	}
	
}

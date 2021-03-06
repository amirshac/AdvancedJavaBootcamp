package Airport;

public class Flyer {
	private static long flyerIDCounter;
	
	static {
		flyerIDCounter = 0;
	}
	
	private String firstName;
	private String lastName;
	private long flyerID;
	private MileageCredit credit;
	
	// constructor
	public Flyer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		flyerID = flyerIDCounter;
		flyerIDCounter ++;
		
		credit = new MileageCredit();
	}
	

	public void addFlightToMileageCredit(Flight flight) {
		credit.addFlightAndUpdateStats(flight);
	}
	
	public void printMileageCredit() {
		System.out.println(credit);
	}
	
	@Override
	public String toString() {
		String str = new String();
		str += String.format("<Flyer> ID:%d, %s %s", flyerID, firstName, lastName);
		return str;
	}
}

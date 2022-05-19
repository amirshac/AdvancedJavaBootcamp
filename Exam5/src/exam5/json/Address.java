package exam5.json;

public class Address {
	String street;
	int number;
	String state;
	String city;
	
	// empty constructor for security during deserialization
	public Address() {}
	
	public Address(String street, int number, String state, String city) {
		super();
		this.street = street;
		this.number = number;
		this.state = state;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", state=" + state + ", city=" + city + "]";
	}	
}

package Person;
import java.io.Serializable;

import GeneratorUtil.*;

public class Person implements Serializable{

	private static final long serialVersionUID = 7509470198092247212L;
	
	protected String name;
	protected String street;
	protected String country;
	protected String phoneNumber;
	protected int balance;
	
	
	public Person(String name, String street, String country, String phoneNumber, int balance) {
		super();
		this.name = name;
		this.street = street;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}
	
	public Person() {
		this (GeneratorUtil.randomFullName(), GeneratorUtil.randomStreet(), GeneratorUtil.randomCountry(), GeneratorUtil.randomPhone(), GeneratorUtil.randomNumber(-1000, 100000));
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", street=" + street + ", country=" + country + ", phoneNumber=" + phoneNumber
				+ ", balance=" + balance + "]";
	}
	
	
}

package Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<Person> under21List = new ArrayList<Person>();
		
		personList.add(new Person("Amir", "Shachar", 30));
		personList.add(new Person("Bonny", "Malcoviz", 10));
		personList.add(new Person("Shelly", "Bel", 20));
		personList.add(new Person("Casandro", "Lebobitz", 40));
		personList.add(new Person("Rona", "Mazliach", 70));
		
		personList.forEach(person->System.out.println(person));
		
		System.out.println("------------------------");
		System.out.println("sorting by last name");
		Collections.sort(personList, (p1, p2)->p1.lastName.compareTo(p2.lastName));
		
		personList.forEach(person->System.out.println(person));
		System.out.println("------------------------");

		System.out.println("People under 21");
		personList.forEach(person -> {
			if (person.age < 21) under21List.add(person);
		});
		under21List.forEach(p -> System.out.println(p));
		
		System.out.println("------------------------");
		
		System.out.println("People without o in first name");
		personList.forEach(person -> {
			if (!person.firstName.contains("o") ) System.out.println(person);
		});
		
//		System.out.println("------------------------");
//		System.out.println("People under 21");
//		under21List = (ArrayList<Person>)personList
//				.stream()
//				.filter(p -> p.age < 21)
//				.collect(Collectors.toList());
//				 
//		under21List.forEach(person->System.out.println(person));
//		
//		System.out.println("------------------------");
//		
//		System.out.println("People without o in first name");
//		withoutLetterList = (ArrayList<Person>)personList
//				.stream()
//				.filter(p -> !p.firstName.contains("o"))
//				.collect(Collectors.toList());
//		
//		withoutLetterList.forEach(person -> System.out.println(person));
//		
	}

}

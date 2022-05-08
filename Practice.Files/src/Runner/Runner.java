package Runner;

import java.io.IOException;
import java.util.LinkedList;

import GeneratorUtil.GeneratorUtil;
import Person.Person;
import files.ObjectRW.ObjectRW;

public class Runner {

	public static void testGenerator() {
		GeneratorUtil.init();
		System.out.println(GeneratorUtil.randomFullName());
		System.out.println(GeneratorUtil.randomStreet());
		System.out.println(GeneratorUtil.randomCountry());
		System.out.println(GeneratorUtil.randomDateString());
		System.out.println(GeneratorUtil.randomPhone());	
	}
	
	
	public static void testWriteObjects(int num) {		
		
		String fileName = "files/persons.dat";
		Person person = null;
		
		System.out.println("Writing " + num + " objects to file...");
		
		ObjectRW.openWrite(fileName);
		
		try {
			for (int i=0; i<num; i++) {
				person = new Person();
				ObjectRW.objectWriter.writeObject(person);				
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		ObjectRW.closeWrite();
		
		System.out.println("Done");

		
	}
	
	public static void testReadObjects() {
		LinkedList<Person> personList = new LinkedList<Person>();
		
		String fileName = "files/persons.dat";
		Person person = null;
		
		System.out.println("Reading objects from file...");
		ObjectRW.openRead(fileName);
		
		try {
			while (true) {
				person = (Person)ObjectRW.objectReader.readObject();
				personList.add(person);	
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		ObjectRW.closeRead();
		System.out.println("Done reading");
		int i=0;
		for (Person element : personList) {
			System.out.print(i++);
			System.out.println(element);
		}
	}
	
	public static void main(String[] args) {
		//testWriteObjects(100);
		testReadObjects();
	}

}

package patterns.adapter;

public class Runner {
	

	public static void main(String [] args) {
		Sparrow sparrow = new Sparrow();
		ToyDuck toyDuck = new ToyDuck();
		
		sparrow.fly();	
		sparrow.makeSound();
		
		toyDuck.squeak();
		
		BirdToToyDuckAdapter adapter = new BirdToToyDuckAdapter(sparrow);
		adapter.squeak();
	}
}

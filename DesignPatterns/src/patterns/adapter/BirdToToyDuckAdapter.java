package patterns.adapter;

public class BirdToToyDuckAdapter extends ToyDuck{

	protected Bird bird;
	
	public BirdToToyDuckAdapter(Bird bird) {
		this.bird = bird;
	}
	
	@Override
	public void squeak() {
		System.out.println("Toy squeaking! I'm not a bird");
		bird.makeSound();
	}

}

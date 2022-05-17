package patterns.adapter;

public class Sparrow implements Bird {

	@Override
	public void fly() {
		System.out.println("Sparrow: flying");
	}

	@Override
	public void makeSound() {
		System.out.println("Sparrow: sparrow sound chirp chirp");
	}
}

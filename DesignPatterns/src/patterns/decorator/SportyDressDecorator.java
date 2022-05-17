package patterns.decorator;

public class SportyDressDecorator extends DressDecorator{
	
	public SportyDressDecorator(Dress wrapee) {
		super(wrapee);
	}
	
	@Override
	public void produce() {
		System.out.println("Sporty decorator:");
		super.produce();
	}

}

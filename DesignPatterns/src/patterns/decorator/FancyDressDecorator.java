package patterns.decorator;

public class FancyDressDecorator extends DressDecorator {

	public FancyDressDecorator(Dress wrapee) {
		super(wrapee);
	}
	
	@Override
	public void produce() {
		System.out.println("Fancy decorator:");
		super.produce();
	}

}

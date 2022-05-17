package patterns.decorator;

public class CasualDressDecorator extends DressDecorator {

	public CasualDressDecorator(Dress wrapee) {
		super(wrapee);
	}

	@Override
	public void produce() {
		System.out.println("Casual decorator:");
		super.produce();
	}

}

package patterns.decorator;

public class DressDecorator implements Dress {
	private Dress wrapee;
	
	public DressDecorator(Dress wrapee) {
		this.wrapee = wrapee;
	}

	@Override
	public void produce() {
		wrapee.produce();
	}
}

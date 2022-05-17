package patterns.decorator;

public class BasicDress implements Dress{

	protected String color;
	protected String size;
	
	public BasicDress(String color, String size) {
		this.color = color;
		this.size = size;
	}
	
	@Override
	public void produce() {
		System.out.println("Produced basic dress: \n" + this);
		System.out.println("=========================");
	}

	@Override
	public String toString() {
		return "BasicDress [color=" + color + ", size=" + size + "]";
	}

}

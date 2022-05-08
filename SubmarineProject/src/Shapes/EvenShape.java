package Shapes;

public class EvenShape extends Shape {
	
	protected int size;
	
	// constructors
	public EvenShape() {
		this(1);
	}
	
	public EvenShape(int size) {
		super(size, size);
		this.size = size;
		this.width = size;
		this.height = size;
	}
	
	public EvenShape(char[][] data) {
		setData(data);
		this.size = data.length;
		this.width = size;
		this.height = size;
	}
	
	public int getSize() {
		return size;
	}
	
}

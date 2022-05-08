package submarines;

import Shapes.RotatableShape;

public abstract class Submarine{

	protected SubmarineType type;
	protected RotatableShape shape;
	
	// constructors
	public Submarine(int size) {
		shape = new RotatableShape(size);
	}
	
	public void rotate() {
		shape.rotate();
	}
	
	public void print() {
		shape.print();
	}
	
	public RotatableShape getShape() {
		return this.shape;
	}
	
	public int getSize() {
		return this.shape.getSize();
	}

	@Override
	public String toString() {
		return "Submarine [type=" + type + ", shape=" + shape + ", Size()=" + getSize() + "]";
	}
	
	
}

enum SubmarineType{
	A,
	B,
	C,
	D
};
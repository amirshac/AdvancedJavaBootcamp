package submarines;

import Shapes.RotatableShape;

public class SubmarineTypeD extends Submarine {

	public SubmarineTypeD() {
		this(1);
	}
	
	public SubmarineTypeD(int size) {
		super(size);
		setShape();
	}
	
	public void setShape() {
		char[][] newShape = { 
				{'B', 'B'},
				{'B', 'B'}
				};
		this.shape = new RotatableShape(newShape);
	}
}

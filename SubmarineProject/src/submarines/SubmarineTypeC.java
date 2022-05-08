package submarines;

import Shapes.RotatableShape;

public class SubmarineTypeC extends Submarine {

	public SubmarineTypeC() {
		this(3);
	}
	
	public SubmarineTypeC(int size) {
		super(size);
		setShape();
	}
	
	public void setShape() {
		char[][] newShape = { 
				{0, 0  ,'B'},
				{0, 'B','B'},
				{0, 'B', 0}
				};
		this.shape = new RotatableShape(newShape);
	}
}

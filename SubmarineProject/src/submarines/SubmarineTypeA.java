package submarines;

import Shapes.RotatableShape;

public class SubmarineTypeA extends Submarine {

	public SubmarineTypeA() {
		this(1);
	}
	
	public SubmarineTypeA(int size) {
		super(size);
		setShape(size);
	}
	
	public void setShape(int size) {
		
		if (size > 4)
			size = 4;
		else if (size < 1)
			size = 1;
		
		switch (size) {
		case 1:
			char[][] newShape1 = { {'B'} };
			this.shape = new RotatableShape(newShape1);
			break;
			
		case 2:
			char[][] newShape2 = { 
					{'B','B'},
					{0,0} 
					};
			this.shape = new RotatableShape(newShape2);
			break;
			
		case 3:
			char[][] newShape3 = { 
					{'B','B','B'},
					{0,0,0},
					{0,0,0}
					};
			this.shape = new RotatableShape(newShape3);
			break;
			
		case 4:
			char[][] newShape4 = { 
					{'B','B','B','B'},
					{0,0,0,0},
					{0,0,0,0},
					{0,0,0,0}
					};
			this.shape = new RotatableShape(newShape4);
			break;
			
		default: return;
		}
				
	}
}

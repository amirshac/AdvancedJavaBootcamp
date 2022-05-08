package submarines;

import Shapes.RotatableShape;

public class SubmarineTypeB extends Submarine {

	public SubmarineTypeB() {
		this(1);
	}
	
	public SubmarineTypeB(int size) {
		super(size);
		setShape(size);
	}
	
	public void setShape(int size) {
		
		if (size > 4)
			size = 4;
		else if (size < 3)
			size = 3;
		
		switch (size) {
			
		case 3:
			char[][] newShape3 = { 
					{0  ,'B'},
					{'B','B'}
					};
			this.shape = new RotatableShape(newShape3);
			break;
			
		case 4:
			char[][] newShape4 = { 
					{0,0,0,0},
					{0,0,0,0},
					{0,0,0,'B'},
					{'B','B','B','B'}
					};
			this.shape = new RotatableShape(newShape4);
			break;
			
		default: return;
		}
				
	}
}

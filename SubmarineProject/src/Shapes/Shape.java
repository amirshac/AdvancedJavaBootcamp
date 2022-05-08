package Shapes;

public class Shape implements Printable {
	
	protected int width;
	protected int height;
	
	protected char[][] data;
	
	// constructors
	public Shape() {
		this(1,1);
	}
	
	public Shape (int x, int y) {
		data = new char[x][y];
		width = x;
		height = y;
	}
		
	public Shape(char[][] data) {
		setData(data);
		width = data.length;
		height = data.length;
	}

	// methods
	
	public void print() {
		print('.');
	}
	
	public void print(char charForNoData) {
		for (int i=0; i<data.length; i++) {
			for (int j=0; j<data[i].length; j++) {
				if (data[i][j]==0)
					System.out.print(charForNoData);					
					
				else
					System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}
	
	// ## still in progress need to implement lengths better for uneven shapes
	public boolean placeShape(Shape otherShape, int x, int y) {
		
		if ( !canPlaceShape(otherShape, x, y) ) {
			System.out.println("Can't place shape!");
			return false;
		}
				
		int size = otherShape.data.length;
		
		for (int i=0; i<otherShape.data.length; i++){
			for (int j=0; j<otherShape.data[i].length; j++) {
				this.setData(otherShape.getData(i,j), x+i, y+j);
			}	
		}
		
		return true;
	}
		
	// ## still in progress need to implement lengths better for uneven shapes
	public boolean canPlaceShape(Shape otherShape, int x, int y) {
		boolean result = true;
		int size = otherShape.data.length;
		
		// makes sure we don't pass limits
		if ( (x+size > this.data.length) || (y+size > this.data[0].length) )
			return false;
		
		if ( (x < 0 ) || (y < 0) )
			return false;
		
		for (int i=0; i<otherShape.data.length; i++){
			for (int j=0; j<otherShape.data[i].length; j++) {
				if ( (this.hasData(x+i, y+j)) && otherShape.hasData(i, j)) {
					return false;
				}
			}	
		}
		
		return result;
	}
	// setters getters
	 	public char[][] getData() {
		return data;
	}
	 	
	public char getData(int x, int y) {
		return data[x][y];
	}
	
	public void setData(char[][] data) {
		this.data = data;	
	}
	
	public void setData(char data, int i, int j) {
		this.data[i][j] = data;
	}

	public boolean hasData(int x, int y) {
		boolean result = true;
		if (this.data[x][y] == 0)
			result = false;
		
		return result;
	}
	
	/**
	 * Checks if character exists inside shape
	 * @param dataToCheck
	 * @return true if exists, false if doesn't exist
	 */
	public boolean doesDataExist(char dataToCheck) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++ ) {
				if (data[i][j] == dataToCheck)
					return true;
			}
		}	
		
		return false;
	}
	
	public void replaceData(char whatToReplace, char replaceTo) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++ ) {
				if (data[i][j] == whatToReplace)
					data[i][j] = replaceTo;
				}
			}		
	}

	@Override
	public String toString() {
		return "<Shape> [width=" + width + ", height=" + height + "]";
	}
}

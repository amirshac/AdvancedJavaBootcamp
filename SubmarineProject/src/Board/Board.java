package Board;

import Shapes.*;
import submarines.Submarine;

public class Board {
	public final int WIDTH = 10;
	public final int HEIGHT = 20;
	
	protected Shape data;
	
	public Board() {
		data = new Shape(WIDTH, HEIGHT);
	}
		
	public void print() {
		data.print();
	}
	
	public void reset() {
		data = new Shape(WIDTH, HEIGHT);
	}
	
	public void setData(char data, int x, int y) {
		this.data.setData(data, x, y);
	}
		
	public boolean placeSubmarine(Submarine sub, int x, int y) {
		boolean result;
		
		result = placeShape(sub.getShape(), x, y);
		
		return result;
	}
	
	public boolean placeShape(EvenShape shape, int x, int y) {
		if ( !data.canPlaceShape(shape, x, y) ) {
			//System.out.println("<board.placeshape>Can't place shape!" + x + " " + y);
			//shape.print();
			return false;
		}
		
		data.placeShape(shape, x, y);
		return true;
	}
	
	public boolean hasData(int x, int y) {
		return data.hasData(x, y);
	}
	
	public char getData(int x, int y) {
		return data.getData(x, y);
	}
	
	public boolean dataEquals(int x, int y, char chr) {
		return (data.getData(x,y) == chr);
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public Shape getShape() {
		return this.data;
	}
	
	/**
	 * Resets submarine stats to 'unhit' again
	 */
	
	public void resetSubmarines() {
		data.replaceData('H', 'B');
		data.replaceData('m', (char)0);
	}
}


package Testing.Shirts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)

class ColorTest {
	
	Color[] colorArr;
	
	public ColorTest() {
		colorArr = new Color[4];
		createColors();
	}
	
	void createColors() {
		colorArr[0] = new Color();
		colorArr[1] = new Color(-10,-10,-1);
		colorArr[2] = new Color(254,256,254);
		colorArr[3] = new Color(-90, 200, 9090);
	}
	
	@Test
	void testColorsNotNull() {
		for (Color color : colorArr) {
		 System.out.println(color);
		}
	}

}

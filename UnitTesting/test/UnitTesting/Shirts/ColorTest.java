package UnitTesting.Shirts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import UnitTesting.Shirts.Color;

@TestInstance(Lifecycle.PER_METHOD)

class ColorTest {
	
	private final static int TEST_SIZE = 4;
	Color[] colorArr;
	Color[] expectedColorArr;
	String[] dominantColorArr;
	float[][] normalizedArr;
	
	public ColorTest() {
		colorArr = new Color[TEST_SIZE];
		expectedColorArr = new Color[TEST_SIZE];
		dominantColorArr = new String[TEST_SIZE];
		normalizedArr = new float[TEST_SIZE][3];
		
		populateColors();
	}
	
	void populateColors() {
		colorArr[0] = new Color();
		colorArr[1] = new Color(-10,-10,-1);
		colorArr[2] = new Color(254,256,254);
		colorArr[3] = new Color(-90, 200, 9090);
	}
	
	void populateExpectedColors() {
		expectedColorArr[0] = new Color(100, 100, 100);
		expectedColorArr[1] = new Color(0, 0, 0);
		expectedColorArr[2] = new Color(254, 255, 254);
		expectedColorArr[3] = new Color(0, 200, 255);
	}
	
	void populateDominantColors() {
		dominantColorArr[0] = Color.DOMINANT_RED;
		dominantColorArr[1] = Color.DOMINANT_RED;
		dominantColorArr[2] = Color.DOMINANT_GREEN;
		dominantColorArr[3] = Color.DOMINANT_BLUE;
	}
	
	void populateNormalized() {
		normalizedArr[0][0] = (float)100/255;
		normalizedArr[0][1] = (float)100/255;
		normalizedArr[0][2] = (float)100/255;
		
		normalizedArr[1][0] = 0;
		normalizedArr[1][1] = 0;
		normalizedArr[1][2] = 0;
		
		normalizedArr[2][0] = (float)254/255;
		normalizedArr[2][1] = (float)255/255;
		normalizedArr[2][2] = (float)254/255;

		normalizedArr[3][0] = 0;
		normalizedArr[3][1] = (float)200/255;
		normalizedArr[3][2] = (float)255/255;
	}
	
	@Test
	@DisplayName("No color is NULL")
	
	void testColorsNotNull() {
		for (Color color : colorArr) {
		 assertNotNull(color);
		}
	}
	
	@Test
	@DisplayName("Color equality using color.equals method")
	
	void testColorsEquality() {
		populateExpectedColors();
		
		for (int i=0; i<colorArr.length; i++) 
			assertTrue(colorArr[i].equals(expectedColorArr[i]));	
	}
	
	@Test
	@DisplayName("Color equality in all RGB fields using direct field comparison")
	void testColorsEqualityFields() {
		populateExpectedColors();
		
		for (int i=0; i<colorArr.length; i++) {
			assertEquals(expectedColorArr[i].red, colorArr[i].red);
			assertEquals(expectedColorArr[i].green, colorArr[i].green);
			assertEquals(expectedColorArr[i].blue, colorArr[i].blue);
		}
	}
	
	@Test
	@DisplayName("Dominant color equality")
	
	void testDominantColors() {
		populateDominantColors();
		
		for (int i=0; i<colorArr.length; i++) 
			assertEquals(dominantColorArr[i], colorArr[i].getDominant());
	}
	
	@Test
	@DisplayName("Normalized colors test")
	void testNormalized() {
		populateNormalized();
		
		for (int i=0; i<colorArr.length; i++) 
			for (int j=0; j<3; j++) 
				assertEquals(normalizedArr[i][j], colorArr[i].normalized[j]);
	}
	
	
	
}

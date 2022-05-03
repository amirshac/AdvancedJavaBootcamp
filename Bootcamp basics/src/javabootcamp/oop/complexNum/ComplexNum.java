package javabootcamp.oop.complexNum;

/**
 * This class describes complex numbers.
 * 
 * @author amirs
 *
 */

public class ComplexNum implements Complexable {
	
	// fields
	double realPart;
	double imaginaryPart;
	
	// constructors
	public ComplexNum(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public ComplexNum() {
		this(0,0);
	}

	// methods
	
	public void add(ComplexNum z) {
	}
	
	public void subtract(ComplexNum z) {
		
	}
	
	public void multiply(ComplexNum z) {
		
	}
	
	public void divide(ComplexNum z) {
		
	}

	public static ComplexNum add(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = new ComplexNum();
		result.realPart = z1.realPart + z2.realPart;
		result.imaginaryPart = z1.imaginaryPart + z2.imaginaryPart;
		return result;
	}

	public static ComplexNum subtract(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = new ComplexNum();
		result.realPart = z1.realPart - z2.realPart;
		result.imaginaryPart = z1.imaginaryPart - z2.imaginaryPart;
		return result;
	}

	public static ComplexNum multiply(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = new ComplexNum();
		result.realPart = (z1.realPart*z2.realPart)-(z1.imaginaryPart*z2.imaginaryPart);
		result.imaginaryPart = (z1.realPart*z2.imaginaryPart)+(z1.imaginaryPart*z2.realPart);
		return result;
	}

	public static ComplexNum divide(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = new ComplexNum();
		result.realPart = (z1.realPart*z2.realPart)+(z1.imaginaryPart*z2.imaginaryPart);
		result.realPart /= (z2.realPart*z2.realPart) + (z2.imaginaryPart*z2.imaginaryPart);
		
		result.imaginaryPart = (z1.imaginaryPart*z2.realPart) - (z1.realPart*z2.imaginaryPart);
		result.imaginaryPart /= (z2.realPart*z2.realPart) + (z2.imaginaryPart*z2.imaginaryPart);
		
		return result;
	}

	public static ComplexNum parseComplex(String s) {
		ComplexNum result = new ComplexNum();
		return result;
	}
	
	
	public ComplexNum conjugate() {
		ComplexNum num = new ComplexNum();
		num.realPart = this.realPart;
		num.imaginaryPart = this.imaginaryPart*(-1);
		return num;	
	}
	
	public double mag() {
		double result = Math.pow(this.realPart,2) + Math.pow(this.imaginaryPart,2);
		result = Math.sqrt(result);
		return result;
	}
	
	public ComplexNum square() {
		ComplexNum num = new ComplexNum();
		return num;	
	}
	
	@Override
	public String toString() {
		String signImaginaryStr = new String();
		
		if (imaginaryPart >= 0)
			signImaginaryStr = "+";
			
		String result = String.format("%.2f%s%.2fi", realPart, signImaginaryStr, imaginaryPart);
		return result;
	}
	
	public ComplexNum pow(ComplexNum z, int power) {
		ComplexNum num = new ComplexNum();
		return num;
	}
	
	
	@Override
	public boolean equals(Object z) {
		return false;
	}
	
	public ComplexNum inverse() {
		ComplexNum num = new ComplexNum();
		return num;
	}
	
	

}

package javabootcamp.oop.complexNum;

public interface Complexable {

	/**
	 * Adds another ComplexNum to the current complex number.
	 * 
	 * @param z the complex number to be added to the current complex number
	 */

	void add(ComplexNum z);

	/**
	 * Subtracts another ComplexNum from the current complex number.
	 * 
	 * @param z the complex number to be subtracted from the current complex number
	 */

	void subtract(ComplexNum z);

	/**
	 * Multiplies another ComplexNum to the current complex number.
	 * 
	 * @param z the complex number to be multiplied to the current complex number
	 */

	void multiply(ComplexNum z);

	/**
	 * Divides the current ComplexNum by another ComplexNum.
	 * 
	 * @param z the divisor
	 */
	public void divide(ComplexNum z);

	/**
	 * Adds two ComplexNum.
	 * 
	 * @param z1 the first ComplexNum.
	 * @param z2 the second ComplexNum.
	 * @return the resultant ComplexNum (z1 + z2).
	 */
	//ComplexNum add(ComplexNum z1, ComplexNum z2);

	/**
	 * Subtracts one ComplexNum from another.
	 * 
	 * @param z1 the first ComplexNum.
	 * @param z2 the second ComplexNum.
	 * @return the resultant ComplexNum (z1 - z2).
	 */
	//ComplexNum subtract(ComplexNum z1, ComplexNum z2);

	/**
	 * Multiplies one ComplexNum to another.
	 * 
	 * @param z1 the first ComplexNum.
	 * @param z2 the second ComplexNum.
	 * @return the resultant ComplexNum (z1 * z2).
	 */
	//ComplexNum multiply(ComplexNum z1, ComplexNum z2);

	/**
	 * Divides one ComplexNum by another.
	 * 
	 * @param z1 the first ComplexNum.
	 * @param z2 the second ComplexNum.
	 * @return the resultant ComplexNum (z1 / z2).
	 */
	//ComplexNum divide(ComplexNum z1, ComplexNum z2);

	/**
	 * The complex conjugate of the current complex number.
	 * 
	 * @return a ComplexNum object which is the conjugate of the current complex
	 *         number
	 */

	ComplexNum conjugate();

	/**
	 * The modulus, magnitude or the absolute value of current complex number.
	 * 
	 * @return the magnitude of current complex number
	 */

	double mag();

	/**
	 * The square of the current complex number.
	 * 
	 * @return a ComplexNum which is the square of the current complex number.
	 */

	ComplexNum square();

	/**
	 * @return the complex number in x + yi format
	 */
	@Override
	String toString();

	/**
	 * Calculates the ComplexNum to the passed integer power.
	 * 
	 * @param z     The input complex number
	 * @param power The power.
	 * @return a ComplexNum which is (z)^power
	 */
	ComplexNum pow(ComplexNum z, int power);

	/**
	 * Parses the String as a ComplexNum of type x+yi.
	 * 
	 * @param s the input complex number as string
	 * @return a ComplexNum which is represented by the string.
	 */
	//ComplexNum parseComplex(String s);

	/**
	 * Checks if the passed ComplexNum is equal to the current.
	 * 
	 * @param z the complex number to be checked
	 * @return true if they are equal, false otherwise
	 */
	@Override
	boolean equals(Object z);

	/**
	 * The inverse/reciprocal of the complex number.
	 * 
	 * @return the reciprocal of current complex number.
	 */
	ComplexNum inverse();
	
}

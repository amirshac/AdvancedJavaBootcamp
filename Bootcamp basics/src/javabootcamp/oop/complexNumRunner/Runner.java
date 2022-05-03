package javabootcamp.oop.complexNumRunner;
import javabootcamp.oop.complexNum.*;

public class Runner {

	public static void main(String args[])
	{
		// Default Complex Number 0+0i
		ComplexNum c0 = new ComplexNum();

		// 5+6i
		ComplexNum c1 = new ComplexNum(5,6);

		// 6-9i
		ComplexNum c2 = new ComplexNum(6,-9);

		
		System.out.println(c0);
		System.out.println(c1);
		System.out.println(c2);
		
		
		ComplexNum c1_plus_c2 = ComplexNum.add(c1,c2);
		ComplexNum c1_minus_c2 = ComplexNum.subtract(c1,c2);
		ComplexNum c1_into_c2 = ComplexNum.multiply(c1,c2);
		ComplexNum c1_by_c2 = ComplexNum.divide(c1,c2);

		System.out.println(c1.toString()+" + "+c2.toString()+" = "+ c1_plus_c2.toString());
		System.out.println(c1.toString()+" - "+c2.toString()+" = "+ c1_minus_c2.toString());
		System.out.println(c1.toString()+" * "+c2.toString()+" = "+ c1_into_c2.toString());
		System.out.println(c1.toString()+" / "+c2.toString()+" = "+ c1_by_c2.toString());

		// Parsing Complex Numbers
		//ComplexNum c3 = ComplexNum.parseComplex("-4+7i");
		ComplexNum c3 = new ComplexNum(-4,7);
		System.out.println(c3.toString());

		System.out.println(c3.mag());

		// Conjugate
//		System.out.println(c3.conjugate());		
	
	
	}
	

}

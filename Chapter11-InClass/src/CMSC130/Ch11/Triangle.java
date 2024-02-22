package CMSC130.Ch11;

/**
 * Public child class that creates a 'Triangle' object from a 'GeometricObject' parent class.
 * 
 * Includes:
 * 	+toString()
 * 	+getArea()
 * 	+getPerimeter()
 * 	+Getters/Setters for all three sides (side1, side2, side3)
 */
public class Triangle extends GeometricObject {

	/**
	 * Primitive doubles contain (3) side lengths of triangle.
	 */
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	/**
	 * No-Argument constructor for the inherited class 'Triangle'
	 * 
	 * Inherited from 'GeometricObject' class
	 */
	public Triangle() {}
	
	/**
	 * Constructor sets these three instance variables to the parameters.
	 * 
	 * @param side1 1st side of triangle
	 * @param side2 2nd side of triangle
	 * @param side3 3rd side of triangle
	 */
	public Triangle(double side1, double side2, double side3) {
		
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	/**
	 * Accessor method for area of an inherited 'Triangle' object.
	 * 
	 * Calculation done using Heron's formula and the 'java.lang.Math' default package
	 * 
	 * @return Area of object-type 'Triangle' in a primitive double data-type
	 */
	public double getArea() {
		
		double area = (0.25) * Math.sqrt((side1+side2-side3) *
										(side1 - side2 + side3) *
										(-side1 +side2 +side3) *
										(side1+side2+side3) );
		
		return area;
	}
	
	/**
	 * @return side1+side2+side3 [the perimeter is calculated with all three sides]
	 */
	public double getPerimeter() {
		
		return side1 + side2 + side3;
	}
	
	/**
	 * @return side1's value
	 */
	public double getSide1() {
		return side1;
	}

	/**
	 * @return side2's value
	 */
	public double getSide2() {
		return side2;
	}

	/**
	 * @return side3's value
	 */
	public double getSide3() {
		return side3;
	}

	/**
	 * @param side1: side1 to set
	 */
	public void setSide1(double side1) {
		this.side1 = side1;
	}

	/**
	 * @param side2: side2 to set
	 */
	public void setSide2(double side2) {
		this.side2 = side2;
	}

	/**
	 * @param side3: side3 to set
	 */
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	/**
	 * Uses the inherited 'toString()' and overrides GeometricObject's 'toString()' method.
	 * 
	 * @return Triangle object's information as a 'toString()'
	 */
	@Override
	public String toString() {
		return "Triangle [side1=" + side1 + 
			   ", side2=" + side2 + 
			   ", side3=" + side3 +
			   ", toString()=" + super.toString() + "]";
	}
	
}
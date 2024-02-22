/**
 * Chapter 11, In-Class Assignment
 * 
 * @author gmh80623@lockhaven.edu
 * 
 */

package CMSC130.Ch11;
import java.util.*;

/**
 * Public class that utilizes the inherited classes 'Triangle' and 'Circle' from 'GeometricObject'.
 */
public class App {

	/**
	 * @param args String[]
	 */
	public static void main(String[] args) {
		
		// New 'Triangle' object named "triangle".
		Triangle triangle = new Triangle();
		
		// Tests/Prints the overridden 'toString()' method in the created 'Triangle' object named "triangle".
		System.out.println("Testing triangle toString() method");
		System.out.println( triangle );
		
		//Used for formatting ONLY
		System.out.println();
		
		// Tests the following getter/accessor methods within the 'Triangle' class:
		//		'getSide1()'
		//      'getSide2()'
		//      'getSide3()'
		System.out.println("Testing triangle getters");
		System.out.println("Side1: " + triangle.getSide1() );
		System.out.println("Side1: " + triangle.getSide2() );
		System.out.println("Side1: " + triangle.getSide3() );
		
		// Prints if the Triangle is filled using the 'isFilled()' method.
		System.out.println("Filled: " + triangle.isFilled() );
		
		// Creates new ArrayList with 'GeometricObject' types.
		// ALL INHERITED TYPES LIKE TRIANGLE OR CIRCLE CAN BE STORED IN THIS ARRAY.
		ArrayList<GeometricObject> objectArray = new ArrayList<>();
		
		// Add the first created 'Triangle' object named "triangle".
		objectArray.add( triangle );
		
		// Creates and adds a new 'Circle' object named "circle" to the 'ArrayList<>' named "objectArray".
		Circle circle = new Circle();
		objectArray.add(circle);
		
		/*
		* Creates and adds a new 'Triangle' object named "triangle2" to the 'ArrayList<>' named "objectArray".
		* 
		* Parameters:
		* 	- side1 == 3
		* 	- side2 == 4
		* 	- side3 == 5
		*/
		Triangle triangle2 = new Triangle(3,4,5);
		objectArray.add(triangle2);
		
		/*
		* Creates and adds a new 'Circle' object named "circle2" to the 'ArrayList<>' named "objectArray".
		* 
		* Parameters:
		* 	- radius == 5
		*/
		Circle circle2 = new Circle(5);
		objectArray.add(circle2);
		
		// Formatted nicely for output when running 'App.class'.
		System.out.println();
		System.out.println("Looping Through ArrayList: ");
		
		// For-each loop that loops through every 'GeometricObject' object in the 'ArrayList<>' named "objectArray".
		for(GeometricObject object: objectArray) {
			
			System.out.println();
			System.out.println(object);
			
			// Uses "instanceof" to check if an object in 'ArrayList<>' named "objectArray" is of type 'Circle'.
			// If 'Circle' object is found, explicitCast/upCast to a type of 'Circle'.
			if(object instanceof  Circle) {
				System.out.println( ((Circle) object).getPerimeter() );
			}
		}
	}
}
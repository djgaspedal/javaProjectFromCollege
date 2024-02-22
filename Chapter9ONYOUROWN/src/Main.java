
import java.util.*;

// Separate
public class Main {

	// Main method to create and use 'Fan' objects
	public static void main(String[] args) {
		
		// Creates a new 'Fan' object called newFan
		Fan newFan = new Fan();
		
		// Turns the newFan on
		newFan.setOn(true);
		
		// Calls the 'toString()' method, so it can be printed with 'println()'
		newFan.toString();
		System.out.println(newFan);
		
		
		// Creates a new 'Fan' object called industrialFan
		Fan industrialFan = new Fan("industrialFan");
				
		// Sets the size to 60 and color to chrome of industrialFan
		industrialFan.setRadius(50);
		industrialFan.setColor("Chrome");
		
		// Sets speed on High or, level 3
		industrialFan.setSpeed(3);
		
		// Turns the industrialFan on
		industrialFan.setOn(true);
		
		// Calls the 'toString()' method, so industrialFan information can be printed
		industrialFan.toString();
		System.out.println(industrialFan);
		
		
		// Creates a new 'Fan' object called miniFan
		Fan miniFan = new Fan("miniFan");
				
		// Sets the size to 3 and color to Green of miniFan
		miniFan.setRadius(3);
		miniFan.setColor("Green");
		
		// Sets speed on Medium or, level 2
		miniFan.setSpeed(2);
		
		// Turns the miniFan on
		miniFan.setOn(true);
		
		// Calls the 'toString()' method, so miniFan information can be printed
		miniFan.toString();
		System.out.println(miniFan);

	}

}


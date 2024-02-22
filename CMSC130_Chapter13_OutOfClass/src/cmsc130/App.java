/**
 * @author gmh80623@lockhaven.edu
 */
package cmsc130;

import java.util.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.stage.Stage;


/**
 * Public class that tests the different vehicles and their methods.
 */
public class App {

	/**
	 * @param args Command-Line Arguments
	 */
	public static void main(String[] args) {
		
		// New Car object named Lexus,
		//		object_ref: car1
		Car car1 = new Car("Lexus");
		
		// New Motorcycle object named Harley Davidson,
		//		object_ref: motorcycle1
		Motorcycle motorcycle1 = new Motorcycle("Harley Davidson");
		
		// New Motorcycle object named Trek,
		//		object_ref: bike1
		Bicycle bike1 = new Bicycle("Trek");
		
		// New Motorcycle object named LockHavenBoard,
		//		object_ref: skateboard1
		Skateboard skateboard1 = new Skateboard("LockHavenBoard");

		// Test all methods for car1.
        System.out.println("Testing Lexus:");
        
        // Accelerate the car.
        car1.accelerate();
        
        // Slow down the car.
        car1.slowDown();
        
        // Stop the car.
        car1.stop();
        
        // Turn the car left.
        car1.turnLeft();
        
        // Turn the car right.
        car1.turnRight();
        
        // Set cruise to 60MPH
        car1.setSpeed(60);
        
        // Cancel cruise for car.
        car1.cancel();
        
        // A/C turned on and off.
        car1.acOn();
        car1.acOff();
        
        // Formatting purposes.
        System.out.println();

        // Test all methods for motorcycle1.
        System.out.println("Testing Harley Davidson:");
        
        // Accelerate the motorcycle.
        motorcycle1.accelerate();
        
        // Slow down the motorcycle.
        motorcycle1.slowDown();
        
        // Stop the motorcycle.
        motorcycle1.stop();
        
        // Turn the motorcycle left.
        motorcycle1.turnLeft();
        
        // Turn the motorcycle right.
        motorcycle1.turnRight();
        
        // Cruise set to 70MPH
        motorcycle1.setSpeed(70);
        
        // Cruise set off.
        motorcycle1.cancel();
        
        // Formatting purposes.
        System.out.println();
        
        // Test all methods for bike1.
        System.out.println("Testing Trek:");
        
        // Accelerate the bike.
        bike1.accelerate();
        
        // Slow down the bike.
        bike1.slowDown();
        
        // Stop the bike.
        bike1.stop();
        
        // Turn the bike left.
        bike1.turnLeft();
        
        // Turn the bike right.
        bike1.turnRight();
        
        // Formatting purposes.
        System.out.println();

        // Test all methods for skateboard1.
        System.out.println("Testing LockHavenBoard:");
        
        // Accelerate the skateboard.
        skateboard1.accelerate();
        
        // Slow the skateboard.
        skateboard1.slowDown();
        
        // Stop the skateboard.
        skateboard1.stop();
        
        // Turn skateboard left.
        skateboard1.turnLeft();
        
        // Turn skateboard right.
        skateboard1.turnRight();
        
        // Formatting purposes.
        
        
	}

}


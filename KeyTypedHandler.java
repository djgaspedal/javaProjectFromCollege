/**
 * @author gmh80623@lockhaven.edu
 */

package interactivity;

import cmsc130.RobotVideoOutput;
import javafx.scene.input.KeyCode;

/**
 * Handles key events to move the robot forward, left, right, and reverse.
 */
public class KeyTypedHandler {

	/**
	 * Selects which action is done for certain key codes: W, A, S, D.
	 * 
	 * @param totalMotorSpeed : Speed of the motor during maneuvers.
	 * @param k : Only 4 KeyCode choices (W, A, S, D).
	 */
	public static void moveKeyType(int totalMotorSpeed, KeyCode k) {
		
		if (k == KeyCode.W) { // Move Forward
		     
			RobotVideoOutput.getRobot().move(totalMotorSpeed, totalMotorSpeed);
			
		} else if (k == KeyCode.S) { // Move Reverse
			  
			RobotVideoOutput.getRobot().move(-totalMotorSpeed, -totalMotorSpeed);
			  
		} else if (k == KeyCode.D){ // Move Right
			  
			RobotVideoOutput.getRobot().move(totalMotorSpeed, (int)(totalMotorSpeed * 0.25));
			  
		} else if(k == KeyCode.A) { // Move Left
			
			RobotVideoOutput.getRobot().move( (int)(totalMotorSpeed * 0.25), totalMotorSpeed);
			
		}
	}
}
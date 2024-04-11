/**
 * @author gmh80623@lockhaven.edu
 */

package interactivity;

import cmsc130.RobotVideoOutput;

/**
 * Class that contains our methods to move the robot. Lambda
 * 		functions contained in the RobotVideoOutput class call these methods.
 */
public class ButtonClickHandler {

	/**
	 * Moves the robot forward depending on the speed of the left and right motor.
	 * 
	 * Parameter RANGE [-100, 100].
	 * 
	 * @param leftSpeed : Speed of the left motor.
	 * @param rightSpeed : Speed of the right motor.
	 */
	public static void buttonMoveForward(int leftSpeed, int rightSpeed) {
		
		RobotVideoOutput.getRobot().move(leftSpeed, rightSpeed);
	}
	
	/**
	 * Moves the robot left depending on the motor speed.
	 * 
	 * Parameter RANGE [-100, 100].
	 * 
	 * @param turningSpeed : Speed of the motors.
	 */
	public static void buttonMoveLeft(int turningSpeed) {
		
		RobotVideoOutput.getRobot().move( (int)(turningSpeed * 0.25), turningSpeed);
	}
	/**
	 * Moves the robot right depending on the motor speed (turning speed).
	 * 
	 * Parameter RANGE [-100, 100].
	 * 
	 * @param turningSpeed : Speed of the motors.
	 */
	public static void buttonMoveRight(int turningSpeed) {
		
		RobotVideoOutput.getRobot().move( turningSpeed, (int)(turningSpeed * 0.25));
	}
	
	/**
	 * Moves the robot reverse depending on the speed of the motor.
	 * 
	 * Parameter RANGE [-100, 100].
	 * 
	 * @param robotSpeed : Speed of the motors.
	 */
	public static void buttonMoveReverse(int robotSpeed) {
		
		RobotVideoOutput.getRobot().move( -robotSpeed, -robotSpeed);
	}
}
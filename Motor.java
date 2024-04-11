/**
 * 	 NOTE:
 * 
 * 		+ PACKAGE_NAME_FORMAT: "com.companyName.author.nameOfGroupedCode".
 * 
 *		+ COPIED FROM 'https://www.commonwealthu.brightSpace.com'.
 *
 * 		+ INCLUDED IN 'com.commonwealthu.phuegler.RobotAPI' PACKAGE.
 * 
 * 		+ JAVADOCS FOR IMPLEMENTATION LOCALLY REFERENCED IN:
 * 				PATH_IN_PROJECT: CMSC130_Project1_RobotGUI/javadoc
 * 
 * 		+ INCLUDED IN PROJECT, WITH PERMISSION:
 * 				ORIGINAL_AUTHOR: Dr. Peter Heugler
 */


// Package contains robot code not written by me.
package com.commonwealthu.phuegler.RobotAPI;

// Library includes pigioj, which is needed to control the motor.
import uk.pigpioj.PigpioConstants;
import uk.pigpioj.PigpioInterface;

/**
 * Implementation and API to control a robot motor.
 */
public class Motor {

	// Final speed constant.
	static final int MAX_SPEED = 100;

	// Instance variable for connection to the robot.
	private PigpioInterface connection;
	
	// GPIO pin definitions.
	private int gpioForward;
	private int gpioBackward;
	private int gpioSpeed;

	/**
	 * Construct an instance to control a motor.
	 * 
	 * @param connection   : pigpiod connection to the robot.
	 * @param gpioForward  : GPIO pin number to used to move forward.
	 * @param gpioBackward : GPIO pin number to used to move backward.
	 * @param gpioSpeed    : GPIO pin number used to set the speed.
	 */
	public Motor(PigpioInterface connection, int gpioForward, int gpioBackward, int gpioSpeed) {

		// Set the instance variables.
		this.connection   = connection;
		this.gpioForward  = gpioForward;
		this.gpioBackward = gpioBackward;
		this.gpioSpeed    = gpioSpeed;

		// Set up the forward and backward pins.
		this.connection.setMode(this.gpioForward, PigpioConstants.MODE_PI_OUTPUT);
		this.connection.setMode(this.gpioBackward, PigpioConstants.MODE_PI_OUTPUT);

		// Set up the speed with PWM && the range of 'gpioSpeed' is [0, 100].
		this.connection.setMode(this.gpioSpeed, PigpioConstants.MODE_PI_OUTPUT);
		this.connection.setPWMRange(this.gpioSpeed, Motor.MAX_SPEED);

		// Make sure the motor is off.
		this.stop();

	}

	/**
	 * Stops the motor by writing false to GPIO pins.
	 */
	public void stop() {

		// Stop all motor movement.
		this.connection.write(this.gpioForward, false);
		this.connection.write(this.gpioBackward, false);
	}

	/**
	 * Move the motor forward at the given speed.
	 * 
	 * @param speed : Motor speed range of (0-100).
	 */
	public void forward(int speed) {

		// Checks for a valid speed within range.
		if ((speed < 0) || (speed > Motor.MAX_SPEED)) {
			
			this.stop();
			throw new RuntimeException("Invalid speed requested: " + speed);
		}

		// Set the motor to move forward.
		this.connection.write(this.gpioForward, true);
		this.connection.write(this.gpioBackward, false);
		this.connection.setPWMDutyCycle(this.gpioSpeed, speed);

	}

	/**
	 * Move the motor backward at the given speed.
	 * 
	 * @param speed : Motor speed range of (0-100).
	 */
	public void backward(int speed) {

		// Check for a valid speed within range.
		if ((speed < 0) || (speed > Motor.MAX_SPEED)) {
			
			this.stop();
			throw new RuntimeException("Invalid speed requested: " + speed);
		}

		// Set the motor to move forward.
		this.connection.write(this.gpioForward, false);
		this.connection.write(this.gpioBackward, true);
		this.connection.setPWMDutyCycle(this.gpioSpeed, speed);
	}

}

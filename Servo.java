/**
 * 	 NOTE:
 * 
 * 		+ PACKAGE_NAME_FORMAT: "com.companyName.author.nameOfGroupedCode"
 * 
 *		+ COPIED FROM 'https://www.commonwealthu.brightSpace.com'.
 *
 * 		+ INCLUDED IN 'com.commonwealthu.phuegler.RobotAPI' PACKAGE.
 * 
 * 		+ JAVADOCS FOR implementation/API LOCALLY REFERENCED IN:
 * 				PATH_IN_PROJECT: CMSC130_Project1_RobotGUI/javadoc
 * 
 * 		+ INCLUDED IN PROJECT, WITH PERMISSION:
 * 				ORIGINAL_AUTHOR: Dr. Peter Heugler
 */


// Package contains robot code not written by me.
package com.commonwealthu.phuegler.RobotAPI;

// Library import needed to connect to the robot.
import uk.pigpioj.PigpioConstants;
import uk.pigpioj.PigpioInterface;

/**
 * Implementation and API to control a servo.
 * 
 * @author phuegler@commonwealthu.edu
 */
public class Servo {
	
	// Final speed constants.
	static final int MIN_POSITION = 500;
	static final int MAX_POSITION = 2500;
	
	// Global instance variable for connection to the robot.
	private PigpioInterface connection;
	
	// GPIO pin definitions.
	private int gpioServo;
	
	
	/**
	 * Constructs an instance to control a servo.
	 * 
	 * @param  connection : pigpiod connection to the robot.
	 * @param  gpioServo  : GPIO used for the servo.
	 * @throws InterruptedException : This comes from using 'Thread.sleep'.
	 */
	public Servo( PigpioInterface connection, int gpioServo ) throws InterruptedException {
		
		// Set the instance variables.
		this.connection = connection;
		this.gpioServo = gpioServo;
		
		// Set up the GPIO pin.
		this.connection.setMode( this.gpioServo, PigpioConstants.MODE_PI_OUTPUT );
		
		// Move to middle and turn it off.
		this.home();
		this.off();
	}
	
	/**
	 * Move the servo to a specific position.
	 * 
	 * @param position : Position value ranges from 500 to 2500.
	 * @throws InterruptedException : This comes from using 'Thread.sleep'.
	 */
	public void move(int position) throws InterruptedException {
		
		// Checks for a valid position.
		if (( position !=0 ) && (( position < Servo.MIN_POSITION ) || (position > Servo.MAX_POSITION ))) {
			
			this.off();
			throw new RuntimeException( "Invalid servo position requested: " + position );
		}
			
		// Sets the valid position.
		this.connection.setServoPulseWidth( this.gpioServo, position );
		
		// Give it time to move completely.
		Thread.sleep( 300 );
			
		// Turn off the servo.
		this.off();
		
	}
	
	/**
	 * Move servo to the home (middle) position.
	 * 
	 * @throws InterruptedException : This comes from using 'Thread.sleep'.
	 */
	public void home() throws InterruptedException {
		
		// Sets the position.
		this.connection.setServoPulseWidth(
			this.gpioServo,
			Servo.MIN_POSITION +
			((Servo.MAX_POSITION - Servo.MIN_POSITION) / 2)
		);
		
		// Give it time to get there.
		Thread.sleep( 300 );
		
		// Turn off the servo.
		this.off();		
		
	}
	
	/**
	 * Turn off the servo (won't support weight) !!
	 */
	public void off() {
		
		// Set the pulse width to zero to turn off servo.
		this.connection.setServoPulseWidth( this.gpioServo, 0 );
	}

}
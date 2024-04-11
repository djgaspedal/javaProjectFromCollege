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
 * Implementation and API to control the multicolor LED.
 * 
 * @author phuegler@commonwealthu.edu
 */
public class LED {
	
	// Global color constant.
	static final int MAX_COLOR = 255;
	
	// Instance variables & connection to the robot.
	private PigpioInterface connection;
	
	// Global GPIO pin definitions:
	private int gpioRed;
	private int gpioGreen;
	private int gpioBlue;
	
	/**
	 * Construct an instance to control the LED.
	 * 
	 * @param connection : pigpiod connection to the robot.
	 * @param gpioRed    : GPIO pin used to control red component.
	 * @param gpioGreen  : GPIO pin used to control green component.
	 * @param gpioBlue   : GPIO pin used to control blue component.
	 */
	public LED( PigpioInterface connection, int gpioRed, int gpioGreen, int gpioBlue ) {
		
		// Set the instance variables.
		this.connection = connection;
		this.gpioRed = gpioRed;
		this.gpioGreen = gpioGreen;
		this.gpioBlue = gpioBlue;		
		
		// Set up the pins and use PWM to control the colors.
		this.connection.setMode( this.gpioRed, PigpioConstants.MODE_PI_OUTPUT );
		this.connection.setPWMRange(this.gpioRed, LED.MAX_COLOR );	
		this.connection.setMode( this.gpioGreen, PigpioConstants.MODE_PI_OUTPUT );
		this.connection.setPWMRange(this.gpioGreen, LED.MAX_COLOR );	
		this.connection.setMode( this.gpioBlue, PigpioConstants.MODE_PI_OUTPUT );
		this.connection.setPWMRange(this.gpioBlue, LED.MAX_COLOR );
		
		// Turn off LEDs.
		this.off();
		
	}	
	
	/**
	 * Turns off the LED by setting color to RGB(0, 0, 0) [Black].
	 */
	public void off( ) {
		
		this.setColor( 0,  0,  0 );
	}
	
	/**
	 * Sets the color of the LED using RGB colors.
	 * 
	 * @param red   : Red component.
	 * @param green : Green component.
	 * @param blue  : Blue component.
	 */
	public void setColor( int red, int green, int blue ) {
		
		// Checks for valid colors.
		if (( red < 0 ) || ( red > LED.MAX_COLOR )) {
			
			this.off();
			throw new RuntimeException( "ERROR: Invalid red color value: " + red );
		}
		
		if (( green < 0 ) || ( green > LED.MAX_COLOR )) {
			
			this.off();
			throw new RuntimeException( "ERROR: Invalid green color value: " + green );
		}
		
		if (( blue < 0 ) || ( blue > LED.MAX_COLOR )) {
			
			this.off();
			throw new RuntimeException( "ERROR: Invalid blue color value: " + blue );
		}
		
		// Finally, set the colors.
		this.connection.setPWMDutyCycle( gpioRed, red );
		this.connection.setPWMDutyCycle( gpioGreen, green );
		this.connection.setPWMDutyCycle( gpioBlue, blue );
		
	}

}
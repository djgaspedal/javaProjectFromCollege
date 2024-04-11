/**
 *   NOTE:
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
 * 				ORIGINAL_AUTHOR: Dr. PeterPhuegler
 * 
 * @author phuegler@commonwealthu.edu
 */


// Library import && package needed to connect to the robot.
package com.commonwealthu.phuegler.RobotAPI;

import java.util.ArrayList;

import uk.pigpioj.PigpioInterface;
import uk.pigpioj.PigpioJ;

/**
 * API and implementation to control the various parts of the robot.
 * 	 getLEDColor() is a method I added to get the LED colors via ArrayList.
 */
public class Robot {

	// Private global interface for connection to the robot.
	private PigpioInterface connection;
	
	// [2] Motors.
	private Motor motorLeft;
	private Motor motorRight;
	
	// [3] Servos.
	private Servo servoLED;
	private Servo servoVCamera;
	private Servo servoHCamera;
	
	// [1] LED.
	private LED led;
	
	// [1] ArrayList for LED values.
	private ArrayList<Integer> a;
	
    /**
	 * Default constructor. Sets up the connection and creates instances of the robot parts.
	 * 
	 * @throws InterruptedException : This comes from using 'Thread.sleep'.
	 */
	public Robot() throws InterruptedException {
	
		// Connect to the robot.
		this.connection = PigpioJ.autoDetectedImplementation();
		
		// Create/assign the motors.
		this.motorLeft = new Motor(connection, 20, 21, 16);
		this.motorRight = new Motor(connection, 19, 26, 13);
		
		// Create/assign the servos.
		this.servoLED = new Servo(connection, 23);
		this.servoVCamera = new Servo(connection, 9);
		this.servoHCamera = new Servo(connection, 11);
		
		// Create/assign the led.
		this.led = new LED( connection, 22, 27, 24 );
	
		
	}
	
	/**
	 * Shutdown the robot. Stops the motors, servos, and led. 
	 * 	  Closes the connection to the robot.
	 * 
	 * @throws InterruptedException : Origin from using 'Thread.sleep'.
	 */
	public void close() throws InterruptedException {
	
		// Turns everything off.
		this.motorLeft.stop();
		this.motorRight.stop();
		this.servoLED.off();
		this.servoVCamera.off();
		this.servoHCamera.off();
		this.led.off();
	
		// Close the connection.
		this.connection.close();
	
	}
	
	/**
	 * Get the URL for the robot camera.
	 * 
	 * @return String object : The URL for the camera.
	 */
	public String getCameraURL() {
		
		return "rtsp://192.168.99.9:8554/cam";
	}
	
	/**
	 * Move the robot. Use negative speeds for backwards.
	 * 
	 * @param speedLeft  : Left motor speed  (-100 -> 100).
	 * @param speedRight : Right motor speed (-100 -> 100).
	 */
	public void move( int speedLeft, int speedRight ) {
	
		// Sets the left motor.
		if ( speedLeft < 0 ) {
			
			this.motorLeft.backward(-speedLeft);
			
		} else {
			
			this.motorLeft.forward(speedLeft);
			
		}
	
		// Sets the right motor.
		if ( speedRight < 0 ) {
			
			this.motorRight.backward(-speedRight);
			
		} else {
			
			this.motorRight.forward(speedRight);
			
		}
	
	}
	
	/**
	 * Stops the robot from moving.
	 */
	public void stop() {
	
		// Stop the motors.
		motorLeft.stop();
		motorRight.stop();
	
	}
	
	/**
	 * Move the camera to a set position.
	 * 
	 * @param  hPosition : Position of the horizontal .
	 * @param  vPosition : Position of the vertical servo.
	 * @throws InterruptedException : This comes from using 'Thread.sleep'.
	 */
	public void moveCamera( int hPosition, int vPosition ) throws InterruptedException {
	
		// Set the positions of the servos.
		this.servoHCamera.move(hPosition);
		this.servoVCamera.move(vPosition);
	
	}
	
	/**
	 * Move the camera to its home position.
	 * 
	 * @throws InterruptedException : This comes from using 'Thread.sleep'.
	 */
	public void moveCameraHome() throws InterruptedException {
	
		// Move the servos home.
		this.servoHCamera.home();
		this.servoVCamera.home();
	
	}
	
	/**
	 * Move the led to a position.
	 * 
	 * @param  position : Position of the servo
	 * @throws InterruptedException : This comes from using 'Thread.sleep'.
	 */
	public void moveLED(int position) throws InterruptedException {
	
		// Move the led servo.
		this.servoLED.move( position );
	
	}
	
	/**
	 * Move the led to its home position.
	 * 
	 * @throws InterruptedException : This comes from using 'Thread.sleep'.
	 */
	public void moveLEDHome() throws InterruptedException {
	
		// Move the led servo to its home position.
		this.servoLED.home();
	
	}
	
	/**
	 * Set the LED color using RGB.
	 * 
	 * @param red   : Red LED component value.
	 * @param green : Green LED component value.
	 * @param blue  : Blue LED component value.
	 */
	public void setLEDColor( int red, int green, int blue ) {
	
		// Set the led color.
		this.led.setColor( red, green, blue);
	}
	
	/**
	 * Get the LED color using RGB. Added as an extra method.
	 * 
	 * @return : ArrayList of LED values from 0 to 255.
	 */
	public ArrayList<Integer> getLEDColor() { // (0,0,0) to (255,255,255)
		
		// Initialize an ArrayList, clear it before new values added.
		a = new ArrayList<Integer>();
		a.clear();
		
		// RGB GPIO: 22, 27, 24
		a.add(Integer.valueOf(this.connection.getPWMDutyCycle( 22)));
		a.add(Integer.valueOf(this.connection.getPWMDutyCycle( 27)));
		a.add(Integer.valueOf(this.connection.getPWMDutyCycle( 24)));
		
		return a;
	}
	
}
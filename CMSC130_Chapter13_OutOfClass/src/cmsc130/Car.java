/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

// Imports the interfaces needed in class "VehicleFunction".
import cmsc130.VehicleFunction.VehicleFunctions;
import cmsc130.VehicleFunction.AirConditioning;
import cmsc130.VehicleFunction.CruiseControl;

/**
 * Public class that does the following:
 * 		
 * 		Implements the 'VehicleFunctions', 'CruiseControl', 'AirConditioning' interfaces located in the 'VehicleFunction' class.
 * 				-(Overridden functions are abstract by default)
 * 		Has getter/setters for the name of the Car.
 * 		Includes over-rided 'toString()'.
 */
public class Car implements VehicleFunctions,
							AirConditioning,
							CruiseControl	{

	
	// Instance variable for the name of the 'Car' object.
	private String nameOfCar;
	
	/**
	 * Overloaded constructor.
	 * @param The name of the 'Car' object.
	 */
	public Car(String nameOfCar) {
		
		this.setNameOfCar(nameOfCar);
	}

	/**
	 * Sets the cruise control. Over-ridden from 'CruiseControl' interface.
	 * @param Speed of the car being displayed.
	 */
	@Override
	public void setSpeed(int speedOfCar) {
		
		System.out.println("The Car's speed is set to: " + speedOfCar + ".");
	}
	
	/**
	 * Cancels the cruise control. Over-ridden from 'CruiseControl' interface.
	 */
	@Override
	public void cancel() {
		
		System.out.println("The cruise control is set off.");
	}
	
	/**
	 * Turns on the Air-Conditioning. Over-ridden from 'AirConditioning' interface.
	 */
	@Override
	public void acOn() {
		
		System.out.println("The A/C is turned on.");
	}
	
	/**
	 * Turns off the Air-Conditioning. Over-ridden from 'AirConditioning' interface.
	 */
	@Override
	public void acOff() {
		
		System.out.println("The A/C is turned off.");
	}
	
	/**
	 * Prints to the console the action the driver takes to achieve acceleration. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void accelerate() {
		
		System.out.println("Pressing gas pedal with foot now.");
	}

	/**
	 * Prints to the console the action the driver takes to achieve slowing down. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void slowDown() {
		
		System.out.println("Pressing brake pedal with foot now.");
	}

	/**
	 * Prints to the console the action the driver takes to achieve a complete stop. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void stop() {
		
		System.out.println(this.nameOfCar + " is now stopped with the brake pedal to the floor.");
	}

	/**
	 * Prints to the console the action the driver takes to achieve a left turn. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void turnLeft() {
		
		System.out.println(this.nameOfCar + " is now turning left with the steering wheel turned left.");
	}

	/**
	 * Prints to the console the action the driver takes to achieve a left turn. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void turnRight() {
		
		System.out.println(this.nameOfCar + " is now turning right with the steering wheel turned right.");
	}

	/**
	 * @return Object data in String format. Over-ridden from 'Object' class.
	 */
	@Override
	public String toString() {
		
		return "Car [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @return The name of the Car.
	 */
	public String getNameOfCar() {
		
		return nameOfCar;
	}

	/**
	 * @param Sets the name of the Car.
	 */
	public void setNameOfCar(String nameOfCar) {
		
		this.nameOfCar = nameOfCar;
	}

}
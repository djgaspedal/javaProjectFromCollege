/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

// Imports the interface needed in class "VehicleFunction".
import cmsc130.VehicleFunction.VehicleFunctions;

/**
 * Public class that does the following:
 * 		
 * 		Implements the 'VehicleFunctions' interface located in the 'VehicleFunction' class.
 * 		Getters/Setters for the name of the 'Bicycle' object.
 * 		Includes over-rided 'toString()'.
 */
public class Bicycle implements VehicleFunctions {

	// Bicycle's name.
	private String nameOfBicycle;
	
	/**
	 * Public constructor for 'Bicycle' object.
	 * @param Bicycle's name.
	 */
	public Bicycle(String nameOfBicycle) {
		
		this.setNameOfBicycle(nameOfBicycle);
	}

	/**
	 * Prints to the console the action the rider takes to achieve acceleration. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void accelerate() {
		
		System.out.println("Pedalling the bicycle faster.");
	}

	/**
	 * Prints to the console the action the rider takes to achieve slowing down. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void slowDown() {
		
		System.out.println("Pedal slower to lower speed and start slowing down.");
	}

	/**
	 * Prints to the console the action the rider takes to achieve stopping. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void stop() {
		
		System.out.println("Feet off the pedals and leaning to one side should stop the bicycle.");
	}

	/**
	 * Prints to the console the action the rider takes to achieve turning left. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void turnLeft() {
		
		System.out.println("Turn bars the left to turn Bicycle left.");
	}

	/**
	 * Prints to the console the action the rider takes to achieve turning right. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void turnRight() {
		
		System.out.println("Turn bars the right to turn Bicycle right.");
	}

	/**
	 * Getter for name.
	 * @return the nameOfBicycle.
	 */
	public String getNameOfBicycle() {
		
		return nameOfBicycle;
	}

	/**
	 * Setter for name.
	 * @param nameOfBicycle the nameOfBicycle to set.
	 */
	public void setNameOfBicycle(String nameOfBicycle) {
		
		this.nameOfBicycle = nameOfBicycle;
	}

	@Override
	public String toString() {
		return "Bicycle [nameOfBicycle=" + nameOfBicycle + ", getNameOfBicycle()=" + getNameOfBicycle()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}


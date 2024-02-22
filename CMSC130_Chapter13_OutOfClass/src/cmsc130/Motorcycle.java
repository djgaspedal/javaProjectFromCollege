/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

// Imports the interface needed in class "VehicleFunction"
import cmsc130.VehicleFunction.VehicleFunctions;
import cmsc130.VehicleFunction.CruiseControl;

/**
 * Public class that does the following:
 * 		
 * 		Implements the 'VehicleFunctions' and 'CruiseControl' interfaces located in the 'VehicleFunction' class.
 * 		Getters/Setters for the brand of the 'Motorcycle' object.
 * 		Includes over-rided 'toString()'.
 */
public class Motorcycle implements VehicleFunctions,
								   CruiseControl  {

	private String brandOfMotorcycle;
	/**
	 * Public constructor for 'Motorcycle' object.
	 * @param The brand of motorcycle needed to create 'Motorcycle' object.
	 */
	public Motorcycle(String brandOfMotorcycle) {
		
		this.setBrandOfMotorcycle(brandOfMotorcycle);
	}

	/**
	 * Sets the cruise control. Over-ridden from 'CruiseControl' interface.
	 * @param Speed of the motorcycle that needs displayed in code-block.
	 */
	@Override
	public void setSpeed(int speedOfMotorcycle) {
		
		System.out.println("The cruise control speed is set to: " + speedOfMotorcycle + ".");
	}
	
	/**
	 * Cancels the cruise control. Over-ridden from 'CruiseControl' interface.
	 */
	@Override
	public void cancel() {
		
		System.out.println("The cruise control is set off.");
	}
	
	/**
	 * Prints to the console the action the driver takes to achieve acceleration. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void accelerate() {
		
		System.out.println("Turning the throttle now and accelerating.");
	}

	/**
	 * Prints to the console the action the driver takes to achieve slowing down. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void slowDown() {
		
		System.out.println("Brake lever is pulled in slowly to slow down.");
	}

	/**
	 * Prints to the console the action the driver takes to achieve a complete stop. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void stop() {
		
		System.out.println(this.brandOfMotorcycle + " is now stopped with the brake lever all the way in.");
	}

	/**
	 * Prints to the console the action the driver takes to achieve a left turn. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void turnLeft() {
		
		System.out.println(this.brandOfMotorcycle + " is now turning left.");
	}

	/**
	 * Prints to the console the action the driver takes to achieve a left turn. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void turnRight() {
		
		System.out.println(this.brandOfMotorcycle + " is now turning right");
	}

	/**
	 * Returns the brand of motorcycle. Getter method.
	 * @return the brand of motorcycle.
	 */
	public String getBrandOfMotorcycle() {
		
		return brandOfMotorcycle;
	}

	/**
	 * Sets the brand of motorcycle.
	 * @param brandOfMotorcycle the brandOfMotorcycle to set.
	 */
	public void setBrandOfMotorcycle(String brandOfMotorcycle) {
		
		this.brandOfMotorcycle = brandOfMotorcycle;
	}

	@Override
	public String toString() {
		return "Motorcycle [brandOfMotorcycle=" + brandOfMotorcycle + ", getBrandOfMotorcycle()="
				+ getBrandOfMotorcycle() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
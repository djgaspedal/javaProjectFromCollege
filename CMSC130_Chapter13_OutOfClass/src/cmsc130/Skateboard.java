/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

//Imports the interface needed in class "VehicleFunction"
import cmsc130.VehicleFunction.VehicleFunctions;

/**
 * Public class that does the following:
 * 		
 * 		Implements the 'VehicleFunctions' interface located in the 'VehicleFunction' class.
 * 		Getters/Setters for the name of the 'Skateboard' object.
 * 		Includes over-rided 'toString()'.
 */
public class Skateboard implements VehicleFunctions{

	// Instance variable for the name of the skateboard.
	private String skateboard;
	
	/**
	 * Default constructor.
	 * @param skateboard name.
	 */
	public Skateboard(String skateboard) {
		
		this.setSkateboard(skateboard);
	}

	/**
	 * Prints to the console the action the skater takes to achieve acceleration. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void accelerate() {
		
		System.out.println("Push foot off board harder and faster to speed up.");
	}

	/**
	 * Prints to the console the action the skater takes to achieve slowing down. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void slowDown() {
		
		System.out.println("Put foot out to create friction to start slowing down.");
	}

	/**
	 * Prints to the console the action the skater takes to achieve stopping. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void stop() {
		
		System.out.println("Keep balance and push foot on ground until you stop fully.");
	}

	/**
	 * Prints to the console the action the skater takes to achieve turning left. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void turnLeft() {
		
		System.out.println("Lean to the left to start curving left.");
	}

	/**
	 * Prints to the console the action the skater takes to achieve turning right. Over-ridden from 'VehicleFunctions' interface.
	 */
	@Override
	public void turnRight() {
		
		System.out.println("Lean to the right to start curving right.");
	}

	/**
	 * Getter for name of skateboard.
	 * @return the skateboard name.
	 */
	public String getSkateboard() {
		
		return skateboard;
	}

	/**
	 * Setter for name of skateboard.
	 * @param skateboard name is being set.
	 */
	public void setSkateboard(String skateboard) {
		
		this.skateboard = skateboard;
	}

	@Override
	public String toString() {
		return "Skateboard [skateboard=" + skateboard + ", getSkateboard()=" + getSkateboard() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}


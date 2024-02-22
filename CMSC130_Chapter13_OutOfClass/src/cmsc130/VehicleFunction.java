/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

/**
 * Public class that does the following:
 * 		
 * 		Has three interfaces used by some or all the other classes.
 * 				All four vehicles use the VehicleFunctions interface.
 * 				Car and Motorcycle use the CruiseControl interface.
 * 				Car uses just the AirConditioning interface.
 */
public class VehicleFunction {
	
	/**
	 * Interface used by all four other classes except App.
	 */
	public interface VehicleFunctions {
		
		// These methods will be implemented in each of the four current classes.
		public void accelerate();
		public void slowDown();
		public void stop();
		public void turnLeft();
		public void turnRight();
	}
	
	/**
	 * Interface used by Car class.
	 */
	public interface AirConditioning {
		
		// Needed to turn on the A/C for the 'Car' class.
		public void acOn();
		
		// Needed to turn off the A/C for the 'Car' class.
		public void acOff();
	}
	
	/**
	 * Interface used by Car and Motorcycle classes.
	 */
	public interface CruiseControl {
		
		// Sets speed of cruise control. Implemented in other classes.
		public void setSpeed(int speedOfVehicle);
		
		// Cancels speed of cruise control. Implemented in other classes.
		public void cancel();
	}
}
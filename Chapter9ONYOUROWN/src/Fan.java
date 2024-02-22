// Class that creates a Fan object with constants denoting:
// 								   - Fan-speed [speed]
// 								   - On/off state [on]
//					               - Radius of instantiated Fan object [radius]
//						           - Color of instantiated Fan object [color]	


public class Fan {

	// Three constants that denote the fan-speed
	public static int SLOW = 1;
	public static int MEDIUM = 2;
	public static int FAST = 3;
	
	// Five data fields that describe created 'Fan' objects
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String color = "blue";
	private String name = "Fan";
	
	// No-Argument constructor for a 'Fan' object
	public Fan() {
			
	}
	
	// Constructor that gives a name to the 'Fan' object
	public Fan(String name) {
		this.name = name;
	}
	
	// Accessor method that returns the name of a 'Fan' object
	public String getName() {
		return this.name;
	}
	
	// Accessor method that returns the speed of a 'Fan' object
	public int getSpeed() {
		return speed;
	}

	// Mutator method for the fan-speed
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// Accessor method for the On/Off state
	public boolean isOn() {
		return this.on;
	}

	// Mutator method for On/Off state
	public void setOn(boolean on) {
		this.on = on;
	}

	// Accessor method for the radius of a 'Fan' object
	public double getRadius() {
		return radius;
	}

	// Mutator method for the radius of a 'Fan' object
	public void setRadius(double radius) {
		this.radius = radius;
	}

	// Accessor method for color of a 'Fan' object
	public String getColor() {
		return color;
	}

	// Mutator method for color of a 'Fan' object
	public void setColor(String color) {
		this.color = color;
	}
	
	// toString method that returns speed, radius, and color if state of 'Fan' object in On
	// Also, returns radius && color, only if state of 'Fan' object is Off
	@Override
	public String toString() {
		if(this.on == true) {
			System.out.println();
			return  this.getName() + " [speed = " + this.getSpeed() + ", radius = " + radius + ", color = " + color + "]";
		} else {
			System.out.println();
			return this.getName() + " [radius = " + radius + ", color = " + color + "]" + " NOTE: FAN IS NOT ON.";
		}
	}
	
}
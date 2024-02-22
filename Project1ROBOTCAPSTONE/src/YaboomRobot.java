import uk.pigpioj.*;

// Class that creates:
//			- Instantiations of:
// 				+ Servo, LEDInterface, LineSensor
//			- PigpioInterface 'yaboomInterface'
public class YaboomRobot {

	private PigpioInterface yaboomInterface;
	private Servo lm; 
	private Servo rm;
	private Servo distSensor;
	private Servo camera;
	private LEDInterface led;
	private LineSensor ls;
	
	// Constructor of the YaboomRobot class
	// Creates interface used by all other instantiations
	public YaboomRobot() {
		
		this.yaboomInterface = PigpioJ.autoDetectedImplementation();
		
		this.lm = new Servo(this.yaboomInterface,"leftMotor");  // Left  motor given the interface
		this.rm = new Servo(this.yaboomInterface,"rightMotor"); // Right motor given the interface
		
		this.led = new LEDInterface(this.yaboomInterface);
		this.distSensor = new Servo(this.yaboomInterface, "distanceSensor");
		this.camera = new Servo(this.yaboomInterface, "camera");
		this.ls = new LineSensor(this.yaboomInterface, lm, rm, led);
	}
	
	// Demo for PROJ #2
	public void lineSensing() throws InterruptedException {
		
		ls.senseALine(25);
	}
	
	// Demo for PROJ #1
	public void spiral() {
		
		final int base = 15;
		
		for(int speed = base + 20; speed <= 100; speed += 20) {
			
			this.led.rgbLedWriter(255, 0 , 0);	
			
			moveDistanceSensor(speed);
			
			this.rm.moveForward(speed);
			this.lm.moveForward(base);
			
			if(speed == base + 20) {
				
				continue;
			}
			
			if(speed == 75) { // 3rd iteration
				
				this.led.rgbLedWriter(0, 255, 0);
				
				this.rm.moveForward(75);
				this.lm.moveForward(15);
				moveCamera(0, 180);
				
				spiralTimeController(4000);
				moveCamera(180, 180);
			}
			
			if(speed == 95) {
				
				this.led.rgbLedWriter(0, 0, 255);
				
				moveCamera(0, 0);
				moveDistanceSensor(180);
				
				this.rm.moveForward(95);
				this.lm.moveForward(15);
				spiralTimeController(3000);
				moveCamera(45, 45);
				
				continue;
			}
			
			spiralTimeController(1500);
			
		}
			
		this.lm.stopMotor();
		this.rm.stopMotor();
		
		moveCamera(180, 0);
		moveDistanceSensor(45);
		
		this.led.rgbLedWriter(111, 0, 151);
		
		endOfSpiral();
		
		moveCamera(180, 180);
		moveDistanceSensor(90);
		
	}
	// Separate method to wait for the robot's position in the above 'Spiral()' method
	private void spiralTimeController(int timeCycle) {
		
		try {
			Thread.sleep(timeCycle); // in milliseconds
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	private void endOfSpiral() {

		this.rm.moveForward(100);
		this.lm.moveReverse(100);
		
		moveDistanceSensor(0);
			
		spiralTimeController(1800);
		
		this.rm.stopMotor();
		this.lm.stopMotor();
		
		moveDistanceSensor(180);
	}
	
	// Moves the distanceSensor servo separately from other instantiated SERVOS
	private void moveDistanceSensor(int degrees) {
		
		if( (degrees > 180)||(degrees < 0) ){
			
			System.out.println("ERROR WITH DEGREES: less than 0 or more than 180!!!");
			throw new ArithmeticException("ERROR WITH DEGREES");
			
		} else {
			
			this.distSensor.moveHorizontal(degrees, "distanceSensor");
		}
	}
	
	// Inputs the horizontal and vertical degree values and moves the Servo to these specific inputs
	private void moveCamera(int horizontalDegrees, int verticalDegrees) {
		
		if( ((horizontalDegrees) > 180) || ((verticalDegrees) > 180) || ((horizontalDegrees) < 0) || ((verticalDegrees) < 0) ){
			
			System.out.println("ERROR WITH DEGREES: less than 0 or more than 180!!!");
			throw new ArithmeticException("ERROR WITH DEGREES");
			
		} else {
			
			camera.moveHorizontal(horizontalDegrees, "camera");
			camera.moveVertical(verticalDegrees);
			
		}
	}
	
	// Closes the interface so code cannot be ran after this is invoked
	public void close() {
		
		this.yaboomInterface.close();
	}
	
}
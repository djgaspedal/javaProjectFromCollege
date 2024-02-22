import uk.pigpioj.*;

// Creates a servo object that the LeftMotor, RightMotor, DistanceSensor, and CameraServo uses
public class Servo{

	// Motor GPIO pins used [dual motor]:
	private int gpio_forward; //left == 20, right == 19
	private int gpio_backward; //left == 21, right == 26
	private int gpio_speed; //left == 16, right == 13
	
	// Camera GPIO pins used:
	private int gpio_horizontal;
	private int gpio_vertical = 9;
	
	// SERVO pin for the Distance Sensor
	private final int gpio_servo_distSensor = 23;
	
	// Creates an interface that the rearLeftMotor uses
	private PigpioInterface servo;
	
	// This Constructor Creates:
	//			- The 'Servo' object
	// 			- Methods are used in the separate 'YaboomRobot' class
	public Servo(PigpioInterface sLOR, String servoType) {
		
		// Assign the declared PigpioInterface 
		// 		to the parameter's value: [autoDetectedImpl. from YaboomRobot]
		this.servo = sLOR; // sLOR: "SERVO"
		
		// Allows for multi-functionality depending on the servoType's String value
		switch (servoType) {
		
			case "leftMotor":
				
				gpio_forward = 20;
				gpio_backward = 21;
				gpio_speed = 16;
				
				sLOR.setMode(gpio_forward, PigpioConstants.MODE_PI_OUTPUT);
				sLOR.setMode(gpio_backward, PigpioConstants.MODE_PI_OUTPUT);
				sLOR.setMode(gpio_speed, PigpioConstants.MODE_PI_OUTPUT );
				sLOR.setPWMRange(gpio_speed, 100);
				
				stopMotor();
				
				break;
				
			case "rightMotor":
				
				gpio_forward = 19;
				gpio_backward = 26;
				gpio_speed = 13;
				
				sLOR.setMode(gpio_speed, PigpioConstants.MODE_PI_OUTPUT );
				sLOR.setMode(gpio_forward, PigpioConstants.MODE_PI_OUTPUT);
				sLOR.setMode(gpio_backward, PigpioConstants.MODE_PI_OUTPUT);
				sLOR.setPWMRange(gpio_speed, 100);
				
				stopMotor();
				
				
				break;
				
			case "camera":
				
				sLOR.setMode(gpio_horizontal, PigpioConstants.MODE_PI_OUTPUT);
				sLOR.setMode(gpio_vertical, PigpioConstants.MODE_PI_OUTPUT);
				
				
				break;
			
			case "distanceSensor":
				
				sLOR.setMode(gpio_servo_distSensor, PigpioConstants.MODE_PI_OUTPUT);
				
				break;
			
			default:
				
				System.out.println("INVALID INSTANTIONS IN YABOOMROBOT CLASS");
				break;
		}
	}
	
	/*
	 * Methods For the Motors
	 */
	
	// Forwards the motor by writing 'true' to gpio_forward
	public void moveForward(int speedValue) { // time in  seconds, seconds  or millis
		
		servo.setPWMDutyCycle(gpio_speed, speedValue);
		servo.write(gpio_forward, true);
	}
	
	// Reverses the motor by writing 'true' to gpio_backward
	public void moveReverse(int speedValue) {
		
		servo.setPWMDutyCycle(gpio_speed, speedValue);
		servo.write(gpio_backward, true);
	}
	
	// Stops the motor by writing 'false' to gpio_forward
	public void stopMotor() {
		
		servo.write(gpio_forward, false );
		servo.write(gpio_backward, false );
	}
	
	/*
	 * Methods For Camera/Distance Sensor
	 */
	
	// @throws ArithmeticException if degrees are out of range 180° -> 0°
	public void moveVertical(int degreesVert) {
		
		if((degreesVert < 0)||(degreesVert > 180)) {
			
			System.out.println("ERROR WITH CAMERA DEGREES: less than 0 or more than 180!!!");
			throw new ArithmeticException("ERROR WITH CAMERA DEGREES");
			
		} else {
			
			int degreesToServoPos = (2000 / 180) * degreesVert;
			this.servo.setServoPulseWidth(gpio_vertical, (2500 - ((int)degreesToServoPos)));
			
			waitForServoPosition();
			this.servo.setServoPulseWidth(gpio_vertical, 0);
		}
	}
	
	// @throws ArithmeticException if degrees are out of range 180° -> 0°
	public void moveHorizontal(int degreesHoriz, String cameraOrDistanceSensor) {
		
		if(cameraOrDistanceSensor == "distanceSensor") {
			
			gpio_horizontal = gpio_servo_distSensor;
			
		} else {
			
			gpio_horizontal = 11;
		}
		
		if((degreesHoriz < 0)||(degreesHoriz > 180)) {
			
			System.out.println("ERROR WITH CAMERA DEGREES: less than 0 or more than 180!!!");
			throw new ArithmeticException("ERROR WITH CAMERA DEGREES");
			
		} else {
			
			int degreesToServoPos = (2000 / 180) * (degreesHoriz);
			
			
			this.servo.setServoPulseWidth(gpio_horizontal, (2500 - ((int)degreesToServoPos)));
			
			waitForServoPosition();
			this.servo.setServoPulseWidth(gpio_horizontal, 0);
		}
	}
	
	// Waits for the servo and allows for the servo to move until a new command gets run
	public void waitForServoPosition() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
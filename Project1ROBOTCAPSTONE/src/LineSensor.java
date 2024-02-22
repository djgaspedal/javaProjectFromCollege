import uk.pigpioj.*;

// Class that creates:
// 			- LineSensor/The bulk of the 'LineSense' demo Project
//			- Temporary Servo variables
//			- 4 different GPIO pins for the line sensor module
public class LineSensor {

	private PigpioInterface yaboomInterface;
	
	// Line tracking GPIO pins
	private final int gpioLeftOuter = 3;
	private final int gpioLeftInner = 5;
	private final int gpioRightOuter = 18;
	private final int gpioRightInner = 4;		
	
	private Servo rm;
	private Servo lm;
	private LEDInterface led;
	
	// Sets to zero by default before instantiation
	private int leftOuter = 0;
	private int leftInner = 0;
	private int rightInner = 0;
	private int rightOuter = 0;
	
	// Parameters are Object Types that get assigned to the local Servo && LEDInterface variables
	public LineSensor(PigpioInterface a, Servo lm, Servo rm, LEDInterface led) {
		
		this.yaboomInterface = a;
		
		// Line sensor inputs
		a.setMode(gpioLeftOuter, PigpioConstants.MODE_PI_INPUT);
		a.setMode(gpioLeftInner, PigpioConstants.MODE_PI_INPUT);
		a.setMode(gpioRightOuter, PigpioConstants.MODE_PI_INPUT);
		a.setMode(gpioRightInner, PigpioConstants.MODE_PI_INPUT);
		
		this.lm = lm;
		this.rm = rm;
		this.led = led;
		
	}
	
	// Method is ran if three adjacent GPIO pins equal 1
	// Turns right and left depending on 'rightOrLeft' parameter
	public void sharpTurn(int speedOfRobotInProgram, String rightOrLeft) throws InterruptedException {
		
		readPins();
		
		rm.moveForward(speedOfRobotInProgram);
		lm.moveForward(speedOfRobotInProgram);
		
		Thread.sleep(350);
		
		// Temporarily stops motors by putting motors in reverse with no delay
		lm.moveReverse(100);
		rm.moveReverse(100);
		
		rm.stopMotor();
		lm.stopMotor();
		
		while(true) {
			
			readPins();
			
			switch(rightOrLeft) {
			
			case "left":
				
				lm.moveReverse(25);
				rm.moveForward(25);
				break;
				
			case "right":
				
				lm.moveForward(25);
				rm.moveReverse(25);
				break;
				
			default:
				System.out.println("invalid: parameter of 'sharpTurn()'. ");
				break;
			}
			
			if((leftInner == 1 || rightInner == 1)) {
				
				rm.stopMotor();
				lm.stopMotor();
				break;
			}
		}
		
		System.out.println("sharpLeftTurnEnd");
	}
	
	public void readPins() {
		
		// Reads the pins:
		// 0 == dark || 1 == light
		leftOuter = this.yaboomInterface.read( gpioLeftOuter );
		leftInner = this.yaboomInterface.read( gpioLeftInner );
		rightInner = this.yaboomInterface.read( gpioRightInner );			
		rightOuter = this.yaboomInterface.read( gpioRightOuter );
	}
	
	public void senseALine(int speedOfRobotInProgram) throws InterruptedException{
		
		System.out.println("LO:LI:RI:RO");
		
		while(true) {
			
			readPins();
			
			// if NOT ON A LINE
			if ((leftOuter == 0)&&(leftInner == 0)&&(rightInner == 0)&&(rightOuter == 0)) {
				readPins();
				
				led.binaryLedWriter("green", true);
				
				lm.stopMotor();
				rm.stopMotor();
				
				System.out.println("notLine");
			}
			
			// Left Turn Checker
			if((leftOuter == 1)&&(leftInner == 1)&&(rightInner == 1)&&(rightOuter == 0)) {
				
				readPins();
				sharpTurn(speedOfRobotInProgram, "left");
			}
			
			// Right Turn Checker
			if((leftOuter == 0)&&(leftInner == 1)&&(rightInner == 1)&&(rightOuter == 1)) {
				
				sharpTurn(speedOfRobotInProgram, "right");
				
			}
			
			// Check For Pins On a Line
			if ((leftInner == 1)&&(rightInner == 1)) {
				readPins();
				
				led.binaryLedWriter("red", true);
				
				rm.moveForward(speedOfRobotInProgram);
				lm.moveForward(speedOfRobotInProgram);
				
				System.out.println("onLine");
			}
			
			// Right Drift Checker
			if ((leftInner == 1)&&(rightInner == 0)&&(leftOuter == 0)&&(rightOuter == 0)) {
				
				readPins();
				
				lm.moveForward(speedOfRobotInProgram);
				rm.moveForward(speedOfRobotInProgram+20);
				
				if( (leftInner == 1) && (leftOuter==0) && (rightInner==0) && (rightOuter ==0) ) {
					
					rm.moveForward(15);
					lm.moveReverse(15);
					
					Thread.sleep(30);
					
					lm.stopMotor();
					rm.stopMotor();
				}
				
				System.out.println("right Drift");
			}
			
			// Left Drift Checker
			if ( (leftInner == 0)&&(rightInner == 1)&&(leftOuter == 0)&&(rightOuter == 0) ) {
				
				readPins();
				
				
				lm.moveForward(speedOfRobotInProgram + 25);
				rm.moveForward(speedOfRobotInProgram);
				
				System.out.println("left Drift");
				
			}
			
			// If outer left is on and others equal 0, make adjustment for middle two to be ON
			if((leftInner == 0)&&(rightInner == 0)&&(leftOuter == 1)&&(rightOuter == 0)) {
				
				do {
	
					readPins();
					rm.moveForward(speedOfRobotInProgram);
					lm.moveReverse(speedOfRobotInProgram);
				} while( (leftInner == 0)&&(rightInner == 0) );
				
				readPins();
				lm.moveForward(speedOfRobotInProgram);
				rm.moveReverse(speedOfRobotInProgram);
			}
			
			// Motor Stop Checker
			if (( leftOuter == 1 ) && ( leftInner == 0 ) && ( rightInner == 0 ) && ( rightOuter == 1 )) {
				
				readPins();
				
				System.out.println( "End Loop" );
				System.out.println("stopMotorCheck");
				
				lm.stopMotor();
				rm.stopMotor();
				
				break;
			}
			
		}
		
	}
	
}
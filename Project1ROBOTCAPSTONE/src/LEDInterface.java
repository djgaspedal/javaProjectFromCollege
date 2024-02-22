import uk.pigpioj.*;

// Creates the 'LEDInterface' object
// Sets Mode/Range in Constructor
public class LEDInterface {
	
		// Color LEDS GPIO pins used
		private final int gpio_red = 22; // 22 is default
		private final int gpio_green = 27; // 27 is default
		private final int gpio_blue = 24; // 24 is default
		
		// Creates an interface that the LEDInterface uses
		private PigpioInterface LEDInterface;
		
		// Constructor sets the 'LEDInterface' to the parameter
		// Sets the Mode/PWMRange of:
		//				- gpio_red, gpio_green, gpio_blue
		public LEDInterface(PigpioInterface pPI) {
			
			this.LEDInterface = pPI;
			
			this.LEDInterface.setMode(gpio_red, PigpioConstants.MODE_PI_OUTPUT);
			this.LEDInterface.setMode(gpio_green, PigpioConstants.MODE_PI_OUTPUT);
			this.LEDInterface.setMode(gpio_blue, PigpioConstants.MODE_PI_OUTPUT);
			
			this.LEDInterface.setPWMRange(gpio_red, 255);
			this.LEDInterface.setPWMRange(gpio_green, 255);
			this.LEDInterface.setPWMRange(gpio_blue, 255);
		}
		
		// Writes a value to the LED (Turns on the LED in front of robot)
		public void binaryLedWriter(String color, boolean onOrOff) {
			
			switch (color) {
				case "red":
					
					LEDInterface.write(gpio_red, onOrOff);
					break;
				case "green":
					
					LEDInterface.write(gpio_green, onOrOff);
					break;
				case "blue": // "blue" is default value in our case
					
					LEDInterface.write(gpio_blue, onOrOff);	
					break;
			}
		}
		
		// Parameters are 0-255 for RGB values
		public void rgbLedWriter(int r, int g, int b) {
			
			LEDInterface.setServoPulseWidth(gpio_red,r);
			LEDInterface.setPWMDutyCycle(gpio_red, r);
			
			LEDInterface.setServoPulseWidth(gpio_green,g);
			LEDInterface.setPWMDutyCycle(gpio_green, g);
			
			LEDInterface.setServoPulseWidth(gpio_blue,b);
			LEDInterface.setPWMDutyCycle(gpio_blue, b);
		}
		
		public void shutOffComplete() {
			
			LEDInterface.close();
		}
		
}
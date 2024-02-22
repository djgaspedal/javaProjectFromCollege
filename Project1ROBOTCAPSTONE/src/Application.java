import java.util.*;

// Public class that runs:
// 			- The Menu
//			- Creates the singular YaboomRobot object
//			- Spiral Demo
//			- Line Tracking Demo
public class Application {
	
	// Scanner object for user input
	// Static so it can be used in static methods
	private static Scanner userChoice = new Scanner(System.in);
	
	// Creates the Robot Object as static to be used in consequent static methods
	static YaboomRobot robot = new YaboomRobot();

	// Main method that runs the menu
	public static void main(String[] args) throws InterruptedException {
		
		// Loops until the user selects exit
		while(true) {
			
			// Displays the menu
			displayMenu();
			
			// Gets the user's choice
			int userChoiceVariable = getUserChoice();
			
			// Processes the choice
			boolean exit = processChoice(userChoiceVariable);
			
			// Checks for an exit and breaks the loop
			if (exit)
				break;
			
		}
		
		// Closes connection && ends program all together
		robot.close();
	}

	// Gets The User's Choice
	private static int getUserChoice() {
		
		// Output the prompt
		System.out.println();
		System.out.print( "Enter a Choice: " );
		
		// Gets the choice
		int choice = userChoice.nextInt();
		
		// Returns the choice
		return choice;

	}

	// Displays The Menu
	private static void displayMenu() {
		
		// Output The Options
		System.out.println();
		System.out.println( "Menu Options:" );
		System.out.println();
		System.out.println( "1. Run Demonstration" );
		System.out.println( "2. Run Line Tracking" );
		System.out.println( "9. Exit Program" );
		
	}
	
	// Processes the choice
	private static boolean processChoice(int choice) throws InterruptedException {
		
		// switch to handle the choice
		switch(choice) {
	
			// Runs The Robot Spiral Demo
			case 1:
				System.out.println();
				System.out.println("Running The Robot Spiral Demo...");
				robot.spiral();
				
				return false;
				
			case 2:
				System.out.println();
				System.out.println("Running the Line Tracking Demo...");
				robot.lineSensing();
				
			// Exits The Program
			case 9:
				return true;
				
			// Handles Bad Parameter Values
			default:
				
				System.out.println();
				System.out.println("ERROR: invalid input");
				return true;
		}
	}
}
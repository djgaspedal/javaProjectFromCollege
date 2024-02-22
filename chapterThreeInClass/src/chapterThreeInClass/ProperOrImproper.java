package chapterThreeInClass;

import java.util.*; //java.util includes Scanner

// Class that determines if the user input is a proper or an improper fraction and if improper, converts to a mixed number
public class ProperOrImproper {

	// Main method that determines if a fraction is improper or proper using Scanner & if-else statements
	public static void main(String[] args) {
		
		// New 'Scanner' object
		Scanner userInput = new Scanner(System.in);
		
		// Assigns numerator value using '.nextInt()'
		System.out.println("Enter a Numerator [Integer Only]: ");
		int numerator = userInput.nextInt();
		
		// Assigns denominator value using '.nextInt()'
		System.out.println("Enter a Denominator [Integer Only]: ");
		int denominator = userInput.nextInt();
		
		// Closes 'Scanner' object to prevent memory leaks/inefficiencies
		userInput.close();
		
		// Prevents dividing by zero by telling user that zero cannot be divided when presented as denominator
		if ( (denominator == 0) || (numerator < 0)) {
			System.out.println("ERROR: DENOMINATOR CANNOT BE ZERO OR NEGATIVE YOU IDIOT!");
			System.exit(1);
		}
		
		// if-else structure to determine if a proper/improper fraction
		if (numerator < denominator) {
			
			System.out.println(numerator + "/" + denominator + " is a proper fraction ");
			
		} else {
			
			System.out.print(numerator + "/" + denominator + " is an improper fraction ");
			
			// Increases readability by assigning these operations to 'wholeNunber' & 'remainder'
			int wholeNumber = numerator / denominator;
			int remainder = numerator % denominator;
			
			// Nested if-else
			if (remainder == 0) {
				
				System.out.println("and it can be reduced to " + wholeNumber);
				
			} else {
				
				// Outputs the form of a mixed fraction using 'wholeNumber' & 'remainder'
				System.out.println( " and it's mixed fraction is " + 
									(wholeNumber) + " + " +
									(remainder) + "/" + denominator);
			}
		}
	}
}
package ch4inclass;

import java.util.*;

// Class that contains a main method requesting user input for a floating point number and outputs using 'printf()' how many digits are to the left of the userInput and the index of the number
public class Digits {
	
	// Main method that asks for user input of a floating point number and outputs the number of digits and the decimal point index
	public static void main(String[] args) {
		
		// New 'Scanner' object initialized
		Scanner userInput = new Scanner( System.in );
		
		// Asks user input for a floating point number
		System.out.print( "Enter a floating point number: " );
		
		// Assigns a double variable 'f' to the userInput
		double f = userInput.nextDouble();
		
		// Closes 'Scanner' object to prevent leaks
		userInput.close();
		
		// 'String' object created and assigns to the value of the userInput from Scanner
		String s = String.valueOf( f );
		
		// Integer assigned to the '.indexOf()' of the decimal in the user's floating point number input
		int indexDecimalPoint = s.indexOf( "." );
		
		// Integer assigned to this previously declared 'indexDecimalPoint'
		int numberOfDigits = indexDecimalPoint;
		
		
		// Creates an accurate representation when input is negative by accounting to the negative sign
		if ( f < 0  ) {
			numberOfDigits--;
		}
		
		// Makes output look nice [not technically needed]
		System.out.println();
		
		// Outputs the user's original input
		System.out.println( "    Original Number: " + f );
		System.out.println( "      String Number: " + s );
		System.out.println( "Decimal Point Index: " + indexDecimalPoint );
		System.out.println( "   Number of Digits: " + numberOfDigits );
		
		// Makes output look nice [not technically needed]
		System.out.println();
		
		// Outputs the intended use of this program
		System.out.printf( "%25s: %25.10f %n", "Orignal Number", f );
		System.out.printf( "%25s: \"%s\" %n", "String Number", s );	
		System.out.printf( "%25s: %25d %n", "Decimal Point Index", indexDecimalPoint );
		System.out.printf( "%25s: %25d %n", "Number of Digits", numberOfDigits );

	}

}


// import util library via wildcard
import java.util.*;

public class DigitCounter {

	public static void main(String[] args) {

		String string = getString(); // new String object to be used in 'count()' method
		
		int [] counts = count( string ); // Array of integers that contain amount of times a digit appears
		
		outputResults( counts ); // Prints to main console
		

	}
	// gets the String via user input and Scanner; returns string object
	public static String getString() {
		
		Scanner userInput = new Scanner( System.in );
		
		System.out.print( "Enter a string of digits: " );
		String string = userInput.next();
		
		userInput.close();
		
		return string;
		
	}
	
	// counts how many times
	public static int[] count( String string ) {
		
		// initializes counts with 10 places [0 - 9]
		int [] counts = new int[10];
		
		// Loops through the string parameters and gets the amount of times a number appears and assigns the string
		for( int i = 0; i < string.length(); i++ ) {
			
			char ch = string.charAt( i );
			
			if ( Character.isDigit(ch) ) {
				
				int digit = Character.getNumericValue(ch);
				
				counts[digit] += 1;
			}
			
		}
		
		// returns 'int[]' array
		return counts;

	}
	
	// Formats output with the number of Digits appearing starting at 0, ending at 9
	public static void outputResults( int [] counts ) {
		
		for(int i = 0; i < counts.length; i++ ) {
			
			if (counts[i] > 0) {
			
				System.out.printf( "Digit %1d occurs %3d", i, counts[i] );
				
				if counts[i] == 1 ) {
					
					System.out.printf(" time%n");
					
				} else {
					
					System.out.printf( " times%n" );
					
				}
			
			}
			
		}
		
	}

}
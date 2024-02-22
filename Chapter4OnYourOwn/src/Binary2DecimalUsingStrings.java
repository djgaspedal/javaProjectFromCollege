import java.util.*; // Wild Card

/*
 *	Class that inputs a users binary number and outputs the decimal equivalent
 *	Contains two separate methods that return a 'boolean' and an 'int'
*/

public class Binary2DecimalUsingStrings {

	// Main method contains a 'Scanner' object and uses the two other methods to calculate a decimal from a 4 digit binary number
	public static void main(String[] args) {
		
		// New 'Scanner' object and assigns the user's input to an int type named 'userBinary'
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a four-digit binary string [no chars]: ");
		
		// Converts user's input that is an int value to a 'String' object
		String userBinaryString = userInput.nextLine();
		
        // Prints the valid binary string for our program
        if ( checkForValidBinaryString(userBinaryString) ) {
        	
        	// Declares a decimal value that is decimal so the '%d' modifier can be used in 'printf()'
            int decValue = binaryToDecimal(userBinaryString);
            
            // 'Printf()' used to make output look nice
            System.out.printf("The decimal value is: %d", decValue);
            
        } else {
        	
            System.out.println("ERROR: Re-enter a four-digit binary number!");
            
        }
        
        userInput.close();
		
	}
	
	// Method to check if the input is a valid binary string for our program and returns a boolean
    public static boolean checkForValidBinaryString(String binaryString) {
    	
    	// '.matches' is a built in String method that returns a boolean
        return binaryString.matches("[01]{4}");
        
    }
    
    // Function to convert a binary string to a decimal value
    public static int binaryToDecimal(String binaryString) {
    	
    	// DecimalValue variable declared outside of for loop
        int decimalValue = 0;
        
        // For loop iterates over 4 positions and calculates final decimal value
        for (int i = 0; i < binaryString.length(); i++) {
        	
            int digit = Character.getNumericValue(binaryString.charAt(i));
            
            int power = (binaryString.length()) - 1 - i;
            
            // Adds and assigns every iteration's value to the 'decimalValue' variable
            decimalValue += digit * Math.pow(2, power);
            
        }
        
        // Return value of an integer
        return decimalValue;
    }

}
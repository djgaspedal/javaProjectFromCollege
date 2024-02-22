package fiftyTwoCardSelection;
import java.util.*;

/* 
 * 4 SUITS: [Heart, Spade, Club, Diamond]
 * 
 * 13 RANKS: [Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King]
 * 
 * NO ARRAYS!!!!! (can use String objects though)
 * 
 * Two methods output 'String' object and main method creates a 'Random' object
 * 
 * Chooses pseudo-random output using 'int suit' and 'int rank' parameters
 * 
 */

public class cardPick { // Class picks a Card Suit/Rank from two different methods that output a Suit/Rank

	// Method that outputs a 'String' object using a switch statement [Suit]
	static String outputRandomCardSuit(int suit) {
		
		// Switch statement that returns the suit based on integer suit parameter
		switch (suit) {
        		case 1:
        			return "Hearts";
        		case 2:
        			return "Diamonds";
        		case 3:
        			return "Clubs";
        		case 4:
        			return "Spades";
        		default:
        			return "Invalid Suit";
		}
	}
	
	// Method that outputs a 'String' object using a switch statement [Rank]
	static String outputRandomCardRank(int rank) {
		
		// Switch statement that returns the rank based on integer 'rank' parameter and ranks 2-10 are handled by '.valueOf(rank)' in default case
		switch (rank) {
	        	case 1:
	        		return "Ace";
	        	case 11:
	        		return "Jack";
	        	case 12:
	        		return "Queen";
	        	case 13:
	        		return "King";
	        	default:
	        		return String.valueOf(rank); // Handles card numbers 2-10 without making specific cases 2 through 10
		}
		
	}
	
	// Main method that contains a Random type object and declares two String objects.
	// 				Two String objects given the return String from both
	// 						'outputRandomCardSuit()' & 'outputRandomCardRank()' methods.
	public static void main(String[] args) {
		
		// Create a 'Random' object to generate random numbers for the suit and rank / instance of 'Random' object
        Random random = new Random();

        // Generate a random number between 1 and 13
        int rank = random.nextInt(13) + 1;

        // Generate a random number between 1 and 4
        int suit = random.nextInt(4) + 1;

        // Gives the suit and rank numbers their respective string names [Mapping of suit/rank]
        String cardSuit = outputRandomCardSuit(suit);
        String cardRank = outputRandomCardRank(rank);
		
        // Prints expected console output required for assignment
		System.out.println("The card is " + cardRank + " of " + cardSuit);
		
	}
}
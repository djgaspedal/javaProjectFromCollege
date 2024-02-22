import java.util.*;
// Class that checks if two strings are anagrams (Can be spelled the same forwards and backwards)
public class Anagram {

	// returns true or false if two strings are anagrams
	public static boolean isAnagram(String s1, String s2) {
		
		// Makes it easier to check if in lowerCase
		s1 = s1.replaceAll("\\s", "").toLowerCase();
	    s2 = s2.replaceAll("\\s", "").toLowerCase();
	    
	    // returns default false if strings are not the same length
	    if (s1.length() != s2.length()) {
	        return false; // Anagrams must have the same length & defaults to false
	    }

	    // Converts Strings to 'char[]' arrays
	    char[] s1Array = s1.toCharArray();
	    char[] s2Array = s2.toCharArray();
	    
	    // Sorts both arrays to 'a-z' 
	    Arrays.sort(s1Array);
	    Arrays.sort(s2Array);
	    
	    // return if both sorted arrays are equivalent to the strings s1 + s2 given as parameters
	    return Arrays.equals(s1Array, s2Array);
	}
		
	// Main method that asks user for anagrams
	public static void main(String[] args) {
		
		// New scanner
		Scanner input = new Scanner(System.in);
        
		// Takes first string
        System.out.print("Enter the first string: ");
        String s1 = input.nextLine();
        
        // Takes second string
        System.out.print("Enter the second string: ");
        String s2 = input.nextLine();
        
        // returns true if anagrams or not
        if (isAnagram(s1, s2)) {
            System.out.printf("%s + %s are anagram", s1, s2);
        } else {
        	System.out.printf("%s + %s are not anagram", s1, s2);
        }
        
        // Scanner object closed
        input.close();

	}
	
}
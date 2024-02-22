/**
 * 
 */
package cmsc130;

import java.util.Scanner;

/**
 * 
 */
public class ApplicationLookup {

	/**
	 * Main method that executes the lookup.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year (2001-2010): ");
        BabyNameLookup.getValidYear(scanner.nextInt());

        System.out.print("Enter the gender (M/F): ");
        //this.genderLookup = getValidGender(scanner);

        System.out.print("Enter the ranking: ");
        //this.rankingLookup = getValidRanking(scanner);
		
		BabyNameLookup bby = new BabyNameLookup(0, 0, 0);
		
	}

}


package chapter5inclass;

import java.util.*;

// Class that determines if a user's three character genome string is valid
public class Gene {
	
	// Main method that includes a scanner and uses do-while loops to determine if letters are valid or not
	public static void main(String[] args) {
		
		// New Scanner object that uses system input
		Scanner userInput = new Scanner(System.in);

		// Declares and sets to true if invalid letter in do-while loop
		boolean errorFlag = false;

		// Declared empty String object to prevent repeated declarations
		String genome;

		do {

			errorFlag = false;

			System.out.println();
			System.out.print("Enter a genome string: ");

			genome = userInput.next();

			for (int i = 0; i < genome.length(); i++) {

				if ("ACTG".indexOf(genome.substring(i, i + 1)) == -1) {

					System.out
							.println("   ERROR: Invalid letter (" + genome.substring(i, i + 1) + ") at position " + i);

					errorFlag = true;
				}
			}

		} while (errorFlag);

		int atg = 0;

		while (true) {

			atg = genome.indexOf("ATG", atg);

			if (atg == -1)
				break;

			atg += 3;

			int tag = genome.indexOf("TAG", atg);
			int taa = genome.indexOf("TAA", atg);
			int tga = genome.indexOf("TGA", atg);

			int endTag = genome.length();
			if (tag != -1 && tag < endTag) {
				endTag = tag;
			}
			if (taa != -1 && taa < endTag) {
				endTag = taa;
			}
			if (tga != -1 && tga < endTag) {
				endTag = tga;
			}

			String gene = genome.substring(atg, endTag);

			System.out.println("  Possible gene: " + gene);

			if (gene.length() % 3 != 0) {
				System.out.println("      Gene not a multiple of 3");
				continue;
			}

			if (gene.indexOf("ATG") != -1 || gene.indexOf("TAG") != -1 || gene.indexOf("TAA") != -1
					|| gene.indexOf("TGA") != -1) {
				System.out.println("      Gene includes ATG, TAG, TAA, or TGA");
				continue;
			}

			System.out.println("     It is a gene");

		}

		// Scanner closed at complete end of program
		userInput.close();
		System.exit(1);
	}

}
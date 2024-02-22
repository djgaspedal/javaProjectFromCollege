/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

import java.io.*;
import java.util.*;
import java.lang.String;

/**
 * Public class that Does The Following:
 * 
 * 		Declares 5 private instance variables for an instantiated 'IntegerFile' object.
 * 		Contains 6 methods used for entering the filename, range, writing data, outputting data, and reading data.
 */
public class IntegerFile {

	// String of filename that will be created
	private String filename;
	
	// integerCount && range are instance variables
	//			denoting number of integers to write to the file
	//					and range of integers that will be generated randomly.
	private int integerCount;
	private int[] range;
	
	// Scanner object used to receive user input.
	private Scanner userInput;
	
	// ArrayList that contains the lower and upper range for integers to be
	//				randomized and printed.
	private ArrayList<Integer> integerList;
	
	// No-arg constructor needed for initialization of an 'IntegerFile' object.
	public IntegerFile() {
		
		this.filename = inputFileName();
		
		this.range = inputRandomRange();
		
		this.integerCount = inputIntegerCount();
	}
	
	/**
	 * This method asks the user to input a filename using 'java.util.Scanner'.
	 * 
	 * @return this.filename as a 'String' object.
	 */
	private String inputFileName() {
		
		userInput = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter The Filename: ");
			
			String fileName =  this.userInput.nextLine();
			
			if( !( fileName.equals("") ) ) {
				this.filename = fileName;
				return fileName;
			}
			
			System.out.println("Error: Enter a filename");
		}
	}
	
	/**
	 * Method that asks for the number of integers.
	 * 		Returns the user's input only if its an integer and positive.
	 * 
	 * @return The number of integers that the user inputs using the 'Scanner.nextInt()' method.
	 */
	private int inputIntegerCount() {
		
		while(true) {
			try {
				System.out.println("Enter Number Of Integers: ");
				integerCount = this.userInput.nextInt();
				
				if(integerCount > 0) {
					// Breaks the while loop by returning the user's input.
					return integerCount;
				}
				System.out.println("Error: enter only positive numbers");
				
			} catch(InputMismatchException ex) {
				
				System.out.println("Error: not an integer...");
				this.userInput.next();
			}
		}
	}
	
	/**
	 * Private method that asks the user for the upper and lower range,
	 * 		checks if lower range is lower than upper range,
	 * 			and lets the user know that the values do not work.
	 * 
	 * @return An array the contains the lower and upper values for the integer generation in 'writeData()'.
	 */
	private int[] inputRandomRange() {
		
		int[] range = {0,0};
		
		while(true) {
			try {
				System.out.println("Enter Lower Range: ");
				range[0] = this.userInput.nextInt();
				
				System.out.println("Enter Upper Range: ");
				range[1] = this.userInput.nextInt();
				
				if(range[0] < range[1]) {
					
					// Returns the array and breaks out of the while loop.
					return range;
				}
				
				System.out.println("Error: Lower Value Higher than Upper Value.");
				
			} catch(InputMismatchException ex) {
				
				System.out.println("Error: not an integer...");
				this.userInput.next();
			}
		}
	}
	
	/**
	 * Writes data using the array containing the upper and lower values that the user inputs.
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeData() throws FileNotFoundException {
		
		File file1 = new File(this.filename);
		
		if( file1.exists() ) {
			
			throw  new RuntimeException("File: " + this.filename + " already exists.");
		}
		
		PrintWriter writer = new PrintWriter( file1 );
		
		for(int a=0; a<this.integerCount; a++) {
			
			Random gen = new Random();
			writer.print(
				(
					gen.nextInt(
						(
							this.range[1] - this.range[0])
							+ 1) + this.range[0]
				) + " "
			);
		}
		
		writer.close();
	}
	
	/**
	 * Reads data by putting data from file object onto an ArrayList.
	 * 
	 * @throws FileNotFoundException
	 */
	public void readData() throws FileNotFoundException {
		
		this.integerList = new ArrayList<Integer>();
		
		File file = new File(this.filename);
		
		Scanner fileIn = new Scanner(file);
		
		while(fileIn.hasNext()) {
			
			int i = fileIn.nextInt();
			integerList.add(i);
		}
		
		fileIn.close();
	}
	
	/**
	 * Prints data that was on the file using an ArrayList named integerList.
	 */
	public void outputData() {
	
		for(Integer i: integerList) {
			System.out.println(i);
		}
	}
}
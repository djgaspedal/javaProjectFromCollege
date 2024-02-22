package cmsc130;

/**
 * CMSC130 First Day; Implementing a Last-In/First-out queue of length '20'
 * 
 * First Assignment of CMSC130
 * 
 * @author gmh80623@lockhaven.edu
 * 
 * DESC: Two classes used in program:
 * 		+Application
 * 			- Used for running following methods:
 * 				ø Queue.empty()
 * 				ø Queue.enqueue()
 * 				ø Queue.toString()
 * 				ø Queue.getSize()
 * 		+Queue
 * 			- Object created and methods done upon object 'j'
 */

public class Application {

	/**
	 * Runs various tests on the 'queue' class
	 * @param args Command-Line Arguments
	 */
	public static void main(String[] args) {
		
		// New queue object named 'j'
		Queue j = new Queue();
		
		// Shows that there is no values in the array before calling 'enqueue()'
		System.out.println("\nSize Of Array: " + j.getSize());
		
		// Enqueue ran for 20 iterations for the 20 values we want to push to the array
		for(int i=0; i<20; i++) {
			
			j.enqueue(i+1);
		}
		
		// Shows that there is 20 values in the array
		System.out.println("\nSize Of Array: " + j.getSize());
		
		// Prints the 'j' object's value using the override-d 'toString()' method
		System.out.println("\n"+j);
		
		// Remove and display the numbers
        while (!j.empty()) {
        	
            System.out.print(j.dequeue() + " ");
        }
	}
}
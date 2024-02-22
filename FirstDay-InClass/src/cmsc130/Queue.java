package cmsc130;
import java.util.*;

/**
 * CMSC130 First Day; Implementing a Last-In/First-out queue of length '20'
 * 
 * First Assignment of CMSC130
 * 
 * @author gmh80623@lockhaven.edu
 */

/**
 *  Public class enqueues and de-queues a list of 20 int(s).
 *  
 *  Four Methods:
 * 		+ enqueue: Adds a number of 'v' INT(s) to an array
 *  	+ dequeue: Returns a selected element in array and then shifts elements
 *  			   		to the left using 'System.arrayCopy'
 *   	+ empty: Returns true if the queue object is empty
 *   	+ getSize: Returns the size of the array
 */
public class Queue {

	@Override
	public String toString() {
		
		return "Queue [elements = " + Arrays.toString(elements) + ", size = " + size + "]";
	}

	// Instance Variables Below:
	private int []elements;
	private int size;
	
	/**
	 * Default constructor that sets the initial size of the elements array to 8
	 */
	public Queue() {
		
		this.elements = new int[8];
	}
	
	/**
	 * DESC: INT(s) 1 -> 20 into array 'elements' 
	 * 
	 * @param v is an INT primitive value being passed for the reason of size for enqueue
	 */
	public void enqueue(int v) {
		
		// Enqueues only the values existing in elements.length to prevent 'outOfBounds index' issue
		if(this.size == this.elements.length) {
			
			// Temporary array set to double the length of the original array 'elements'
			int[] temporary = new int[2 * this.size];
			
			//
			for(int i = 0; i < this.size; i++) {
				
				temporary[i] = this.elements[i];
			}
			
			// ONLY setting the 'temporary' array's values to the 'elements' array's memory location
			// ** DOES NOT CHANGE ACTUAL VALUES IN MEMORY **
			this.elements = temporary;
		}
		
		// Sets the last value of INT 'v' to the 'elements' array
		this.elements[this.size] = v;
		
		// Up the size by one regardless of array size equaling 'elements' array's length
		this.size++;
	}
	
	/**
	 * DESC: Shifts elements to the left and brings down size to zero when 'this.size' == 0
	 * 
	 * @return The selected element in the 'elements' array, starting at 0; if empty, return -1
	 */
	public int dequeue() {
        
		if (this.size != 0) {
			
			// Sets the first removed elements to the first value in the 'elements' array
			// This is done in LIFO [Last In/First Out] fashion
	        int removedElement = elements[0];
	        
	        // Shifts all elements to the left
	        System.arraycopy(elements, 1, elements, 0, size - 1);
	        
	        // CRITICAL: Bring down size by 1 after 'System.arrayCopy'
	        size--;
	        
	        // Returns the selected value after removal using 'System.arrayCopy'
	        return removedElement;
		}
		
		// Return '-1' by default if size == 0
		return -1;
    }
	
	/**
	 * DESC: If size is NOT ZERO, return false as the array is NOT EMPTY
	 * 
	 * @return Returns false if size > 0, true otherwise
	 */
	public boolean empty() {
		
		if(size != 0) {
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * @return Size of the array
	 * 
	 * DESC: Returns the size of the array in a primitive INT
	 */
	public int getSize() {
		
		return this.size;
	}
	
}
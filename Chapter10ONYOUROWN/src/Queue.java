// Class that creates a queue object and has ability to dequeue/enqueue
// Also includes 'isempty()' method to check if the queue is empty
// Also includes getter method for size of the queue
public class Queue {

	// Three private variables that do not need to be displayed to user
	public  int[] elements; // Store INT values in  queue using array
	private int size; // Size of the queue object
	private int capacity; // Capacity of queue object
	
	// No-Arg constructor that sets the queue's capacity to 8
	// Sets the queue size to the value of capacity
	public Queue () {
		
		capacity = 8; // default capacity of 8
        elements = new int[capacity];
	}
	
	// Dequeues by shifting elements to the left; first-in, first-out queue fashion
	public int dequeue() {
        
        int firstElement = elements[0];
        
        // For loop that shifts elements to the left to remove the first element
        for (int i = 0; i < size - 1; i++) {
        	
            elements[i] = elements[i + 1];
        }
        
        // Subtracts size by 1
        size--;
        
        // Returns the first element so user to see it printed in 'QueueMaker' class
        return firstElement;
    }
	
	// Enqueues elements, no return statement
	public void enqueue(int v) {
		
        if (size >= capacity) {
        	
            // If the queue is full, double its capacity
            int[] newElements = new int[capacity * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
            capacity *= 2;
        }
        
        elements[size] = v;
        
        size++;
    }
	
	// Checks if queue is empty
	public boolean isEmpty() {
        return size == 0;
    }

	// Returns size of queue
    public int getSize() {
        return size;
    }
	
}
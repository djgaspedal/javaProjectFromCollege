/**
 * @author gmh80623@lockhaven.edu
 */
package cmsc130;

/**
 * Public class called 'App' That Does the Following:
 * 
 * 		-Creates a new IntergerFile object.
 * 		-Writes data, reads data, outputs data.
 * 		-Handles exceptions when these three methods do not run and return an exception.
 */
public class App {

	/**
	 * Main method that creates a new 'IntegerFIle' object
	 * 		and attempts to write, read, and output data decided by the user.
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) {
		
		// Attempts to write, read, and output data methods ran on 'IntegerFile' object "i".
		try {
			
			IntegerFile i = new IntegerFile();
			
			i.writeData();
			i.readData();
			i.outputData();
			
		} catch (Exception ex) {
			
			System.out.println(
					"Error: " + ex.getMessage()
			);
		}
	}
}
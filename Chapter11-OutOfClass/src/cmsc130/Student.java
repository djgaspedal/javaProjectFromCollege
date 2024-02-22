/**
 * @author gmh80623@lockhaven.edu
 */
package cmsc130;

/**
 * Public class that builds a
 * 'Student' object from the 'Person' constructor in which the class 'Student' inherits from.
 * 		
 * 		Accepts five arguments (nameOfArgument, [type]) :
 * 			name [String],
 * 			address [String],
 * 			phoneNumber [String],
 * 			emailAddress [String],
 * 			classStatus [String]
 */
public class Student extends Person {
	
	// 2D Array used for storing the only 4 available options and is used in place of an ENUM data type.
    public static final String[] CLASS_STATUSES = {"Freshman", "Sophomore", "Junior", "Senior"};
    
    // Instance variable used to hold a String denoting Class Status.
    private String classStatus;

    /**
     @param nameOfPerson String that contains the Name of the Person.
     * @param address String that contains the Address of the Person.
     * @param phoneNumber String that contains the Phone Number of the Person.
     * @param emailAddress String that contains the Email Address of the Person.
     * @param classStatus String that contains the Class Status of the Person.
     */
    public Student(String name, String address, String phoneNumber, String emailAddress, String classStatus) {
        super(name, address, phoneNumber, emailAddress);
        this.classStatus = classStatus;
    }

    /**
     * 'toString()' Method that is used for overriding in the Person class. Adds Class Status to the String.
     */
    @Override
    public String toString() {
        return super.toString() + ", \n     Class Status = " + classStatus;
    }
}


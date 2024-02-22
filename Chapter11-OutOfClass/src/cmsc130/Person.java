/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

/**
 *	Public class used as Parent class to the following classes:
 * 
 * 		{Student, Employee}
 * 
 *	Accepts four arguments (nameOfArgument, [type]) :
 * 		name [String],
 * 		address [String],
 * 		phoneNumber [String],
 * 		emailAddress [String]
 */
public class Person {

	// Four instance variables denoting 4 aspects about such object.
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    /**
     * @param nameOfPerson String that contains the Name of the Person.
     * @param address String that contains the Address of the Person.
     * @param phoneNumber String that contains the Phone Number of the Person.
     * @param emailAddress String that contains the Email Address of the Person.
     */
    public Person(String nameOfPerson, String address, String phoneNumber, String emailAddress) {
    	
        this.name = nameOfPerson;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * 'toString()' Method that is used for overriding in other classes.
     */
    @Override
    public String toString() {
    	
        return " Name = " + name + ",\n  Address = " + address + ", \n   Phone = " + phoneNumber + ", \n    Email = " + emailAddress;
    }
    
}
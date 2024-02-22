/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

/**
 * Public class that builds a
 * 'Staff' object based on the 'Employee' constructor in which the class 'Staff' inherits from.
 * 		
 * 		Accepts eight arguments (nameOfArgument, [type]) :
 * 			name [String],
 * 			address [String],
 * 			phoneNumber [String],
 * 			emailAddress [String],
 * 			office [String],
 * 			salary [double],
 * 			dateHired [String],
 * 			title [String]
 */
public class Staff extends Employee {
	
    private String title;

    public Staff(String name, String address, String phoneNumber, String emailAddress,
    			 String office, double salary, String dateHired, String title) {
    	
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.title = title;
    }
    
    /**
     * @return The 'toString' of an instantiated 'Staff' object and
     * 			adds title to the Employee's returned information.
     */
    @Override
    public String toString() {
        return super.toString() + ", \n        Title = " + title;
    }
}


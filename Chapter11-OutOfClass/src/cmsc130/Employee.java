/**
 * @author gmh80623@lockhaven.edu
 */
package cmsc130;

/**
 * Public class that builds an
 * 'Employee' object based on the 'Person' constructor in which the class 'Employee' inherits from.
 * 		
 * 		Accepts seven arguments (nameOfArgument, [type]) :
 * 			name [String],
 * 			address [String],
 * 			phoneNumber [String],
 * 			emailAddress [String],
 * 			office [String],
 * 			salary [double],
 * 			dateHired [String]
 */
public class Employee extends Person {
	
	private double salary;
	private String office;
    private String dateHired;

    public Employee(String name, String address, String phoneNumber, String emailAddress,
    				String office, double salary, String dateHired) {
        
    	super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    /**
     * @return The 'toString' of an instantiated 'Employee' object and
     * 					adds Office, Salary, and HiringDate to the Person's returned information in String format.
     */
    @Override
    public String toString() {
        
    	return super.toString() + ", \n     Office  " + office + ", \n      Salary = " + salary + ", \n       Date Hired = " + dateHired;
    }
}
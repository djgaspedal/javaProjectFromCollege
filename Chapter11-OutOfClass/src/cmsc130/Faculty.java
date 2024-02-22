/**
 * @author gmh80623@lockhaven.edu
 */
package cmsc130;

/**
 * Public class that builds a
 * 'Faculty' object based on the 'Employee' constructor in which the class 'Faculty' inherits from.
 * 		
 * 		Accepts nine arguments (nameOfArgument, [type]) :
 * 			name [String],
 * 			address [String],
 * 			phoneNumber [String],
 * 			emailAddress [String],
 * 			office [String],
 * 			salary [double],
 * 			dateHired [String],
 * 			officeHours [String],
 * 			rank [String]
 */
public class Faculty extends Employee {
	
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress,
    			   String office, double salary, String dateHired, String officeHours, String rank){
        
    	super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }
    
    /**
     * 'toString()' method that overrides the 'toString()' that exists in the inherited 'Employee' class.
     * 
     * @return The 'toString' of an instantiated 'Faculty' object and
     * 			adds OfficeHours and Rank to the Employee's returned information
     */
    @Override
    public String toString() {
    	
        return super.toString() + ", \n        Office Hours = " + officeHours + ", \n         Rank = " + rank;
    }
}


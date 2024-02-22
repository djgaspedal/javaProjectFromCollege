/**
 * 
 */
package cmsc130;

import java.util.*;

/**
 *  Public class that creates:
 * 		ArrayList; name: "peopleList"
 * 		Person;
 * 		Student;
 * 		Faculty;
 * 		Staff;
 */
public class TestApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create an ArrayList to loop through when printing the information of 4 'instances' or People.
		ArrayList<Person> peopleList = new ArrayList<>();

        // Create instances of People objects, some inherited from Person class [student, faculty, staff]
        Person johnDoe = new Person("John Doe", "300 Main St", "555-1234", "john@lockhavenborough.com");
        Person myMother = new Person("Darice Hampton", "913 Green Grove Rd", "883-4916", "dhampton@svrcs.org");
        
        Student classMate = new Student("Mason Lauche", "300 Main St", "848-5762", "mtl62128@lockhaven.edu", "Freshman");
        Student student = new Student("Garret", "1691 Sheffield Ct", "880-5588", "djgaspedal@gmail.com", "Sophomore");
        
        Faculty pHeugler = new Faculty("Professor Heugler", "570 CompSci St", "484-3996",
        							  "phuegler@commonwealthu.edu", "227 Akeley Hall", 1000000,
        							  "01/01/2009", "T-F 12:20-1:20 PM", "Computer Science Professor");
        Faculty kJohnson = new Faculty("Professor Johnson", "570 Sociology St", "484-2955",
				  					  "kaj2955@commonwealthU.edu", "208 Sloan Hall", 1000000,
				  					  "01/09/2014", "M & W 2:45-4:15 PM", "Sociology Professor");
        
        
        Staff janeJohnson = new Staff("Jane Johnson", "101 Maple St", "570-1122", "foodservices@lockhaven.edu",
        						"103 Bentley", 75000, "01/15/2010", "Administrative Assistant");
        
        Staff bHanna = new Staff("President Hanna", "100 President St", "484-2001", "bhanna@lockhaven.edu",
				"399 Ulmer Hall", 1200000, "07/15/2021", "President of Lock Haven University");

        // Add instances to the ArrayList
        peopleList.add(johnDoe);
        peopleList.add(myMother);
        
        peopleList.add(classMate);
        peopleList.add(student);
        
        peopleList.add(pHeugler);
        peopleList.add(kJohnson);
        
        peopleList.add(janeJohnson);
        peopleList.add(bHanna);
        

        // Outputs information for each instance using a for-each loop.
        for (Person p : peopleList) {
            System.out.println(p);
            System.out.println("-------------------------------------------");
        }
	}

}


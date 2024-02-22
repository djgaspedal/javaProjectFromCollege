/**
 * @author gmh80623@lockhaven.edu
 */
package cmsc130;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class BabyNameLookup {

	/**
	 * Constructor that ...
	 * 
	 * @param 
	 */
	
	// prompt user to enter the year, gender, followed by a ranking, 
	private int yearOfLookup;
	private char genderLookup;
	private int rankingLookup;
	
	/**
	 * 
	 * @param year
	 * @param gender
	 * @param rank
	 */
	public BabyNameLookup() {
		
	}
	/**
	 * 
	 * @return a valid year or a valid ranking
	 */
	public boolean getValidYear(int value, String rankOrYear) {
		
		if(rankOrYear == "rank") {
			if(value>0 && value < 1000) {
				returm
			}
		} else {
			
		}
		
	}
	
	/**
	 * 
	 */
	public void useApplication(BabyNameLookup bnlu) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year (2001-2010): ");
        this.yearOfLookup = getValidYear(scanner.nextInt()); // true or false return

        System.out.print("Enter the gender (M/F): ");
        //this.genderLookup = getValidGender(scanner);

        System.out.print("Enter the ranking: ");
        //this.rankingLookup = getValidRanking(scanner);
        
        
        
	}
	/**
	 * 
	 * @param year
	 * @param gender
	 * @param ranking
	 * @return ArrayList with the gender's specified data [Name and number of babies]
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public ArrayList<String> getFullLookup(int year, char gender, int ranking) throws URISyntaxException, IOException {
		
		ArrayList<String> returnedInfo = new ArrayList<String>();
		
		File webpageToSearch = WebpageToTextFile.mainFileReturn(year);
		
		Scanner scanner = new Scanner(webpageToSearch);
		String line;
		
		String rank;
		String boyName;
		String boyCount;
		String girlName;
		String girlCount;
		
		while(true) {
	        line = scanner.nextLine();
	
	        // Use Scanner with custom delimiter to extract the required strings
	        scanner = new Scanner(line);
	        scanner.useDelimiter("\\s+"); // Matches one or more whitespace characters
	        
	        // Extracting the required strings
	        rank = scanner.next();
	        boyName = scanner.next();
	        boyCount = scanner.next();
	        girlName = scanner.next();
	        girlCount = scanner.next();
	        
	        if( rank == String.valueOf(ranking) ) {
	        	if(gender == 'M') {
	        		returnedInfo.add(boyName);
	        		returnedInfo.add(boyCount);
	        		
	        		break;
	        	} else if(gender == 'F') {
	        		returnedInfo.add(girlName);
	        		returnedInfo.add(girlCount);
	        		
	        		break;
	        	}
	        }
		}
		scanner.close();
		return returnedInfo;
	}
	
	
	
	

}


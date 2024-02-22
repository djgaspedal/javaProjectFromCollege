/**
 * @author gmh80623@lockhaven.edu
 */
package cmsc130;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Class that ...
 */
public class WebpageToTextFile {
    
	/**
	 * MainFileReturn returns a File object with the information needed to search a year, rank, and gender.
	 * 
	 * @param year
	 * @return File object contains the name information and contents line - by - line
	 */
	public static File mainFileReturn(int year){
        try {
            // URL of the page
            URI url = new URI("http://liveexample.pearsoncmg.com/data/babynamesranking"+ year + ".txt");
            URL r = url.toURL();

            // Open a connection to the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(r.openStream()));

            // File to save the content and will be returned
            File rankingsWebpage = new File("rankingswebpage.txt");

            // Writer to write webpage content to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(rankingsWebpage));

            // Read each line from the webpage and write it to the file
            String line;
            while ((line = reader.readLine()) != null) {
            	
                writer.write(line);
                writer.newLine();
            }

            // Close the reader and writer
            reader.close();
            writer.close();

            System.out.println("Webpage content has been saved to " + rankingsWebpage.getAbsolutePath());
            
            return rankingsWebpage;
        } catch (IOException | URISyntaxException e) {
        	
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
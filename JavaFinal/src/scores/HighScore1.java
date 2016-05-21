package scores;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.io.*;

/**
 * The class HighScore1 is used to retrieve scores on ThingSpeak server
 * @author Godefroi Roussel et San Wei Lee.
 * @version 1.1
 *
 */
public class HighScore1 {
	
	String URL_FEED = "https://api.thingspeak.com/channels/110013/feeds.csv";

	/**
	 * 
	 * @return a String[] with all the scores in this array.
	 * @throws MalformedURLException will show a message concerning an error with the URL.
	 */
	public String[] getScores() throws MalformedURLException{
		//Opening of a connection with the ThingSpeak website.
		URL url;
		InputStream is;
		List<String> resultat = new ArrayList<String>(); 
		String[] result;
		String line;
		int nbLine=0;
		
		try {
			// Creation of the url and of the stream of the connection.
			url = new URL(URL_FEED);
			is = url.openStream();
			//Reading of the file that will be store in an ArrayList waiting to be replace to a Array[String].
			Scanner scanner = new Scanner(is);
			line = scanner.nextLine(); // Get the first line because we don't need it
			while (scanner.hasNextLine()){
				line = scanner.nextLine();
				// We are not keeping the empty lines.
				if (line.length()>0){
				resultat.add(line);
				nbLine++;
				}
			}
			
			scanner.close();
		} catch (IOException e) {
			System.out.println("Impossible to read the file");
		}
		
		// Array[String] which has all the lines of the feeds.csv file.
		result = new String[nbLine];
		int taille = resultat.size();
		for(int i=0; i<taille;i++){
			result[i] = resultat.get(i);
		}
		resultat.clear(); //We clear the arraylist because we don't need to have it in the memory.
		return result;
	}
}

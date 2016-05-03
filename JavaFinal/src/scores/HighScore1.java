package scores;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.*;
import java.io.*;

public class HighScore1 {

	public String[] getScores() throws MalformedURLException{
		//Opening of an HTTP connection with the ThingSpeak website
		URL url;
		InputStream is;
		List<String> resultat = new ArrayList<String>(); 
		String[] result;
		String line;
		int nbLine=0;
		
		try {
			// Mise en place de l'url pour récupérer le fichier et ouverture d'un flux entrant
			url = new URL("https://api.thingspeak.com/channels/110013/feeds.csv");
			is = url.openStream();
			//Lecture du fichier qui va être stocké dans une liste dynamique en attendant d'être déplacé vers un tableau de String
			Scanner scanner = new Scanner(is);
			while (scanner.hasNextLine()){
				line = scanner.nextLine();
				resultat.add(line);
				nbLine++;
			}
			
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Tableau de String contenant toutes les lignes du fichier feeds.csv
		result = new String[nbLine];
		for(int i=0; i<resultat.size();i++){
			result[i] = resultat.get(i);
		}
		resultat.clear(); //On supprime l'arraylist maintenant que nous n'en avons plus besoin
		return result;
	}
}

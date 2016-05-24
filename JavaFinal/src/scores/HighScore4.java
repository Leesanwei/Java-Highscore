package scores;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class HighScore4 is used to retrieve scores on ThingSpeak server and calls BestPlayer2 to have top 10 players with the highest scores. Also added sendScore() to update ThingSpeak if player's score is in the top 10.
 * @author Godefroi Roussel et San Wei Lee.
 * @version 4.1
 *
 */
public class HighScore4 {
	
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
				}//if
			}//while
			
			scanner.close();
		} catch (IOException e) {
			System.out.println("Impossible to read the file");
		}
		
		// Array[String] which has all the lines of the feeds.csv file.
		result = new String[nbLine];
		int taille = resultat.size();
		for(int i=0; i<taille;i++){
			result[i] = resultat.get(i);
		}//for
		resultat.clear(); //We clear the arraylist because we don't need to have it in the memory.
		return result;
	}
	
	/**
	 * 
	 * @param readScores 
	 * @return An array of the 10 best players
	 */
	public BestPlayer4[] tenBestScores(String[] readScores){
		int taille = readScores.length;
		BestPlayer4 p;
		BestPlayer4[] allBest = new BestPlayer4[taille];
		
		String line;
		String delims = ",";
		int x=0;
		String[] tokens;
		// On sépare les données et on stocke les joueurs dans un tableau de allBest
		for (int i=0; i<taille;i++){

			line=readScores[i];

			tokens = line.split(delims);
			if (tokens.length == 4){
				p=new BestPlayer4(tokens[3],Integer.parseInt(tokens[2]));
				allBest[x]=p;
				x++;
			}//if

		}//for
		BestPlayer4 tampon;
		
		
		BestPlayer4[] top10;
		int i=0;
		
		//We are considering the case where it's not a top 10 but less
		if (x>=10){
			top10 = new BestPlayer4[10];
		}
		else {
			top10 = new BestPlayer4[x];
		}
		
		//As the sort hasn't to be sophisticated we won't use a quicksort or a dichotomic algorithm
		while(i<10 && i<x ){
			for (int k=i; k<x;k++){
				if (allBest[i].compareTo(allBest[k])==-1){
						tampon = allBest[k];
						allBest[k]=allBest[i];
						allBest[i]=tampon;
					}//if
				}//for
			top10[i]=allBest[i];
			i++;
		}//while
		
		return top10;
	}
	
	/**
	 * 
	 * @param p The player we want to send
	 * @throws IOException
	 * This method will send a player on ThingSpeak
	 */
	public void sendScore(BestPlayer4 p) throws IOException{
		
		URL url = new URL("https://api.thingspeak.com/update?api_key=93XKAAAIR3OFXA5D&field1=" + p.getScore() + "&field2=" + p.getPlayer());
		url.openStream();
	}

}

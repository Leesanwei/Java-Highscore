package scores;

import java.util.*;
import java.io.*;
import java.net.MalformedURLException;


/**
 * 
 * The class TestHighScore2 : Print out the 10 best players and select a random score for a player.
 * @author Godefroi Roussel et San Wei Lee.
 * @version 1.1
 *
 */
public class TestHighScore2 {
	 
		/**
		 * This method is the "launch()" method. We begin to play with this method.
		 * @param args
		 * @throws MalformedURLException 
		 */
	    public static void main(String[] args) throws MalformedURLException {
	    	
	    	// Creation of a HighScore object and initialization. (It handles the error if the connection to the website is impossible)
	    	HighScore2 HS = new HighScore2();
	    	String[] allScore = HS.getScores();
	    	
	    	BestPlayer2[] tabScore = HS.tenBestScores(allScore);
	    	int taille = tabScore.length;
	    	int z;
	    	for(int i=0; i<taille;i++){
	    		 z=i+1;
				System.out.println("["+z +"] " + tabScore[i].player + ":" + tabScore[i].score);
			}
	    	
	    	// Creation of a scores List and recuperation of the player's name.
	    	List<Integer> scores = new ArrayList<Integer>(); 
	    	Random rnd = new Random();
	    	Scanner sc = new Scanner(System.in);
	        System.out.println("Please write your player name below : ");
	        String namePlayer = sc.nextLine();
	        sc.close();
	 
	    
	        // Try to open the file, then read line after line and put the result of the reading in the List scores. (It handle the error if the file can't be open).
	        try{
	        	File file = new File("scoreSamples.txt");
	        	Scanner scan = new Scanner(file);
	        	while (scan.hasNextInt()) {
	                int i = scan.nextInt();
	                scores.add(i);
	            }
	            scan.close();
	            
	            //Selection of a random score and display of the name and the score coming from this player.
	            int rndValue = rnd.nextInt(scores.size());
	            
	            Integer score = scores.get(rndValue);
	            System.out.println( namePlayer + " just scored "+ score);
	        }
	        catch(IOException ex){
	        	System.out.println("Impossible to read the file");
	        }
	 			
	    }
}

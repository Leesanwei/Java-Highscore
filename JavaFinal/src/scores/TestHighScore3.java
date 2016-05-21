package scores;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * The class TestHighScore3 : Print out the 10 best players and select a random score for a player. If player's score is higher than top 10 players, the score will be sent to ThingSpeak to update the top 10 players.
 * @author Godefroi Roussel et San Wei Lee.
 * @version 1.1
 *
 */
public class TestHighScore3 {
	
	/**
	 * This method is the "launch()" method. We begin to play with this method.
	 * @param args
	 * @throws MalformedURLException 
	 */
    public static void main(String[] args) throws MalformedURLException {
    	
    	// Creation of a HighScore object and initialization. (It handles the error if the connection to the website is impossible)
    	HighScore3 HS = new HighScore3();
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
            
            // If our score is greater or equal than one of the top 10 then we add it to the file (if there is 2 scores equals the oldest is kept as first in the high score)
            for (BestPlayer2 p : tabScore){
            	if (p!=null && score>= p.score){
            		HS.sendScore(new BestPlayer2(namePlayer,score));
            	}
            }
        }
        catch(IOException ex){
        	System.out.println("Impossible to read the file");
        }
        
 			
    }

}

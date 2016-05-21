package scores;
 
import java.util.*;
import java.io.*;
import java.net.MalformedURLException;
 
/**
 * 
 * The class TestHighScore1 : read all the score from Thingspeak server then select a fake score from a file for a new player
 * @author Godefroi Roussel et San Wei Lee.
 * @version 1.1
 *
 */
public class TestHighScore1 {
 
	/**
	 * This method is the "launch()" method. We begin to play with this method.
	 * @param args
	 * @throws MalformedURLException 
	 */
    public static void main(String[] args) throws MalformedURLException {
    	
    	// Creation of a HighScore object and initialization. (It handles the error if the connection to the website is impossible)
    	HighScore1 HS = new HighScore1();
    	String[] tabScore = HS.getScores();
    	int taille = tabScore.length;
    	for(int i=0; i<taille;i++){
			System.out.println(tabScore[i]);
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
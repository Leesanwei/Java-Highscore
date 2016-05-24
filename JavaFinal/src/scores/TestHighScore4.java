package scores;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * The class TestHighScore4 : 1. reads online highscores then print the top 10 highscores.
							  2. ask the player if he wants to start a new game
							  3. if yes:
									1. draw a score at random from those read in the file
									2. compares it to the top 10 highscores
									3. Send the player��s score and name online if its score is among the top 10
 * @author Godefroi Roussel et San Wei Lee.
 * @version 1.1
 *
 */
public class TestHighScore4 {
	/**
	 * This method is the "launch()" method. We begin to play with this method.
	 * @param args
	 * @throws MalformedURLException 
	 */
    public static void main(String[] args) throws MalformedURLException, IOException {
    	
    	int answer=0;
    	boolean play = true;
    	Scanner beginning = new Scanner(System.in);
    	Scanner sc = new Scanner(System.in);
    	boolean returnState;
    	int tailleTab;
    	while (play){
    		//1) Reads online highscores then print the top 10 highscores
    		// Creation of a HighScore object and initialization. (It handles the error if the connection to the website is impossible)
        	HighScore4 HS = new HighScore4();
        	String[] allScore = HS.getScores();
        	
        	BestPlayer4[] tabScore = HS.tenBestScores(allScore);
        	int taille = tabScore.length;
        	int z;
        	for(int i=0; i<taille;i++){
        		 z=i+1;
    			System.out.println("["+z +"] " + tabScore[i].player + ":" + tabScore[i].score);
    		}
    		
        	//2) ask the player if he wants to start a new game
        	 do{
    		System.out.println("Do you want to play? (answer : 1 for yes / 2 for no)");
    		try{
        	answer = beginning.nextInt();
        	System.out.println(answer);
    		}
    		catch (InputMismatchException e) {
    			  System.out.println("Please enter only integral numbers");
    			  System.out.println(beginning.next() + " was not valid input.");
    			}
        	}while(answer!=1 && answer != 2);
        	
       
        	 

        	//3) If yes he plays the game
        	if (answer==1){

            	// Creation of a scores List and recuperation of the player's name.
            	List<Integer> scores = new ArrayList<Integer>(); 
            	
            	Random rnd = new Random();
            	
                System.out.println("Please write your player name below : ");
                String namePlayer = sc.nextLine();
                
         
            
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
                    returnState=false;
                    // If our score is greater or equal than one of the top 10 then we add it to the file (if there is 2 scores equals the oldest is kept as first in the high score)
                    for (BestPlayer4 p : tabScore){
                    	if (p!=null && score>= p.score){
                    		BestPlayer4 p1 = new BestPlayer4(namePlayer,score);
                    		allScore = HS.getScores();
                			tabScore = HS.tenBestScores(allScore);
                			HS.sendScore(p1);
                    	}//if
                    }//for
                }//try
                catch(IOException ex){
                	System.out.println("Impossible to read the file");
                }
        	}//if
        	
        	else {
        		play = false;
        		System.out.println("Good Bye !");
        		beginning.close();
        		sc.close();
            	
        	}
        	
    	}//while
    	
    	
        
 			
    }

}

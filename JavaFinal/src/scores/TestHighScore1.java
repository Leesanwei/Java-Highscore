package scores;
 
import java.util.*;
import java.io.*;
 
public class TestHighScore1 {
 
    public static void main(String[] args) {
    	
    	
    	List<Integer> scores = new ArrayList<Integer>(); 
    	Random rnd = new Random();
    	Scanner sc = new Scanner(System.in);
        // TODO Auto-generated method stub
        System.out.println("Please write your player name below : ");
        
        String namePlayer = sc.nextLine();
        sc.close();
        //System.out.println(namePlayer);
 
    
 
        try{
        	File file = new File("scoreSamples.txt");
        	Scanner scan = new Scanner(file);
        	while (scan.hasNextInt()) {
                int i = scan.nextInt();
                scores.add(i);
                //System.out.println(i);
            }
            scan.close();
            
            int rndValue = rnd.nextInt(scores.size());
            
            Integer score = scores.get(rndValue);
            System.out.println( namePlayer + " just scored "+ score);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
 
    }
     
}
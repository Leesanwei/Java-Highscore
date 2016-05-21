package scores;
/**
 * 
 * The class BestPlayer2 is used to compare the scores of 2 players and if 2 players are equal
 * @author Godefroi Roussel et San Wei Lee.
 * @version 1.1
 *
 */
public class BestPlayer4 {
	
	String player;
	int score;
	
	public BestPlayer4() {
		this.player="unknown";
		this.score=0;
	}

	
	public BestPlayer4(String player, int score){
		this.player=player;
		this.score=score;
	}
	

	public int compareTo(BestPlayer4 p){
		if (this.score==p.score){
			return 0;
		}
		else if (this.score < p.score){
			return -1;
		}
		else 
			return 1;
	}
	/**
	 * 
	 * @param p represent a player
	 * @return a boolean, true if it's the same player else false
	 */
	public boolean equal(BestPlayer4 p){
		return (this.player.equals(p.player) && this.score==p.score);
	}
	
	

}

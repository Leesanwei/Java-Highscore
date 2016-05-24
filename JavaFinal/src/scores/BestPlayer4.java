package scores;
/**
 * 
 * The class BestPlayer4 is used to compare the scores of 2 players and if 2 players are equals
 * @author Godefroi Roussel and San Wei Lee.
 * @version 4.1
 *
 */
public class BestPlayer4 {
	
	private String player;
	private int score;
	
	/**
	 * This constructor initialize a player with the name unknown and the score to 0
	 */
	public BestPlayer4() {
		this.player="unknown";
		this.score=0;
	}

	/**
	 * 
	 * @param player Player's name
	 * @param score Player's score
	 */
	public BestPlayer4(String player, int score){
		this.player=player;
		this.score=score;
	}
	

	/**
	 * 
	 * @param p The player we want to compare with.
	 * @return 0 if the players have the same score, -1 if the player p has a higher score, 1 if the player has a lower score
	 */
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
	 * @return a boolean, true if it's the same player (same name and same score) else false
	 */
	public boolean equal(BestPlayer4 p){
		return (this.player.equals(p.player) && this.score==p.score);
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}

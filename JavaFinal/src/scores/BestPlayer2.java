package scores;
/**
 * 
 * The class BestPlayer2 is used to compare the scores of 2 players.
 * @author Godefroi Roussel et San Wei Lee.
 * @version 1.1
 *
 */
public class BestPlayer2 {

	String player;
	int score;
	
	public BestPlayer2() {
		this.player="unknown";
		this.score=0;
	}

	
	public BestPlayer2(String player, int score){
		this.player=player;
		this.score=score;
	}
	

	public int compareTo(BestPlayer2 p){
		if (this.score==p.score){
			return 0;
		}
		else if (this.score < p.score){
			return -1;
		}
		else 
			return 1;
	}
}

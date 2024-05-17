import java.util.*;

public class Roulette {
	
	public int winningnumber;
	public List<RPlayer> players = new ArrayList<RPlayer>();

	void register(RPlayer player) {
		// TODO
		players.add(player);
	}
	
	int play() {
		// TODO
		Random random = new Random();
		winningnumber = random.nextInt(37);
		force(winningnumber);
		return winningnumber;
	}
	
	void force(int number) {
		// TODO
		winningnumber = number;
		for(int i=0; i<players.size(); i++) {
			RPlayer current = players.get(i);
			if(current.luckynumber==number) {
				current.balance+=(current.betlucky * 36);
			}
			else if(current.seteven) {
				if(winningnumber%2==0) {
					current.balance+=(current.beteven*2);
				}
				current.beteven=0;
			}
			else if(current.setodd) {
				if(winningnumber%2==1) {
					current.balance+=(current.betodd*2);
				}
			}
			current.betodd=0;
			current.betlucky=0;
		}
	}
		
}
import java.util.*;

public class Ticket {
	Set<Integer> numbers;
	Set<Integer> correctNumbers;
	int id;
	Lottery lottery;
	

	public int getNumber() {
		// TODO
		return id;
	}

	public Set<Integer> getNumbers() {
		// TODO
		return numbers;
	}

	public Set<Integer> getCorrectNumbers() {
		// TODO
		if(!lottery.draw) {
			throw new IllegalStateException();
		}
		for(int i: numbers) {
			for(int j: lottery.winning) {
				if(i == j) {
					correctNumbers.add(i);
					j=6;
				}
			}
		}
		return correctNumbers;
	}

	public int getPrize() {
		// TODO
		if(!lottery.draw) {
			throw new IllegalStateException();
		}
		if(correctNumbers.size()==0) {
			return 0;
		}
		else {
			int prize = 5;
			for(int i=1; i<correctNumbers.size(); i++) {
				prize*=20;
			}
		return prize;
		}
	}
}

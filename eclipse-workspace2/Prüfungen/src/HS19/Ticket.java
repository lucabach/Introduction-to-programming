package HS19;

import java.util.*;

public class Ticket {
	Set<Integer> numbers;
	int ticketNumber;
	Lottery lottery;
	
	public void Ticket(Set<Integer> numbers, int ticketNumber, Lottery lottery) {
		this.numbers = numbers;
		this.ticketNumber=ticketNumber;
		this.lottery = lottery;
	}

	public int getNumber() {
		return ticketNumber;
	}

	public Set<Integer> getNumbers() {
		return this.numbers;
	}

	public Set<Integer> getCorrectNumbers() {
		Set<Integer>correctNumbers = new HashSet<Integer>();
		Set<Integer> winners = lottery.getWinning();
		for (int n :numbers) {
			if (winners.contains(n)) {
				correctNumbers.add(n);
			}
		}
		return correctNumbers;	
	}
	

	public int getPrize() {
		int x = getCorrectNumbers().size();
		if (x==0) {
		return 0;
		}
		else 
		for (int i = 0; i<x;i++) {
			x*=20;
		}
		return x; 
	}
}

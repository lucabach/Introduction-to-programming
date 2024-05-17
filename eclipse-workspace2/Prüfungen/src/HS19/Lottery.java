package HS19;

import java.util.*;
import java.util.Random;

public class Lottery {
	  int nextTicketNumber;
	  int maxNumber;
	  Set<Integer> winningSet;

	  public Lottery(int maxNumber) {
	    if (maxNumber < 6) throw new IllegalArgumentException();
	    this.maxNumber = maxNumber;
	    nextTicketNumber = 0;
	  }
		
			

	public Ticket buyTicket(int[] numbers) {
    if (winningSet != null) throw new IllegalStateException();
    HashSet<Integer> set = new HashSet<>();
    for (int n : numbers) {
      if (n < 1) throw new IllegalArgumentException();
      if (n > maxNumber) throw new IllegalArgumentException();
      set.add(n);
    }
    if (set.size() != 6) throw new IllegalArgumentException();
    Ticket ticket = new Ticket(set, ++nextTicketNumber, this);
    return ticket;
	}

	public int soldTickets() {
    return nextTicketNumber;
}

	public void draw() {
		Random random = new Random();
		this.winningSet = new HashSet<Integer>();
		for (int i = 1; i<=6; i++) {
			int x = random.nextInt(maxNumber+1);
			winningSet.add(x);
		}
			}

	public Set<Integer> getWinning() {
		return winningSet;
	}
}
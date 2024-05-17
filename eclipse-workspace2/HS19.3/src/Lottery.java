import java.util.*;

public class Lottery {
	
	int maxNumber;
	int tickets;
	Set<Integer> winning;
	boolean draw;
	
	public Lottery(int maxNumber) {
		// TODO
		this.maxNumber = maxNumber;
		this.tickets = 0;
		this.winning = new HashSet<>();
		this.draw = false;
	}

	public Ticket buyTicket(int[] numbers) {
		// TODO
		if(draw) {
			throw new IllegalStateException();
		}
		if(numbers.length != 6) {
			throw new IllegalArgumentException();
		}
		Ticket ticket = new Ticket();
		ticket.numbers = new HashSet<>();
		ticket.lottery = this;
		ticket.correctNumbers= new HashSet<>();
		for(int i=0; i<6; i++) {
			if(numbers[i]<1 || numbers[i]>maxNumber) {
				throw new IllegalArgumentException();
			}
			ticket.numbers.add(numbers[i]);
		}
		ticket.id = tickets += 1;
		return ticket;
	}

	public int soldTickets() {
		// TODO
		return tickets;
	}

	public void draw() {
		// TODO
		if(draw) {
			throw new IllegalStateException();
		}
		draw = true;
		winning.clear();
		Random r = new Random();
		for(int i=0; i<6; i++) {
			int nextint = r.nextInt(maxNumber)+1;
			if(!winning.contains(nextint)) {
			winning.add(nextint);
			}
			else {
				i--;
			}
		}
	}

	public Set<Integer> getWinning() {
		// TODO
		if(!draw) {
			throw new IllegalStateException();
		}
		return winning;
	}
}

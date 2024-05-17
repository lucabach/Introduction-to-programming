package HS20;

import java.util.*;

public class SeqNumber {

	public int number;
	public Set<Integer> positions;

	public SeqNumber(int number, Set<Integer> positions) {
		this.number = number;
		this.positions = positions;
	}
	
	public SeqNumber getSeqNumber(int number) {
		return this;
	}

	public int getNumber() {
		return number;
	}

	public Set<Integer> getPositions() {
		return new HashSet<Integer>(positions);
	}

	@Override
	public String toString() {
		return number + ": " + positions.toString();
	}
}

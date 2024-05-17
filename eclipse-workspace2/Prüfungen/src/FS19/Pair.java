package FS19;

public class Pair {
	public int first;
	public int second;
	
	public Pair(int x, int y) {
		this.first = x;
		this.second = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pair)) {
			return false;
		}
		Pair other = (Pair) obj;
		return first == other.first && second == other.second;
	}

	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}
}
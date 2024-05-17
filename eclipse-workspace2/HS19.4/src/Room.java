import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class Room {
	private int color;
	public List<Room> doorsTo;
	boolean visited;
	public List<Room> predecessors;

	public Room(int color) {
		assert 0 <= color && color <= 9;
		this.color = color;
		this.doorsTo = new LinkedList<>();
		this.visited=false;
		this.predecessors = new ArrayList<Room>();
	}

	public boolean isExit() {
		return doorsTo.isEmpty();
	}

	public int getColor() {
		return color;
	}

	@Override
	public boolean equals(Object other) {
		return this == other;
	}
}

import java.util.*;

public class Room {
	
	String name;
	public List<Room>exits;
	public Room[] doorsTo;

	public Room(String name, Room[] doorsTo) {
		this.name = name;
		this.doorsTo = doorsTo;
		this.exits=new ArrayList<Room>();
	}
	
	public Room(String name) {
		this.name = name;
		this.doorsTo = new Room[0];
	}

	public boolean isExit() {
		return doorsTo.length == 0;
	}

	public String getName() {
		return name;
	}

}
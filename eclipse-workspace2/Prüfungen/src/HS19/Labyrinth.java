package HS19;
import java.util.*;

public class Labyrinth {

	public static void main(String[] args) {
		Room a1 = new Room(1);
		Room a2 = new Room(3);
		Room a3 = new Room(4);
		Room a4 = new Room(2);
		Room a5 = new Room(1);
		Room a6 = new Room(5);
		a1.doorsTo.add(a2);
		a1.doorsTo.add(a4);
		a2.doorsTo.add(a3);
		a3.doorsTo.add(a1);
		a4.doorsTo.add(a5);
		a4.doorsTo.add(a6);

		System.out.println(Labyrinth.colorNotSuccessively(a1));
	}

	public static boolean colorExactlyOnce(Room room) {
		// TODO: Geben Sie true zurueck genau dann wenn
		// das Labyrint vom Raum room verlassen werden kann,
		// sodass ein Raum jeder Farbe exakt einmal verwendet wird
		Map <Room, Integer> visited = new HashMap<Room, Integer>();
		int color1 = room.getColor();
		visited.put(room, color1);
		return visitAll(room, visited);
	}
	
	public static boolean visitAll(Room room, Map<Room, Integer> visited) {
		if (room.doorsTo.isEmpty() && visited.size() == 10) {
			return true;
		}
		for (int i = 0; i<room.doorsTo.size(); i++) {
			int color = room.doorsTo.get(i).getColor();
			if (!visited.containsValue(color)) {
				visited.put(room.doorsTo.get(i), color);
				return visitAll(room.doorsTo.get(i), visited);
			}
		}
		return false;
	}

	public static boolean colorNotSuccessively(Room room) {
		// TODO: Geben Sie true zurueck genau dann wenn
		// das Labyrint vom Raum room verlassen werden kann,
		// sodass nicht zwei Raeume der gleichen Farbe
		// hintereinander verwendet werden.
		Map <Room, Integer> visited = new HashMap<Room, Integer>();
		List<Room>succession = new ArrayList<Room>();
		int color1 = room.getColor();
		succession.add(room);
		visited.put(room, color1);
		return visitBoth(room, succession, visited);
	}
	
	public static boolean visitBoth(Room room, List<Room> succession, Map <Room,Integer> visited) {
		if (room.doorsTo.isEmpty()) {
			return true;
		}
		else {
			for(int i=0; i<room.doorsTo.size(); i++) {
				Room current = room.doorsTo.get(i);
				if (!visited.containsKey(current)) {
				visited.put(current, current.getColor());
				int color = room.doorsTo.get(i).getColor();
				int colorLast = succession.get(succession.size() -1).getColor();
				if (color != colorLast) {
					succession.add(current);
					return visitBoth(current, succession, visited);
				}
				}
			}
		}
		return false;
		}
	

	public static void removeCycle(Room room) {
		// TODO: Falls Sie von dem Raum room eine Schleife
		// erreichen koennen, dann entfernen Sie
		// genau alle diese Verbindungen, welche für
		// die Schleife benoetigt werden.
		Map <Room, Integer> visited = new HashMap<Room, Integer>();
		List<Room>succession = new ArrayList<Room>();
		List<Room>allRooms = new ArrayList<Room>();
		int color1 = room.getColor();
		visited.put(room, color1);
		fixIt(room, visited, succession, allRooms); 
		}
	
	public static void fixIt(Room room, Map<Room, Integer> visited, List<Room> succession, List<Room>allRooms) {
		if (succession.size()==)
		for(int i = 0; i<room.doorsTo.size(); i++) {
			Room current = room.doorsTo(i);
			if (visited.containsKey(current)) {
				room.doorsTo(i) = null;
			}
		}
	}
	}
	
	
	
}

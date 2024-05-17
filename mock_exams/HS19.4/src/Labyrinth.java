import java.util.*;
public class Labyrinth {

	List<Integer> colors = new ArrayList<>();
	
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
		Labyrinth l = new Labyrinth();
		return colorExactlyOnce(room, l);
	}
	
	
	public static boolean colorExactlyOnce(Room room, Labyrinth lab) {
		if(lab.colors.contains(room.getColor())) {
			return false;
		}
		else {
			lab.colors.add(room.getColor());
		}
		
		if(room.doorsTo.size()==0) {
			if(lab.colors.size() == 10) {
				return true;
			}
			return false;
		}
		
		for(int i=0; i<room.doorsTo.size(); i++) {
			Labyrinth l = new Labyrinth();
			l.colors = lab.colors;
			if(colorExactlyOnce(room.doorsTo.get(i), l)) {
				return true;
			}
		}
		return false;
	}

	public static boolean colorNotSuccessively(Room room) {
		// TODO: Geben Sie true zurueck genau dann wenn
		// das Labyrint vom Raum room verlassen werden kann,
		// sodass nicht zwei Raeume der gleichen Farbe
		// hintereinander verwendet werden.
		Labyrinth l = new Labyrinth();
		return colorNotSuccessively(room, l);
	}
	
	public static boolean colorNotSuccessively(Room room, Labyrinth lab) {
		if(room.visited) {
			return false;
		}
		else {
			room.visited = true;
		}
		
		lab.colors.add(room.getColor());
		if(lab.colors.size()>1) {
			if(lab.colors.get(lab.colors.size()-2) == lab.colors.get(lab.colors.size()-1)) {
				return false;
			}
			else if(room.doorsTo.size()==0) {
				return true;
			}
		}
		else {
			if(room.doorsTo.size() == 0) {
				return true;
			}
		}
		
		for(int i=0; i<room.doorsTo.size(); i++) {
			Labyrinth l = new Labyrinth();
			l.colors = lab.colors;
			if(colorNotSuccessively(room.doorsTo.get(i), l)) {
				return true;
			}
		}
		return false;
	}

	public static void removeCycle(Room room) {
		// TODO: Falls Sie von dem Raum room eine Schleife
		// erreichen koennen, dann entfernen Sie
		// genau alle diese Verbindungen, welche für
		// die Schleife benoetigt werden.
		removeCycle(room, null);
	}
	
	public static void removeCycle(Room room, Room pred) {
		if(!room.visited) {
			room.visited = true;
			room.predecessors = pred.predecessors;
			room.predecessors.add(pred);
		}
		else {
			for(int i=0; i<pred.doorsTo.size(); i++) {
				if(pred.doorsTo.get(i)==room) {
					pred.doorsTo.remove(i);
					room.visited=false;
					for(int j=0; j<pred.doorsTo.size(); j++) {
						removeCycle(pred.doorsTo.get(j), pred);
					}
				}
			}
		}
		for(int i=0; i<room.doorsTo.size(); i++) {
			removeCycle(room.doorsTo.get(i), room);
		}
	}
}

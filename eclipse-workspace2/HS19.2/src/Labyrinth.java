import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Labyrinth {
	
	
	static List<Room> exits;
	static List<List<Room>>paths;
	
	public static List<Room> exits(Room room, List<Room> prefix) {
		//TODO

		exits = new ArrayList<Room>();
		paths = new ArrayList<List<Room>>();
		List<Room>currentpath = new ArrayList<Room>();
		currentpath.add(room);
		helperexits(room, prefix, currentpath);
		for(int i=0; i<exits.size(); i++) {
			for(int j=i+1; j<exits.size(); j++) {
				if(exits.get(i)==exits.get(j)) {
					exits.remove(j);
				}
			}
		}
		return exits;
	}
	
	
	public static void helperexits(Room room, List<Room> prefix, List<Room>currentpath){
		
		if (room.doorsTo.length==0) {
			if(prefix.isEmpty()) {
			exits.add(room);
			currentpath.add(room);
			paths.add(currentpath);
			}
			else if(prefix.get(0)==room) {
				exits.add(room);
				currentpath.add(room);
				paths.add(currentpath);
			}
			return;
		}
		
		else {
			
			if(prefix.isEmpty() || prefix.get(0)==room) {
			try {
			prefix.remove(0);
			}catch(Exception e) {}
			
			for(int i=0; i<room.doorsTo.length; i++) {
				Room currentneighbor = room.doorsTo[i];
				currentpath.add(currentneighbor);
				helperexits(currentneighbor, prefix, currentpath);
			}
			}
			return;
		}
	}
	
	
	public static void sortRooms(List<Room> a) {
		//TODO
		Map<Room, Integer> map = new HashMap<Room, Integer>();
		Room[] roomarray = new Room[a.size()];
		
		
		for(int i=0; i<a.size(); i++) {
			exits = new ArrayList<Room>();
			paths = new ArrayList<List<Room>>();
			Room current = a.get(i);
			List<Room> prefix = new ArrayList<Room>();
			List<Room> currentpath =new ArrayList<Room>();
			helperexits(current, prefix, currentpath);
			int noexits = exits.size();
			current.exits = exits;
			map.put(current, noexits);
			roomarray[i]=current;
			System.out.println(current.name + " " + current.exits.size());
		}
		
		

		for(int i=0; i<a.size(); i++) {
			for(int j=i+1; j<a.size(); j++) {
				Room current = roomarray[i];
				int curexits = map.get(current);
				Room currentcomp = roomarray[j];
				int curcompexits = map.get(currentcomp);
				if(curcompexits<curexits || curcompexits ==curexits && stupidproperty(currentcomp, current, map)) {
					Room temp= roomarray[i];
					roomarray[i]=roomarray[j];
					roomarray[j]=temp;
				}
			}
		}
		
		int asize = a.size();
		for(int i=0; i<roomarray.length; i++) {
			a.add(roomarray[i]);
		}
		for(int i=0; i<asize; i++) {
			a.remove(0);
		}
	}
	
	public static boolean stupidproperty(Room one, Room two, Map<Room, Integer> map) {
		int maxone = 0;
		int maxtwo = 0;
		for(int i=0; i<one.exits.size(); i++) {
			Room current = one.exits.get(i);
			if(current.name.length()>maxone) {
				maxone = current.name.length();
			}
		}
		for(int i=0; i<two.exits.size(); i++) {
			Room current = two.exits.get(i);
			if(current.name.length()>maxtwo) {
				maxtwo = current.name.length();
			}
		}
		return maxone>maxtwo;
	}
	
	
	
	public static boolean pathsWithSameNames(Room room, int n) {
		// TODO
		exits = new ArrayList<Room>();
		paths = new ArrayList<List<Room>>();
		List<Room>prefix = new ArrayList<Room>();
		List<Room>c = new ArrayList<Room>();
		c.add(room);
		helperexits(room, prefix, c);
		
		for(int i=0; i<paths.size(); i++) {
			List<Room> curpath = paths.get(i);
			for(int j=i+1; j<paths.size(); j++) {
				List<Room> curcomp = paths.get(j);
				if(!differinOneRoom(curpath, curcomp)) {
					paths.remove(curcomp);
				}
			}
		}
		
		int count = 0;
		for(int i=0; i<paths.size(); i++) {
			List<Room> curpath = paths.get(i);
			for(int j=i+1; j<paths.size(); j++) {
				List<Room> curcomp = paths.get(j);
				if(sameNames(curpath, curcomp)) {
				if(curpath.size()!=curcomp.size()) {
					count++;
				}
				else if(differinOneRoom(curpath, curcomp)) {
					count++;
				}
				}
			}
		}
		
		return count>=n;
	}
	
	public static boolean differinOneRoom(List<Room>a, List<Room>b) {
		if(a.size()!=b.size()) {
			return true;
		}
		for(int i=0; i<a.size(); i++) {
			if(a.get(i)!=b.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean sameNames(List<Room> a, List<Room> b) {
		Map<String, Integer> ma = new HashMap<>();
		for (Room x : a) {
			String n = x.getName();
			ma.put(n, ma.getOrDefault(n, 0)+1);
		}
		
		Map<String, Integer> mb = new HashMap<>();
		for (Room x : b) {
			String n = x.getName();
			mb.put(n, mb.getOrDefault(n, 0)+1);
		}
		
		if (!ma.keySet().equals(mb.keySet())) {
			return false;
		}
		
		for (String n : ma.keySet()) {
			if (!ma.get(n).equals(mb.get(n))) {
				return false;
			}
		}
		
		return true;
	}
	
}

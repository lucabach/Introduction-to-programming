import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

	public class Nod {
	    
	    private String name;
	    
	    private List<Node> shortestPath = new LinkedList<>();
	    
	    private Integer distance = Integer.MAX_VALUE;
	    
	    Map<Node, Integer> adjacentNodes = new HashMap<>();

	    public void addDestination(Node destination, int distance) {
	        adjacentNodes.put(destination, distance);
	    }
	 
	    public Nod(String name) {
	        this.name = name;
	    }
	    
	    public void setDistance(int distance) {
	    	this.distance = distance;
	    }
	    
	    public int getDistance() {
	    	return this.distance;
	    }
	    
	    public static Nod getlowestDistanceNod (Set<Nod> unsettledNodes) {
	    	Nod lowestD = null;
	    	int minDistance = Integer.MAX_VALUE;
	    	for (Nod nod : unsettledNodes) {
	    		int distance = nod.getDistance();
	    		if (distance < minDistance) {
	    			minDistance = distance;
	    			lowestD = nod;
	    		}
	    	}
	    		return lowestD;
	    	
	    }
}

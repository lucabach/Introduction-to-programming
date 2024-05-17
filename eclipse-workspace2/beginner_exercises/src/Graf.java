import java.util.*;

public class Graf {

	Map<Node, Map<Node, Integer>> adjacency = new HashMap<>();
	
    private Set<Nod> nodes = new HashSet<>();
    
    public void addNode(Nod nodeA) {
        nodes.add(nodeA);
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
    
    
    
    public static Graf Dijkstra(Graf graf, Nod source) {
    	source.setDistance(0);
    	
    	Set<Nod> settledNodes = new HashSet<Nod>();
    	Set <Nod> unsettledNodes = new HashSet<Nod>();
    	
    	unsettledNodes.add(source);
    	
    	while(!unsettledNodes.isEmpty()) {
    		Nod current = getlowestDistanceNod(unsettledNodes);
    		unsettledNodes.remove(current);
    		for (Nod a : adjacency.get) {
    			
    		}
    	}
    }
    
    
    
}

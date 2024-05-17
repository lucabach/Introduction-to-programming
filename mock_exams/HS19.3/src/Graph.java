
import java.util.List;
import java.util.*;
public class Graph {
	
	
	
	public static void removeEdges(Node origin, String label, int maxWeight) {
		//TODO
		if(origin == null||origin.getNeighbours()==null) {
			return;
		}
		else {
			for(int i=0; i<origin.getNeighbours().size(); i++) {
				Edge current = origin.getNeighbours().get(i);
				removeEdges(current.getTarget(), label, maxWeight);
				if(current != null) {
				if(current.getLabel().equals(label)&&current.getWeight()<=maxWeight) {
					System.out.println("removed edge " + current.getLabel() + " " + current.getWeight() + " " + current.getTarget());
					origin.getNeighbours().remove(current);
				}
				}
				}
			}
		}
	
	


package Graph2;
import java.util.*;

public class Graph {
	int nodesNumber;
	List<Node> nodes;
	Node lastfound;
	
	
		Graph(Node node, int nodesNumber) {
		this.nodesNumber = nodesNumber;
		node.previous = new int[nodesNumber];
		this.nodes = new ArrayList<>();
		List <Node> list = new ArrayList<>();
		node.previous[node.key]=node.key;
		list.add(node);
		Node current=node;
		while (!list.isEmpty()) {
			current = list.remove(list.size()-1);
			this.nodes.add(current);
			for (Node n : current.neighbours) {
				list.add(n);
				node.previous[n.key]=current.key;
			}
			this.lastfound=current;
		}
		
	}
		

}

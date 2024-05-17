package Graph2;
import java.util.*;

public class Node {
	int key;
	List<Edge> edges;
	List<Node> neighbours;
	int maxdistance;
	int[] previous;
	int nodes = 6;
	
	Node(int key){
		this.key = key;
		this.edges = new ArrayList<>();
		this.neighbours = new ArrayList<>();
		this.maxdistance = maxd();
		this.previous=null;
	}
	
	public int maxd() {
		Graph g = new Graph(this, this.nodes);
		Node current = g.lastfound;
		int maxdd =1;
		while (previous[current.key]!=this.key) {
			current.key = previous[current.key];
			maxdd++;
		}
		return maxdd;
	}
	
	
}

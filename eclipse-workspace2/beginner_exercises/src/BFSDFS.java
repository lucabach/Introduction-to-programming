import java.util.*;

public class BFSDFS {
	
	 public void main (String[] args) {
		 int nodes = 4;
		 int edges = 3;
		 Node zero = new Node();
		 Node one = new Node();
		 Node two = new Node();
		 Node three = new Node();
		 Node four = new Node();
		 Node five = new Node();
		 zero.adjacent.add(one);
		 zero.adjacent.add(two);
		 one.adjacent.add(five);
		 two.adjacent.add(three);
		 two.adjacent.add(four);
		 Map <Node, List<Node>> g = new HashMap<>();
		 g.put(zero, zero.adjacent);
		 g.put(one, one.adjacent);
		 g.put(two, two.adjacent);
		 g.put(three, three.adjacent);
		 g.put(four, four.adjacent);
		 g.put(five, five.adjacent);
		 
		 Graph graph = new Graph(nodes, edges, g);
		 
		 DFS (graph, zero);	 
	 }
	
	public class Graph {
		int nodes;
		int edges;
		Map <Node, List<Node>> g;
		
		Graph(int nodes, int edges, Map <Node, List<Node>> g) {
			this.nodes = nodes;
			this.edges = edges;
			this.g = g;
		}
	}
	
	public class Node {
		int identifier;
		int degree;
		List<Node> adjacent;
		
		Node() {
			this.identifier = identifier;
			this.degree= degree;
			this.adjacent = adjacent;
		}
	}
	
	public void DFS(Graph graph, Node node) {
		System.out.println("DFS ORDER:");
		Stack <Node> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
		Node current = stack.pop();
		System.out.println(current);
		int i = 0;
			for (i=0; i<current.adjacent.size(); i++) {
				Node neighbor = current.adjacent.get(i);
				stack.push(neighbor);
			}
		}
	}
	
	

 
}

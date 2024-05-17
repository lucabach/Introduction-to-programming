import java.util.*;

public class traversal {

public class Graph {
	ArrayList<ArrayList> graph;
	
	public void Graph(ArrayList<ArrayList> graph) {
		this.graph = graph;
	}
}

public class Node {
	int vertex;
	ArrayList<Node> node;
	
	public Node(int vertex, ArrayList<Node> adjacent) {
		this.vertex = vertex;
		this.node = adjacent;
	}
}

public void DFS(Graph graph, Node node) {
	System.out.println("DFS order starting from node " +node);
	Stack<Node> stack = new Stack<Node>();
	stack.push(node);
	while(!stack.isEmpty()) {
		Node current = stack.pop();
		System.out.print(current + " ");
		int i = 0;
		for (i=0; i<current.node.size(); i++) {
			Node neighbor = current.node.get(i);
			stack.push(neighbor);
		}	
	}
}

public static void main (String[] args) {
	ArrayList<ArrayList> graph = new ArrayList<ArrayList>();
	ArrayList<Node> nodeA = new ArrayList<Node>();
	Node a = new Node (1, nodeA);
	
}


}

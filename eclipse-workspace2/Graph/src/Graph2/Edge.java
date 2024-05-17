package Graph2;

public class Edge {
	Node from;
	Node to;
	int weight;
	
	Edge(Node from, Node to, int weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
		from.neighbours.add(to);
		to.neighbours.add(from);
		from.edges.add(this);
		to.edges.add(this);
	}
}

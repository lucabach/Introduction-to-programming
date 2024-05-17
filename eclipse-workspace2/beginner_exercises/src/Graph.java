import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
										

	static void addEdge (ArrayList<ArrayList<Integer>> g, int u, int v) {
		g.get(u).add(v);
		g.get(v).add(u);
	}
	

	
	static void printGraph(ArrayList<ArrayList<Integer> > adj)	 {
		System.out.println();
		System.out.println("Adjacency list:");
	        for (int i = 0; i < adj.size(); i++) {
	            System.out.print(i+ ":");
	            for (int j = 0; j < adj.get(i).size(); j++) {
	                System.out.print(" -> "+adj.get(i).get(j));
	            }
	            System.out.println();
	        }
	 }
	
	static void DFSHelp(ArrayList<ArrayList<Integer> > adj, int node, boolean [] visited) {
		visited[node] = true;
		System.out.print(node + " ");
		for (int i = 0; i< adj.get(node).size(); i++) {
			int a = adj.get(node).get(i);
				if (!visited[a]) {
				DFSHelp(adj, a, visited);
				}
			
			}
	}
	
	
	static void BFSHelp(ArrayList<ArrayList<Integer> > adj, int node, boolean [] visited) {
		LinkedList queue = new LinkedList<Integer>();
		visited[node]=true;
		queue.add(node);
		while(!queue.isEmpty()) {
			node = (int) queue.poll();
			System.out.print(node + " ");
			for (int i = 0; i< adj.size(); i++) {
				for(int j=0; j<adj.get(i).size(); j++) {
					int a = adj.get(i).get(j);
					if (!visited[a]) {
						visited[a] = true;
						queue.add(a);
					}
				}
			}
		}
		System.out.println();
	}
	
	static void DFS(ArrayList<ArrayList<Integer> > adj, int node, int totalNodes) {
		ArrayList<ArrayList<Integer> > g = adj;
		boolean [] visited = new boolean[totalNodes];
		System.out.println("DFS order of visited nodes starting by node " +node+ ":");
		DFSHelp (g, node, visited);
	}
	
	static void BFS(ArrayList<ArrayList<Integer> > adj, int node, int totalNodes) {
		ArrayList<ArrayList<Integer> > g = adj;
		boolean [] visited = new boolean[totalNodes];
		System.out.println();
		System.out.println("BFS order of visited nodes starting by node " +node+ ":");
		BFSHelp (g, node, visited);
	}

	
	//Here we create the graph by declaring it, adding the edges, and then starting the methods.
	public static void main(String[] args) {
		int V =4;
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(V);
		for(int i = 0; i<V; i++) {
			g.add(new ArrayList<Integer>());
		}
		addEdge(g, 0, 1);
		addEdge(g, 1, 2);
		addEdge(g, 0, 3);
		
		printGraph(g);
		System.out.println();
		DFS(g, 0, V);
		BFS(g, 0, V);
	}

}

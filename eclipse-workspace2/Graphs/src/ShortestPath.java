
public class ShortestPath {
	
	static int source;
	static int[] distanceto;
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.addEdge(0, 1, 2);
		g.addEdge(0,  4, 3);
		g.addEdge(1, 2, 2);
		g.addEdge(1, 3, 4);
		g.addEdge(1,  5, 1);
		g.addEdge(2, 5, 3);
		g.addEdge(3, 6, 2);
		g.addEdge(4,  7, -1);
		g.addEdge(5, 6, -1);
		g.addEdge(6,  7, -2);
		g.addEdge(7, 3, 1);
		bellmanFord(0, g);
	}
	
	
	public static void dijkstra(int s, Graph g) {
		
		System.out.println("distances from " +s+ " to ");
		System.out.println();
		
		source = s;
		distanceto = new int[g.nodes];
		visited = new boolean[g.nodes];
		
		
		for(int i=0; i<g.nodes; i++) {			//initialize the distances to infinity except for the source
			if(i==s) {
				distanceto[i]=0;
			}
			else {
			distanceto[i]= Integer.MAX_VALUE;
			}
		}
		
		for(int i=0; i<g.nodes; i++) {
		int minvertex = findminvertex(g); //returns the unvisited vertex with the smallest distance from source
		visited[minvertex]=true;
		
			for(int j=0; j<g.neighbors.get(minvertex).size(); j++) {			   				//explore minvertex neighbors
				int currentneighbor = g.neighbors.get(minvertex).get(j);
				if(!visited[currentneighbor] && distanceto[minvertex]!= Integer.MAX_VALUE) {
				Edge currentedge = g.edge.get(minvertex).get(j);
				if(distanceto[minvertex]+ currentedge.weight < distanceto[currentneighbor]){
					distanceto[currentneighbor]=distanceto[minvertex]+ currentedge.weight;
				}
			}
			}
		}
		
		for(int i=0; i<g.nodes; i++) {
			System.out.println(" --> " +i+ " : " + distanceto[i]);
		}
	}
	
	public static int findminvertex(Graph g) {
		int minvertex = -1;
		for(int i=0; i<g.nodes; i++) {
			if(!visited[i] && (minvertex == -1 || distanceto[i]<distanceto[minvertex])){
				minvertex = i;
			}
		}
			return minvertex;
		}
	
	
	
	public static void bellmanFord(int s, Graph g) {
		
		System.out.println("distances from " +s+ " to ");
		System.out.println();
		
		parent = new int[g.nodes];
		distanceto = new int[g.nodes];
		for(int i=0; i<g.nodes; i++) {
			if(i==s) {
				parent[i]= -1;
				distanceto[i]=0;
			}
			else {
				distanceto[i]=Integer.MAX_VALUE;
			}
		}
		
		for(int i=0; i<g.nodes-1; i++) {
			boolean updated = false;
			for(int j=0; j<g.nodes; j++) {
				for(int k=0; k< g.edge.get(j).size(); k++) {
					Edge currentedge = g.edge.get(j).get(k);
					int u = currentedge.u;
					int v = currentedge.v;
					if(distanceto[u]!= Integer.MAX_VALUE && (distanceto[u] + currentedge.weight < distanceto[v])) {
						distanceto[v] = distanceto[u]+currentedge.weight;
						parent[v]=u;
						updated =true;
					}
			}
		}
			if(!updated) {
				break;
			}
		}
		
		
		for(int j=0; j<g.nodes; j++) {
			for(int k=0; k< g.edge.get(j).size(); k++) {
				Edge currentedge = g.edge.get(j).get(k);
				int u = currentedge.u;
				int v = currentedge.v;
				if(distanceto[u]!= Integer.MAX_VALUE && (distanceto[u] + currentedge.weight < distanceto[v])) {
					System.out.println("Graph has negative edge weights :(");
				}
		}
	}
		
		for(int i=0; i<g.nodes; i++) {
			System.out.println(" --> " +i+ " : " + distanceto[i]);
		}
   }
}

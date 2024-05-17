import java.util.LinkedList;


public class BreadthFirstSearch {

		public static void main(String[] args) {
			Graph g = new Graph(8);
			g.addEdge(0, 1, 2);
			g.addEdge(0,  4, 3);
			g.addEdge(1, 2, 2);
			g.addEdge(1, 3, 4);
			g.addEdge(1,  5, 1);
			g.addEdge(2, 5, 3);
			g.addEdge(3, 6, 2);
			g.addEdge(4,  7, 1);
			g.addEdge(5, 6, 6);
			g.addEdge(6,  7, 5);
			g.addEdge(7,  3, 1);
			BFS(g, 0);
		}
		
		public static void BFS(Graph g, int n) {
			if(n>g.nodes) {
				System.out.println("invalid vertex");
			}
			else {
				boolean [] visited = new boolean[g.nodes];
				LinkedList<Integer> q = new LinkedList<Integer>();
				q.add(n);
				while(!q.isEmpty()) {
					int current = q.pollFirst();							//here lies the only difference to DFS!
					if(!visited[current]) {
						visited[current]=true;
						System.out.println("--> "+current);
						for(int i=0; i<g.neighbors.get(current).size(); i++) {
							int currentneighbor = g.neighbors.get(current).get(i);
							if(!visited[currentneighbor]) {
							q.add(currentneighbor);
							}
						}
					}
				}
			}
		}
}


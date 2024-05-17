import java.util.LinkedList;


public class ShortesPathBFS {

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
			shortestpathsfrom(0, g);
		}
		
		public static void shortestpathsfrom(int n, Graph g) {
			if(n>g.nodes) {
				System.out.println("invalid vertex");
			}
			else {
				boolean [] visited = new boolean[g.nodes];
				LinkedList<Integer> q = new LinkedList<Integer>();
				q.add(n);
				int[] isdistant = new int[g.nodes];
				isdistant[n]=0;
				while(!q.isEmpty()) {
					int current = q.pollFirst();							//here lies the only difference to DFS!
					if(!visited[current]) {
						visited[current]=true;
						for(int i=0; i<g.neighbors.get(current).size(); i++) {
							int currentneighbor = g.neighbors.get(current).get(i);
							if(!visited[currentneighbor]) {
								if(isdistant[currentneighbor]==0) {
								isdistant[currentneighbor]= isdistant[current]+1;
								}
								q.add(currentneighbor);
							}
						}
					}
				}
				for(int i=0; i<g.nodes; i++) {
					System.out.println(n + " --> " +i + ": distance = " +isdistant[i]);
				}
			}
		}
}

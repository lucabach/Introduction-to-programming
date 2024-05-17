import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;

public class isGraphAcyclic {
	
	static int[] dfspreorder;
	static int[] dfspostorder;
	
	static int[] dfspreorderof;
	static int[] dfspostorderof;
	
	static int[] topsort;
	
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
		assigndfsorders(g, 0);
		assignedgetypes(g);
		System.out.println(isGraphAcyclic(g));
		String t = topSort(g);
		System.out.println(t);
	}
	
	public static void assigndfsorders(Graph g, int n) {
		if(n>g.nodes) {
			System.out.println("invalid vertex");
		}
		else {
			dfspreorder = new int[g.nodes];
			dfspostorder = new int[g.nodes];
			int[] previous = new int[g.nodes];
			boolean [] visited = new boolean[g.nodes];
			boolean gotunvisitedneighbors = false;;
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.add(n);
			
			int precount = 0;
			int postcount =0;
			int last = -1;
			
			while(!q.isEmpty()) {
				int current = q.pollLast();							//here lies the only difference to BFS!
				if(!visited[current]) {
					visited[current]=true;
					
					dfspreorder[precount]=current;
					precount++;
					
					
					for(int i=0; i<g.neighbors.get(current).size(); i++) {
						int currentneighbor = g.neighbors.get(current).get(i);
						if(!visited[currentneighbor]) {
						previous[currentneighbor]=current;
						q.add(currentneighbor);
						gotunvisitedneighbors = true;
						}
					}
						
					int currentog = current;
						while(!gotunvisitedneighbors){	
							dfspostorder[postcount]=current;
							postcount++;
							current = previous[current];
							if(current ==n) {
								dfspostorder[postcount] = current;
								break;
							}
							for(int i=0; i<g.neighbors.get(current).size(); i++) {
								int currentneighbor = g.neighbors.get(current).get(i);
								if(!visited[currentneighbor]) {
								gotunvisitedneighbors = true;
								}
							}
						}
						last = currentog;
						gotunvisitedneighbors = false;
				}
			}
		}
		
			dfspreorderof = new int[g.nodes];
			dfspostorderof = new int[g.nodes];
			
		for(int i=0; i<g.nodes; i++) {
			dfspreorderof[dfspreorder[i]]=i;
			dfspostorderof[dfspostorder[i]]=i;
		}
	}
	
	public static void assignedgetypes(Graph g) {
		for(int i=0; i<g.nodes; i++) {
			ArrayList<Edge> current = g.edge.get(i);
			int size = current.size();
			for(int j=0; j<size; j++) {
				Edge currentEdge = current.get(j);
				int u= currentEdge.u;
				int v = currentEdge.v;
				if(dfspreorderof[u]<dfspreorderof[v] && dfspostorderof[v]<dfspostorderof[u]) {
					currentEdge.type = "tree";
				}
				else if(dfspreorderof[u]>dfspreorderof[v] && dfspostorderof[v]>dfspostorderof[u]) {
					currentEdge.type = "back";
				}
				else if(dfspreorderof[u]>dfspostorderof[v]){
						currentEdge.type = "cross";
				}
				else {
					currentEdge.type = "forward";
				}
			}
	}
	}
	
	public static boolean isGraphAcyclic(Graph g) {
		for(int i=0; i<g.nodes; i++) {
			ArrayList<Edge> current = g.edge.get(i);
			int size = current.size();
			for(int j=0; j<size; j++) {
				Edge currentEdge = current.get(j);
				if(currentEdge.type.equals("back")) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static String topSort(Graph g) {
		boolean acyclic = isGraphAcyclic(g);
		if(!acyclic) {
			return "graph contains cycles, has therefore no topological sorting.";
		}
		else {
			topsort = new int[g.nodes];
			int j = topsort.length -1;
			String t = "";
			for(int i=0; i<topsort.length; i++) {
				topsort[i]=dfspostorder[j];
				t.concat(topsort[i] +" ");
				j--;
			}
			return t;
		}
	}
}

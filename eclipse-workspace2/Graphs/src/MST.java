import java.util.ArrayList;
import java.util.*;

public class MST {

	static ArrayList<Edge> mst = new ArrayList<>();
	static int mstweight;
	
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
		kruskal(g);
	}

	
	public static void kruskal(Graph g) {
		UnionFind uf = new UnionFind(g.nodes);
		Edge[] edges = new Edge[g.edges];
		int k=0;
		for(int i=0; i<g.nodes; i++) {
			for(int j=0; j<g.edge.get(i).size(); j++) {
				Edge currentEdge = g.edge.get(i).get(j);
				edges[k]=currentEdge;
				k++;
			}
		}
		
		for(int i=0; i<edges.length; i++) {
			for(int j=i; j<edges.length; j++) {
				if(edges[j].weight<edges[i].weight) {
					Edge swap =edges[i];
					edges[i]=edges[j];
					edges[j]=swap;
				}
			}
		}
		
		System.out.print("MST: { ");
		
		for(int i=0; i<edges.length; i++) {
			Edge currentEdge = edges[i];
			int u = currentEdge.u;
			int v = currentEdge.v;
			if(uf.find(u)!=uf.find(v)) {
				mst.add(currentEdge);
				System.out.print(" ("+u+ ", "+v+ ")");
				mstweight += currentEdge.weight;
				uf.unify(u, v);
			}
		}
		
		System.out.print(" }");
		System.out.println();
		System.out.println("weight: " +mstweight);
	}
	
	

	
}

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.util.*;

public class Graph {
	
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
		g.floydWarshall();
	}
	
	int nodes;
	int edges;
	ArrayList<ArrayList<Integer>> neighbors;
	ArrayList<ArrayList<Edge>> edge;
	
	String type; //edge weights
	
	public boolean isAcyclic;
	static Edge backEdge;
	
	static int[] dfspreorder;
	static int[] dfspostorder;
	
	static int[] dfspreorderof;
	static int[] dfspostorderof;
	
	static int[] topsort;
	
	
	static int source;
	static int[] distanceto;
	static boolean[] visited;
	static int[] parent;
	
	
	static ArrayList<Edge> mst = new ArrayList<>();
	static int mstweight;
	
	
	Graph(int n) {
		this.nodes = n;
		neighbors = new ArrayList<ArrayList<Integer>>();
		edge = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<n; i++) {
			ArrayList<Integer> currentList = new ArrayList<>();
			neighbors.add(currentList);
			
			ArrayList<Edge> currentEdgeList = new ArrayList<>();
			edge.add(currentEdgeList);
		}
	}
	
	
	
	public void addEdge(int u, int v, int weight) {
		neighbors.get(u).add(v);
		edge.get(u).add(new Edge(u, v, weight));
		edges++;
	}
	
	
	
	public static void DFS(Graph g, int n) {
		if(n>g.nodes) {
			System.out.println("invalid vertex");
		}
		else {
			boolean [] visited = new boolean[g.nodes];
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.add(n);
			while(!q.isEmpty()) {
				int current = q.pollLast();							//here lies the only difference to BFS!
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
	

	public static void shortestpathsfrom(int n, Graph g) {  //BFS in 1-weighted graph
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
					backEdge = currentEdge;
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
						updated = true;
					}
			}
		}
			if(!updated) {
				break;
			}
		}
		
		
		for(int j=0; j<g.nodes; j++) {													//once more to check if there is a negative edge cycle						
			for(int k=0; k< g.edge.get(j).size(); k++) {
				Edge currentedge = g.edge.get(j).get(k);
				int u = currentedge.u;
				int v = currentedge.v;
				if(distanceto[u]!= Integer.MAX_VALUE && (distanceto[u] + currentedge.weight < distanceto[v])) {
					System.out.println("Graph has negative edge cycle :(");
				}
		}
	   }
		
		for(int i=0; i<g.nodes; i++) {
			System.out.println(" --> " +i+ " : " + distanceto[i]);
		}
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
	
	public static void graphAnalysis(Scanner scanner) {
		System.out.println("number of nodes?");
		int nodes = scanner.nextInt();
		Graph g = new Graph(nodes);
		System.out.println("Now add edges as follows: if you want to add the edge {u, v} with weight c symply type: u v c (and enter). when you are done adding edges, type: -1");
		while(scanner.nextInt() != -1) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int c = scanner.nextInt();
			g.addEdge(u, v, c);
		}
		System.out.println("Choose the number of your favorite node!");
		int favnode = scanner.nextInt();
		boolean weightedconstant= true;
		boolean weightedpositive=false;
		boolean weightednegative = false;
		for(int i=0; i<nodes; i++) {
			for(int j=0; j < g.edge.get(i).size(); j++) {
				Edge current = g.edge.get(i).get(j);
				if(current.weight<0) {
					weightednegative = true;
					weightedpositive = false;
					weightedconstant = false;
					break;
				}
				else if (current.weight>1) {
					weightedpositive = true;
					weightedconstant = false;
				}
			}
		}
		if(weightedconstant) {
			g.type = "constant weighted";
		}
		else if(weightedpositive) {
			g.type = "positive weighted";
		}
		else {
			g.type = "negartive weighted";
		}
		
		System.out.println("Cute graph! Using DFS we found out that it looks as follows:");
		System.out.println();
		DFS(g, 0);
		System.out.println();
		
		assigndfsorders(g, favnode);
		assignedgetypes(g);
		
		
		if(isGraphAcyclic(g)) {
			g.isAcyclic = true;
		}
		
		if(g.isAcyclic) {
			String tsort = topSort(g);
			System.out.println("Since your graph is acyclic, we could compute its topological sorting. It looks as follows: ");
			System.out.println(tsort);
		}
		else {
			Edge bedge = g.backEdge;
			System.out.println("The inputed graph is not acyclic since it contains a cycle concerning the edge {" + bedge.u + " " + bedge.v + "} . Hence it has no topological sorting.");
		}
	}
	
	
	public void floydWarshall() {
		int[][] dfromto = new int[nodes][nodes];
		for(int i=0; i<nodes; i++) {
			for(int j=0; j<nodes; j++) {
				if(i==j) {
					dfromto[i][j]=0;
				}
				else {
					dfromto[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		for(int i=0; i<nodes; i++) {
			for(int j=0; j<neighbors.get(i).size(); j++) {
				int v = neighbors.get(i).get(j);
				Edge curedge = edge.get(i).get(j);
				dfromto[i][v]=curedge.weight;
			}
		}
		
		for(int i=0; i<nodes; i++) {
			for(int j=0; j<nodes; j++) {
				for(int k=0; k<nodes; k++) {
					if(dfromto[i][k] == Integer.MAX_VALUE || dfromto[k][j]==Integer.MAX_VALUE) {
						continue;
					}
					else if(dfromto[i][k] + dfromto[k][j] < dfromto[i][j]) {
						dfromto[i][j]=dfromto[i][k] + dfromto[k][j];
					}
				}
			}
		}
		
		for(int i=0; i<nodes; i++) {
			if(dfromto[i][i]<0) {
				System.out.println("negative cycle :(");
				return;
			}
		}
		
		System.out.println();
		System.out.print("    0");
		for(int i=1; i<nodes; i++) {
			System.out.print("  "+i+" ");
		}
		
		for(int i=0; i<nodes; i++) {
			System.out.println();
			System.out.print(i+ " ");
			for(int j=0; j<nodes; j++) {
				if(dfromto[i][j]==Integer.MAX_VALUE) {
					dfromto[i][j]=0;
				}
				System.out.print("  " + dfromto[i][j] + " ");
			}
	    }
	}
}


package Graph1;

import java.util.*;

public class Graph {
	private Node[] nodes;
	private int noOfNodes;
	private Edge[] edges;
	private int noOfEdges;
	
	
	public Node[] getNodes() {
		   return nodes;
	}
	public int getNoOfNodes() {
		   return noOfNodes;
	}
	public Edge[] getEdges() {
		   return edges;
	}
    public int getNoOfEdges() {
		   return noOfEdges;
    }
	
	
	public Graph(Edge[] edges){
		this.edges = edges;
		this.noOfNodes = calculateNoOfNodes(edges);
		
	}
	
	
	public int calculateNoOfNodes(Edge[] edges){
		List<Integer> visited = new ArrayList<>();
		for (Edge e : edges) {
			if(!visited.contains(e.getFromNodeIndex())) {
				visited.add(e.getFromNodeIndex());
			}
			if(!visited.contains(e.getToNodeIndex())) {
				visited.add(e.getToNodeIndex());
			}
		}
		return visited.size();
	}
	
	public void calculateShortestDistances() {
	    this.nodes[0].setDistanceFromSource(0);
	    int nextNode = 0;
	    
	    for (int i=0; i<this.nodes.length; i++) {
	    	ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
	    	
	    	for (int joinedEdge = 0; joinedEdge<currentNodeEdges.size(); joinedEdge++) {
	    		int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
	    		
	    		if (!this.nodes[neighbourIndex].isVisited()) {
	    			
	    			int tentative = this.nodes[nextNode].getDistanceFromSource() 
	    				            + currentNodeEdges.get(joinedEdge).getLength();
	    			
	    	          if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
	    	              nodes[neighbourIndex].setDistanceFromSource(tentative);
	    	            }
	    	          }
	    	        }
	    	
	    nodes[nextNode].setVisited(true);
	    nextNode = getNodeShortestDistanced();
	    }
	}
	    			
	
	
	public int getNodeShortestDistanced() {
		int storedNodeIndex = 0;
		int storedDist = Integer.MAX_VALUE;
		
	    for (int i = 0; i < this.nodes.length; i++) {
	        int currentDist = this.nodes[i].getDistanceFromSource();
	        if (!this.nodes[i].isVisited() && currentDist < storedDist) {
	          storedDist = currentDist;
	          storedNodeIndex = i;
	        }
	      }
	      return storedNodeIndex;
	}
	
	
	public void printResult() {
		String output = "Number of nodes = " + this.noOfNodes;
		output += "\nNumber of edges = " + this.noOfEdges;
		for (int i = 0; i < this.nodes.length; i++) {
		output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
		}
		System.out.println(output);
    }
	
	

	
}
	
	


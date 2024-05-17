public class Node {
	
	private Node outer;
	private Node inner;
	boolean set;
	int parents;
	
	public Node(Node outer, Node inner) {		
		setOuter(outer);
		setInner(inner);
		set = false;
		parents = 0;
	}
	
	public Node getOuter() {
		return outer;
	}
	
	public void setOuter(Node outer) {
		this.outer = outer;
	}
	
	public Node getInner() {
		return inner;
	}
	
	public void setInner(Node inner) {
		this.inner = inner;
	}	

}

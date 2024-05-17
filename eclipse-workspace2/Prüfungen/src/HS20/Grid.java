package HS20;


public class Grid {
	
	public static void main(String[] args) {
		Node n00 = new Node(null, null);
		Node n01 = new Node(null, null);
		n00.setRight(n01);
		Node n10 = new Node(null, null);
		n00.setBottom(n10);
		Node n11 = new Node(null, null);
		
		n01.setBottom(n11);
		n10.setRight(n11);
		
		Grid.adjustGrid(n00, 3, 2);
		System.out.println("Executed main for Grid");
	}
	
	public static void adjustGrid(Node origin, int A, int B) {
	Node current = origin;
	int N = 1;
	while (current.getBottom()!=null) {
		current = current.getBottom();
		N++;
	}
	current = origin;
	int M = 1;
	while (current.getRight()!=null) {
		current = current.getRight();
		M++;
	}
	

	if(N>A) {
	int count = 1;
	current = origin;
	while(count<A) {
		current = current.getBottom();
		count++;
	}
	current.setBottom(null);
	count = 1;
	while(count<B) {
		current=current.getRight();
		current.setBottom(null);
		count++;
	}
	}
	
	
	if(M>B) {
		int count = 1;
		current = origin;
		while(count<B) {
			current = current.getRight();
			count++;
		}
		current.setRight(null);
		count = 1;
		while(count<A) {
			current=current.getBottom();
			current.setRight(null);
			count++;
		}
	}
	

		
	
	}
}


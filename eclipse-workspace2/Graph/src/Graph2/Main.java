package Graph2;

public class Main {

	public static void main(String[] args) {
		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		zero.neighbours.add(one);
		zero.neighbours.add(two);
		one.neighbours.add(five);
		two.neighbours.add(three);
		two.neighbours.add(four);
		Graph graph = new Graph(zero, 6);
		System.out.println(one.maxdistance);
		}
	
}

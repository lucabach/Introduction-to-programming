//Veraendern Sie diese Datei nicht!

public class Node {
	
	private Node left, right;
	public Node parent;
	
	public Node(Node left, Node right) {
		this.setLeft(left);
		this.setRight(right);
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
		this.left.parent = this;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
		this.right.parent = this;
	}

}

public class Pyramid {
	int level;
	
	public Pyramid(int level) {
		this.level = level;
	}
	
	public static boolean isPyramid(Node node) {
		// TODO: Implementieren Sie die Methode   
	
			return isPyramid(node.getLeft(),node.getRight());
	}
	public static boolean isPyramid(Node l, Node r) {
		if(l==null && r==null) {
			return true;
		}
		else if((l==null && r!=null) || (r==null && l!=null)) {
			return false;
		}
		else {
			if(l.parent.getRight().getLeft()== r.parent.getLeft().getRight()) {
				return isPyramid(l.getLeft(), l.getRight()) && isPyramid(r.getLeft(), r.getRight());
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Node pyramid = new Node(
			new Node(null, null),
			new Node(null, null));
        System.out.println("result: " + isPyramid(pyramid));
	}

}

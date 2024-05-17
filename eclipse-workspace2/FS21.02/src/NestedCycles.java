import java.util.*;

public class NestedCycles {
	
	public static void main(String[] args) {
		Node n1 = new Node(null, null);
		Node n2 = new Node(null, null);
		n1.setOuter(n2);
		n2.setOuter(n1);
		
		System.out.println(isNestedCycle(n1)); //expected: true
		Map<Node, Integer> dist = cycleDistance(n1);
		System.out.println("Distance size: " + dist.size()); //expected: 2
		System.out.println("Distance from n1 to n1: " + dist.get(n1)); //expected: 0
		System.out.println("Distance from n1 to n2: " + dist.get(n2)); //expected: 1
	}
	
	public static Map<Node, Integer> cycleDistance(Node n0) {
		//TODO
		Map<Node, Integer> m = new HashMap<>();
		m.put(n0,  0);
		Node current = n0.getOuter();
		int distance = 1;
		while(current != n0) {
			m.put(current, distance);
			distance++;
			current = current.getOuter();
		}
		return m;
	}
	
	public static boolean isNestedCycle(Node n0) {
		//TODO
		int countnew = 1;
		int countold = 1;
		int count = 1;
		Node current = n0.getOuter();
		int i = 0;
		try {
		while(current!=n0) {
			i++;
			if(i==999) {
				return false;
			}
			count++;
			countnew += current.parents;
			current.getInner().parents++;
			if(current.getInner()==null) {
				n0 = current;
				current = n0.getOuter();
				break;
			}
			current = current.getOuter();
			if(current == n0) {
				if(countnew != countold) {
					return false;
				}
				else {
					System.out.println("new cycle");
					countold = count;
					countnew = 0;
					count = 0;
					current = current.getInner();
					n0=current;
					current=current.getOuter();
				}
			}
		}
		
		}catch(Exception e) {return false;}
		while(current != n0) {
			if (current.getInner() != null) {
				return false;
			}
		}
		return true;
	}
}

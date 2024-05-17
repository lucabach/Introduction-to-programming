package FS21;

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
		Map<Node, Integer> cycleDistance = new HashMap<>();
		cycleDistance.put(n0, 0);
		List<Node>circle = new ArrayList<>();
		Node current = n0;
		circle.add(current);
		while (current.getOuter()!=n0) {
			circle.add(current.getOuter());
			current = current.getOuter();
		}
		int distance = 1;
		for (int i = 1; i<circle.size(); i++) {
			Node n = circle.get(i);
			cycleDistance.put(n, distance);
			distance++;
		}
		return cycleDistance;
	}
	
	public static boolean isNestedCycle(Node n0) {
		try {
		Node current = n0;
		while (current.getOuter() != n0) {
			if (current.getInner() != null && current.getOuter().getInner()== null
				||current.getInner() == null && current.getOuter().getInner()!=null) {
				return false;
			}
			current = current.getOuter();
		}
		}
		catch (Exception e) {
			return false;
		}
		Node current = n0.getInner();
		if (current == null) {
			return true;
		}
		return isNestedCycle(current);	
	}
}

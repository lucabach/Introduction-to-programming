import java.util.*;
public class GraphExecution {
	static ArrayList<Node[]> childrenn1 = new ArrayList<>();
	static ArrayList<Node[]> children = new ArrayList<>();
	static boolean[] modified;
	static boolean[] modified2;
	
	static boolean isSubProgram(Node n1, Node n2) {
		// TODO
		String type2 = n2.type;
		Node[] childrenn2 = n2.getSubnodes();
		if(type2.equals("ADD")) {
			int value = n2.getValue();
			boolean found = search (n1, value);
			return found;
		}
		else {
			searchchildren(n1, childrenn2.length, false);
			boolean[] trance = new boolean[childrenn1.size()];
			for(int i=0; i<childrenn1.size(); i++) {
				Node[] current = childrenn1.get(i);
				modified = new boolean[current.length];
				for(int j=0; j<childrenn2.length; j++) {
				Node currentn2 = childrenn2[j];
				if(currentn2.getType().equals("ADD")) {
					for(int k=0; k<current.length; k++) {
						if(current[k].getType().equals("ADD")) {
						if(!modified[k]) {
							if(current[k].getValue() == currentn2.getValue()) {
								modified[k]=true;
								break;
							}
						}
						}
					}
				}
				else {
					for(int k=0; k<current.length; k++) {
						if(current[k].getType().equals("SEQ")) {
							if(!modified[k]) {
								if(checkifequivalent(current[k], currentn2));
								modified[k]=true;
								break;
							}
						}
					}
				}
			}
			boolean mod = true;
			for(int j=0; j<modified.length; j++) {
				if(!modified[j]) {
					mod=false;
				}
				modified[j]=false;
			}
			trance[i]=mod;		
		}
			for(int i=0; i<childrenn1.size(); i++) {
				if (trance[i]) {
					return true;
				}
			}
			return false;
		}
	}
	
	
	static boolean checkifequivalent(Node n1, Node n2) {
		if(n1.getSubnodes().length != n2.getSubnodes().length) {
			return false;
		}
		else {
			modified2 = new boolean[n1.getSubnodes().length];
			for(int i=0; i<n2.getSubnodes().length; i++) {
				Node current2 = n2.getSubnodes()[i];
				for(int j=0; j<n1.getSubnodes().length; j++) {
					if(!modified2[j]) {
						if(n1.getSubnodes()[j].getValue() == current2.getValue()) {
							modified2[j]=true;
							break;
						}
					}
				}
			}
			boolean mod = true;
			for(int i=0; i<modified2.length; i++) {
				if(!modified2[i]) {
					mod = false;;
				}
				modified2[i]=false;
			}
			return mod;
		}
	}
	
	
	static boolean search(Node n1, int value) {
		if(n1.getType().equals("ADD")) {
			return n1.getValue() == value;
		}
		else {
			Node[] n1subnodes = n1.getSubnodes();
			for(int i=0; i<n1.getSubnodes().length; i++) {
				boolean found = search(n1subnodes[i], value);
				if(found) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static void searchchildren(Node n1, int length, boolean t){
		Node[] currentchildren = n1.getSubnodes();
		if(currentchildren.length == length) {
			if(!t) {
			childrenn1.add(currentchildren);
			}
			else {
			children.add(currentchildren);
			}
		}
		for(int i=0; i<currentchildren.length; i++) {
			searchchildren(currentchildren[i], length, t);
		}
	}

}

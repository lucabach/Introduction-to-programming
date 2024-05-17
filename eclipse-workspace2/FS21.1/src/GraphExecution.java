import java.util.List;
import java.util.*;


public class GraphExecution {
	
	
	public static List<ProgramState> allResults(Node n, ProgramState initState) {
		//TODO
		helperresults(n);
		List<ProgramState> res = new ArrayList<ProgramState>();
		for(int i=0; i<n.pstates.size(); i++) {
			ProgramState cur = n.pstates.get(i);
			ProgramState mod = new ProgramState(cur.getSum()+initState.getSum(), cur.getCounter()+initState.getCounter());
			res.add(mod);
		}
		return res;
	}
	
	public static void helperresults(Node n) {
		if(n.getType().equals("ADD")) {
			n.pstates.add(new ProgramState(n.getValue(), 1));
			return;
		}
		else if(n.getType().equals("SEQ")) {
			for(int i=0; i<n.getSubnodes().size(); i++) {
				Node current = n.getSubnodes().get(i);
				helperresults(current);
			}
			List<ProgramState> nstates = new ArrayList<ProgramState>();
			List<Node> sub = new ArrayList<Node>(n.getSubnodes());
			n.pstates = concat(sub, nstates);
		}
		else {
			for(int i=0; i<n.getSubnodes().size(); i++) {
				Node current = n.getSubnodes().get(i);
				helperresults(current);
				for(int j=0; j<current.pstates.size(); j++) {
				n.pstates.add(current.pstates.get(j));
				}
			}
		}
	}
	
	public static List<ProgramState> concat(List<Node> subnodes, List<ProgramState> states){
		if(oneListEmpty(subnodes)) {
			return states;
		}
		else {
			ProgramState p = new ProgramState(0, 0);
			int maxsize = -1;
			int maxindex = -1;
			int curvalue = 0;
			int curcounter = 0;
			for(int i=0; i<subnodes.size(); i++) {
				Node cur = subnodes.get(i);
				ProgramState curstate = cur.pstates.get(0);
				curvalue += curstate.getSum();
				curcounter += curstate.getCounter();
				if(cur.pstates.size()>maxsize) {
					maxsize = cur.pstates.size();
					maxindex = i;
				}
			}
			ProgramState pi = new ProgramState(curvalue, curcounter);
			states.add(pi);
			subnodes.get(maxindex).pstates.remove(0);
			return concat(subnodes, states);
		}
	}
	
	public static boolean oneListEmpty(List<Node> subnodes) {
		for(int i=0; i<subnodes.size(); i++) {
			Node cur = subnodes.get(i);
			if(cur.pstates.isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public static void sort(List<List<ProgramState>> input) {
		//TODO
		HashMap<ProgramState, List<ProgramState>> maxmap = new HashMap<ProgramState, List<ProgramState>>();
		ProgramState[] max = new ProgramState[input.size()];
		for(int i=0; i<input.size(); i++) {
			List<ProgramState> curList = input.get(i);
			ProgramState maxState = (ProgramState) curList.get(0);
			for(int j=1; j<curList.size(); j++) {
				ProgramState curState = (ProgramState) curList.get(j);
				if(curState.getSum()>maxState.getSum()||
					(curState.getSum() == maxState.getSum() && curState.getCounter()>=maxState.getCounter())){
					maxState=curState;
				}
			}
			max[i]=maxState;
			maxmap.put(maxState, curList);
		}
		for(int i=0; i<input.size(); i++) {
			for(int j=i+1; j<input.size(); j++) {
				if(max[j].getSum()>max[i].getSum()||
						(max[j].getSum() == max[i].getSum() && max[j].getCounter()>=max[i].getCounter())){
						ProgramState temp = max[i];
						max[i]=max[j];
						max[j]=temp;
			}
		}
		}
		int n = input.size();
		input.clear();
		for(int i=0; i<n; i++) {
			List<ProgramState> cur = maxmap.get(max[i]);
			input.add(cur);
		}
	}
	
	public static boolean isSubProgram(Node n1, Node n2) {
		//TODO	
		if(areequivalent(n1, n2)){
			return true;
		}
		
		else {
			for(int i=0; i<n1.getSubnodes().size(); i++) {
				Node cur = n1.getSubnodes().get(i);
				if(isSubProgram(cur, n2)) {
					return true;
				}
		    }
			return false;
		}
	}
	
	public static boolean areequivalent(Node n1, Node n2) {
		if(!n1.getType().equals(n2.getType())) {
			return false;
		}
		else if (n1.getType().equals("ADD")) {
			if(n1.getValue() == n2.getValue()) {
				return true;
			}
			return false;
		}
		else {
			if(n1.getSubnodes().size()==n2.getSubnodes().size()) {
				boolean[] taken = new boolean[n1.getSubnodes().size()];
				for(int i=0; i<taken.length; i++) {
					Node current = n1.getSubnodes().get(i);
					for(int j=0; j<taken.length; j++) {
						if(!taken[j]) {
							Node curcur = n2.getSubnodes().get(j);
							if(areequivalent(current, curcur)) {
								taken[j]=true;
							}
						}
					}
				}
				for(int i=0; i<taken.length; i++) {
					if(!taken[i]) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
	}
}
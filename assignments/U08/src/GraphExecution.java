
public class GraphExecution {
	
static LinkedProgramStateList results;

public GraphExecution() {
	this.results = new LinkedProgramStateList();
}
	
	public static LinkedProgramStateList allResults(Node n, ProgramState initState) {
		// TODO
		LinkedProgramStateList l = new LinkedProgramStateList();
		helperfunc(n);
		return n.possiblestates;
		}
	
	public static void helperfunc(Node n) {
		if(n.subnodes.length==0) {
				n.possiblestates.addLast(new ProgramState(n.value, 1));
		}
		else {
			if(n.type.equals("SEQ")) {
				for(int i=0; i<n.subnodes.length; i++) {
					Node current = n.subnodes[i];
					helperfunc(current);
				}
				LinkedProgramStateList[] l = new LinkedProgramStateList[n.subnodes.length];
				for(int i=0; i<n.subnodes.length; i++) {
					Node current = n.subnodes[i];
					l[i]= current.possiblestates;
				}
				LinkedProgramStateList w = concat(l);
				n.possiblestates=w;
			}
			else {
				LinkedProgramStateList[] l = new LinkedProgramStateList[n.subnodes.length];
				for(int i=0; i<n.subnodes.length; i++) {
					Node current = n.subnodes[i];
					helperfunc(current);
					l[i]=current.possiblestates;
				}
				LinkedProgramStateList lp = arraytolinkedlist(l);
			}
		}
	}


	
	
	public static LinkedProgramStateList addResults(Node n, ProgramState initState) {
		Node[] children = n.getSubnodes();
		String type = n.getType();
		LinkedProgramStateList pstate = new LinkedProgramStateList();
		
		//BASE CASES
		if(children.length==0) {
			if(n.type=="ADD") {
				pstate.addFirst(new ProgramState(n.value, 1));
				return pstate;
			}
			else {
				pstate.addFirst(new ProgramState(0, 0));
				return pstate;
			}
		}
		
		
		//RECURSION
		else {
			if (type.equals("ADD")) {
				pstate.addFirst(new ProgramState(n.value+ initState.getSum(), 1+initState.getCounter()));
				return pstate;
			}
			else if(type.equals("CHOICE")) {
				LinkedProgramStateList[] pstates = new LinkedProgramStateList[children.length];
				for(int i=0; i<children.length; i++) {
					pstates[i] = addResults(children[i], new ProgramState(0, 0));
				}
				pstate = arraytolinkedlist(pstates);
				return pstate;
			}
			else {
				LinkedProgramStateList[] pstates = new LinkedProgramStateList[children.length];
				for(int i=0; i<children.length; i++) {
					pstates[i] = addResults(children[i], new ProgramState(0, 0));
				}
				pstate = concat(pstates);
				return pstate;
			}
		}	
	}
	
	
	
	
	public static LinkedProgramStateList arraytolinkedlist(LinkedProgramStateList[] pstates) {
		LinkedProgramStateList pstate = new LinkedProgramStateList();
		for(int i=0; i<pstates.length; i++) {
			LinkedProgramStateList currentList = pstates[i];
			for(int j =0; j<currentList.size; j++) {
				ProgramState currentProgram = currentList.get(j);
				pstate.addFirst(currentProgram);
			}
		}
		return pstate;
	}
	
	
	public static LinkedProgramStateList concat(LinkedProgramStateList[] pstates) {
		if(pstates.length == 1) {
			return pstates[0];
		}
		else {
			LinkedProgramStateList newlist = new LinkedProgramStateList();
			for(int i=0; i<pstates[0].size; i++) {
				for(int j=0; j<pstates[1].size; j++) {
					int newsum = pstates[0].get(i).getSum() + pstates[1].get(j).getSum();
					int newcounter = pstates[0].get(i).getCounter() + pstates[1].get(j).getCounter();
					newlist.addFirst(new ProgramState(newsum, newcounter));
				}
			}
			LinkedProgramStateList [] pstatesnew = new LinkedProgramStateList[pstates.length-1];
			pstatesnew[0] = newlist;
			for(int i=1; i<pstatesnew.length; i++) {
				pstatesnew[i] = pstates[i+1];
			}
			return concat(pstatesnew);
		}
	}
	
	public static void print(LinkedProgramStateList pstate) {
		for(int i=0; i<pstate.size; i++) {
			System.out.print("(" + pstate.get(i).getSum() + ", " +pstate.get(i).getCounter()+ ") ");
		}
		System.out.println();
	}



}

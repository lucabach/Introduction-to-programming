import java.util.Set;
import java.util.*;

public class CCompany {
	
	ArrayList<Resource> resources;
	ArrayList<BauStelle> baustellen;
	boolean given;
		
	public CCompany() {
		// TODO
		resources = new ArrayList<Resource>();
		baustellen = new ArrayList<BauStelle>();
		given = false;
	}
	
	public Set<Resource> resources() {
		// TODO
		Set<Resource> s = new HashSet<Resource>();
		for(int i=0; i<resources.size(); i++) {
			s.add(resources.get(i));
		}
		return s;
	}
	
	public void add(Resource resource) {
		// TODO
		resources.add(resource);
		return;
	}
	
	public void nextDay() {
		
		// TODO
		if(given) {
		for(int i=0; i<baustellen.size(); i++) {
			BauStelle current = baustellen.get(i);
			if(current.dynamic) {
				for(int x: current.containedtypes) {
					if(current.quantities.get(x) > current.flowlimit) {
						int dif = current.quantities.get(x)-current.flowlimit;
						System.out.println(dif);
						int count =0;
						
						for(int j=current.orderedres.size()-1; j>=0; j--) {
							
							if(count == dif) {
								break;
							}
							Resource cur = current.orderedres.get(j);
							System.out.println(cur.type());
							System.out.println(x);
							if(cur.type() == x) {
								current.orderedres.remove(j);
								current.resources.remove(cur);
								resources.add(cur);
								count++;
							}
						}
						current.quantities.put(x, current.flowlimit);
					}
				}
			}	
		}
		}
		given = true;
		
		for(int i=0; i<baustellen.size(); i++) {
			BauStelle current = baustellen.get(i);
			for(int j=0; j<resources.size(); j++) {
				Resource curres = resources.get(j);
				if(current.canAdd(curres)) {
					current.add(curres);
					resources.remove(j);
					j--;
				}
			}
		}
	}
	
	public CSite createCSite(int type) {
		// Aendern Sie diese Methode, falls Sie Task (a) nicht geloest haben.
		return createCSite(Set.of(type), 2);
	}

	public CSite createCSite(Set<Integer> types, int limit) {
		// TODO
		BauStelle b = new BauStelle(types, limit, this);
		baustellen.add(b);
		return b;
	}
	
	public CSite createCSite(Set<Integer> types, int limit, int flowLimit) {
		// TODO
		BauStelle b = new BauStelle(types, limit, this);
		b.dynamic = true;
		b.flowlimit = flowLimit;
		baustellen.add(b);
		return b;
	}
}




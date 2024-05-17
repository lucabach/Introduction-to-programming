import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CCompany {
	
	Set<Resource> resources = new LinkedHashSet<Resource>();
	public ArrayList<Site> sites = new ArrayList<Site>();

	
	public Set<Resource> resources() {
		// TODO
		return resources;
	}

	public void add(Resource resource) {
		// TODO
		resources.add(resource);
	}

	public void nextDay() {
		// TODO
		for (Site site : sites) {
			if (site.flowLimit != -1) {
				Set<Resource> copy = new HashSet<>();
				for (Resource x : site.resources()) {
					copy.add(x);
				}
				for (Resource x : copy) {
					if (site.map.get(x.type()) > site.flowLimit) {
						for (int i = 0; i < site.map.get(x.type()) - site.flowLimit; i++) {
							List<Resource> list = new ArrayList<>(site.resources);
							Collections.reverse(list);
							for (Resource y : list) {
								if (y.type() == x.type()) {
									site.resources.remove(y);
									resources.add(y);
									break;
								}
							}
						}
						site.map.put(x.type(), site.flowLimit);
					}
				}
			}
		}

		Set<Resource> copy = new LinkedHashSet<Resource>();
		for (Resource x : resources) {
			copy.add(x);
		}
		Iterator<Resource> it = copy.iterator();

		while (it.hasNext()) {
			
			Resource i = it.next();
			
			for (Site site : sites) {
				
				if (site.canAdd(i)) {
					site.add(i);
					resources.remove(i);
					
					break;
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
		Site site = new Site(types, limit);
		sites.add(site);
		return site;
	}

	public CSite createCSite(Set<Integer> types, int limit, int flowLimit) {
		// TODO
		Site site = new Site(types, limit, flowLimit);
		sites.add(site);
		return site;
	}
	
}




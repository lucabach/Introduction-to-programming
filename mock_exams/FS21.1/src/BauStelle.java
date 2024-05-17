import java.util.Set;
import java.util.*;

public class BauStelle implements CSite {
	
	Set<Integer> types;
	Set<Integer> containedtypes;
	int limit;
	Set<Resource> resources;
	HashMap<Integer, Integer> quantities;
	ArrayList<Resource> orderedres;
	CCompany company;
	boolean dynamic;
	int flowlimit;
	
	
	public BauStelle(Set<Integer>types, int limit, CCompany company) {
		this.types=types;
		this.limit=limit;
		this.resources = new HashSet<Resource>();	
		quantities = new HashMap<Integer, Integer>();
		containedtypes = new HashSet<Integer>();
		this.company = company;
		this.dynamic = false;
		this.orderedres = new ArrayList<Resource>();
	}
	
	
	public Set<Resource> resources(){
		return this.resources;
	}
	
	public boolean canAdd(Resource resource) {
		int t = resource.type();
		if(types.contains(t)) {
			if(!containedtypes.contains(resource.type())) {
				return true;
			}
			int typequantity = quantities.get(resource.type());
			if(typequantity<limit) {
				return true;
			}
		}
		return false;
	}
	
	
	public void add(Resource resource) {
		if(!canAdd(resource)) {
			throw new IllegalArgumentException();
		}
		if(!containedtypes.contains(resource.type())) {
			containedtypes.add(resource.type());
			quantities.put(resource.type(), 1);
		}
		else {
		int q = quantities.get(resource.type());
		quantities.put(resource.type(), q+1);
		}
		resources.add(resource);
		orderedres.add(resource);
	}
	
	public void use(Resource resource) {
		if(!resources.contains(resource)) {
			throw new IllegalArgumentException();
		}
		int newquantity = quantities.get(resource.type())-1;
		quantities.put(resource.type(), newquantity);
		resources.remove(resource);
		if(newquantity == 0) {
			quantities.remove(resource.type());
			containedtypes.remove(resource.type());
			
		}
	}
	
	public void close() {
		company.baustellen.remove(this);
	}
}

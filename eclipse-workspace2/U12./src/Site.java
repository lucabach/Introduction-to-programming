import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Site implements CSite {
	int limit;
	int flowLimit;
	Set<Integer> types;
	Set<Resource> resources = new LinkedHashSet<Resource>();
	Map<Integer, Integer> map = new HashMap<>();

	public Site() {
		// TODO Auto-generated constructor stub
	}

	public Site(Set<Integer> types, int limit) {
		// TODO Auto-generated constructor stub

		this.limit = limit;
		this.types = types;
		flowLimit = -1;

		for (Integer i : types) {
			map.put(i, 0);
		}
	}

	public Site(Set<Integer> types, int limit, int flowLimit) {
		// TODO Auto-generated constructor stub

		this.limit = limit;
		this.flowLimit = flowLimit;
		this.types = types;

		for (Integer i : types) {
			map.put(i, 0);
		}
	}

	@Override
	public Set<Resource> resources() {
		// TODO Auto-generated method stub
		return resources;
	}

	@Override
	public boolean canAdd(Resource resource) {
		// TODO Auto-generated method stub
		if (map.get(resource.type()) == null) {
			return false;
		}
		
		int check = map.get(resource.type());
		if (types.contains(resource.type()) && check < limit)
			return true;

		return false;
	}

	@Override
	public void add(Resource resource) {
		// TODO Auto-generated method stub
		if (canAdd(resource)) {
			if (map.get(resource.type()) == null) {
				throw new IllegalArgumentException();
			}
			map.put(resource.type(), map.get(resource.type()) + 1);
			resources.add(resource);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void use(Resource resource) {
		// TODO Auto-generated method stub
		if (map.get(resource.type()) == null) {
			throw new IllegalArgumentException();
		}

		map.put(resource.type(), map.get(resource.type()) - 1);
		resources.remove(resource);

	}

	@Override
	public void close() {
		map.clear();
	}

}

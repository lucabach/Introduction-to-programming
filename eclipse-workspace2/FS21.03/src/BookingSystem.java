import java.util.*;

public class BookingSystem {
	
	public  Set<String> names;
	public Map<String, List<Los>[]> bs;
	public Map<String, Set<Produkt>> quantities;
	
	
	public BookingSystem() {
		this.bs = new HashMap<String, List<Los>[]>();
		this.names = new HashSet<String>();
		this.quantities = new HashMap<>();		
	}
	
	
	public Ticket reserve(String productName, int priority) {
		// TODO
		if(!names.contains(productName)) {
			names.add(productName);
			Set<Produkt> p = new HashSet<>();
			quantities.put(productName, p);
			List<Los>[] listtype = new ArrayList[2];
		}
		Los los = new Los(productName, priority, this);
		List<Los>[] listtype = bs.get(productName);
		List<Los> fifo = listtype[0];
		fifo.add(los);
		listtype[0]=fifo;
		
		List<Los>prio = listtype[1];
		List<Los> newprio = new ArrayList<>();
		int i=0;
		while(prio.get(i).priority>=priority) {
			newprio.add(prio.get(i));
			i++;
		}
		newprio.add(los);
		while(i<prio.size()) {
			newprio.add(prio.get(i));
			i++;
		}
		listtype[1]=newprio;
		
		bs.put(productName, listtype);
		return los;
	}
		
	
	public Ticket multiReserve(String[] productNames, int priority) {
		// TODO
		return null;
	}
	
	public void createProduct(String productName, String productKind) {
		// TODO
		String kind = productKind;
		if(!(kind.equals("fifo") || kind.equals("priority"))) {
			throw new IllegalArgumentException();
		}
			Produkt p = new Produkt(productName, productKind, this);
			Set<Produkt> x = quantities.get(productName);
			x.add(p);
			quantities.put(productName, x);
		}
	
}

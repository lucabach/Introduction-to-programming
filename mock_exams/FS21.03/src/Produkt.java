import java.util.*;

public class Produkt implements Product {
	
	String name;
	String kind;
	boolean borrowed;
	BookingSystem bs;
	List<Los> waitinglist;
	
	public Produkt(String name, BookingSystem bs) {
		this.name = name;
		this.bs = bs;
		this.kind = "fifo";
		
	}
	
	public Produkt(String name, String kind, BookingSystem bs) {
		this.name = name;
		this.kind = kind;
		this.borrowed = false;
		this.bs = bs;
	}
	
	public String name() {
		return this.name;
	}
	
	public String kind() {
		return this.kind;
	}
	
	public void giveBack() {
		if(!borrowed) {
			throw new IllegalArgumentException();
		}
		else {
			Set<Produkt> s = bs.quantities.get(name);
			s.add(this);
			bs.quantities.put(name, s);
		}
	}
}

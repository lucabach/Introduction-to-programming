import java.util.*;

public class Los implements Ticket {
	
	public BookingSystem bs;
	int priority;
	String name;
	boolean isReady;
	boolean gotProduct;
	
	Produkt produkt;
	
	public Los(String name, int priority, BookingSystem bs) {
		this.bs = bs;
		this.name = name;
		this.priority = priority;
		this.isReady = false;
		this.gotProduct = false;
	}
	
	public boolean isReady() {
		if(isReady) {
			return true;
		}
		if(bs.quantities.get(name).size()>0) {
			for(int i=0; i<bs.quantities.get(name).size(); i++) {
					if(bs.bs.get(name).get(i)==this) {
						isReady = true;
						return true;
					}
			}
		}
		return false;
	}
	
	public Product getProduct() {
		if(!isReady()) {
			throw new IllegalArgumentException();
		}
		if(gotProduct) {
			return produkt;
		}
		gotProduct = true;
		bs.bs.get(name).remove(0);
		produkt.borrowed = true;
		Set<Produkt>x = bs.quantities.get(name);
		for(Produkt p: x) {
			produkt = p;
			x.remove(p);
			break;
		}
		return this.produkt;
	}
}

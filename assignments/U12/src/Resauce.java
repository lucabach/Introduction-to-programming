
public class Resauce implements Resource {
	
	public int type;
	int counter;
	
	public Resauce (int type, int counter) {
		this.type = type;
		this.counter = counter;
	}
	
	public int type() {
		return this.type;
	}
	
}

package ethz.ch.pp.assignment3.counters;

//TODO: implement
public class SequentialCounter implements Counter {
	private int value;
	
	
   public SequentialCounter() {
		this.value = 0;
	}
   
	@Override
	public void increment() {
		//TODO: implement	
		this.value += 1;
	}

	@Override
	public int value() {
		//TODO: implement
		return this.value;		
	}
}
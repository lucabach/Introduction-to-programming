package Locks;

//TODO: implement
public class MyCounter  {
	
	private int value;
	Thread before = null;
	
	
	public MyCounter() {
		this.value = 0;
	}
	
	
	public void increment() {
		//TODO: implement
		Thread current = Thread.currentThread();
		if (current != before) {
		this.value += 1;
		System.out.println(current.getId());
		}
		before = current;
	}

	
	public int value() {
		//TODO: implement
		return this.value;		
	}

}

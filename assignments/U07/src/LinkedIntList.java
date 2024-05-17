
public class LinkedIntList {
	
	IntNode first;
	IntNode last;
	int size;
	
	public void addLast(int value) {
		IntNode node = new IntNode(value);
		if(isEmpty()) {
			first = node;
		}
		else {
		last.next = node;
		}
		last = node;
		size +=1;
	}
	
	public void addFirst(int value) {
		IntNode node = new IntNode(value);
		IntNode second = first;
		first = node;
		first.next = second;
		if(last == null) {
			last = node;
		}
		size +=1;
	}
	
	public int removeFirst() {
		if(isEmpty()) {
			Errors.error("List is empty");
		}
		int value = first.value;
		first = first.next;
		size -=1;
		return value;
	}
	
	public int removeLast() {
		if(isEmpty()) {
			Errors.error("List is empty");
		}
		int value = last.value;
		IntNode current = first;
		while(current.next!=last) {
			current = current.next;
		}
		last = current;
		size -= 1;
		return value;
	}
	
	public void clear() {
		while(!isEmpty()) {
			int current = removeFirst();
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int get(int index) {
		if(index>=size) {
			Errors.error("index out of bounds");
		}
		IntNode current = first;
		for(int i=0; i<index; i++) {
			current = current.next;
		}
		return current.value;
	}
	
	public void set(int index, int value) {
		if(index>=size) {
			Errors.error("index out of bounds");
		}
		IntNode current = first;
		for(int i=0; i<index; i++) {
			current = current.next;
		}
		current.value = value;
	}

}

import java.util.NoSuchElementException;

public class CircularLinkedIntList implements IntList {

	IntNode last;
	int size;
	
	// TODO: Implementieren Sie die Methoden für das IntList Interface
	
    public int get(int index) {
        return getNode(index).value;
    }
    
    
    public void set(int index, int value) {
        getNode(index).value = value;
    }
    
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean contains(int value) {
    	for(IntNode n = last.next; n != last; n = n.next) {
    		if (n.value == value) {
    			return true;
    		}
    	}
    	if (last.value == value) {
    		return true;
    	}
    	return false;
    }
    
    
    public void addFirst(int value) {
        IntNode newNode = new IntNode(value);
        if(isEmpty()) {
        	last = newNode;
        	last.next = newNode;
        }
        else {
        newNode.next = last.next;
        last.next = newNode; 
        }
        size++;
    }
    
    
    public void addLast(int value) {
        IntNode newNode = new IntNode(value);
        if(isEmpty()) {
        	last = newNode;
        	last.next = newNode;
        	size++;
        } 
        else {
        	IntNode first = last.next;
        	last.next = newNode;
        	last = newNode;
        	last.next = first;
        	size++;
        }
    }
    
    public int removeFirst() {
        if(isEmpty()) {
        	throw new IllegalArgumentException("removeFirst() on empty list!");
        }
        
        int value = last.next.value;
        if(this.getSize() == 1) {
            // List has only one element, so just clear it
            clear();
        } else {
            last.next = last.next.next;
            size--;
        }
        
        return value;
    }
    
    
    public int removeLast() {
        if(isEmpty()) {
        	throw new IllegalArgumentException("removeLast() on empty list!");
        }
        
        int value = last.value;
        if(this.getSize() == 1) {
            // List has only one element, so just clear it
        	
            clear();
        }
        else {
            // List has more than one element
            IntNode currentNode = last.next;
            while(currentNode.next != last) {
            	currentNode = currentNode.next;
            }
            
            currentNode.next = last.next;
            last = currentNode;
            size--;
        }
        return value;
    }
    
    
    public void clear() {
        last = null;
        size = 0;
    }
    
    
    public int[] toArray() {
    	if(isEmpty()) {
    		return new int[0];
    	}
        int[] array = new int[size];
        int i = 0;
        if(this.getSize() == 1) {
        	array[0]=last.value;
        	return array;
        }
        else {
        for(IntNode n = last.next; n != last; n = n.next, i++) {
        	array[i] = n.value;
        }
        array[i]=last.value;  
        return array;
        }
    }
    
    
    IntNode getNode(int index) {
        if(index < 0 || index >= size) {
        	throw new IllegalArgumentException("getNode() with invalid index: " + index);
        }
        
        IntNode current = last.next;
        for(int i = 0; i < index; i++) {
        	current = current.next;
        }
            
        return current;
    }
    
    public int getSize() {
    	return this.size;
    }
}

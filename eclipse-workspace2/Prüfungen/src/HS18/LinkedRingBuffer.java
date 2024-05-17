package HS18;

public class LinkedRingBuffer {

    Node first;
    Node last;


    public LinkedRingBuffer(int size) {
    	if (size<1) {
    		throw new IllegalArgumentException();
    	}
    	first = new Node();
    	last = null;
    	Node current = first;
    	
    	for (int i = 1; i<size; i++) {
    		current.next = new Node();
    		current = current.next;
    	}
    	current.next=first;
     }

     public int capacity() {
       int capacity = 1;
       Node current = first;
       while (current.next != first) {
    	   current = current.next;
    	   capacity++;
       }
       return capacity;
     }

    public int length() {
    	if (last == null) {
    		return 0;
    	}
    	else if (first == last) {
    		return 1;
    	}
    	else {
    		int length = 1;
    		Node current = first;
    		while (current != last) {
    			current = current.next;
    			length++;
    		}
    	return length;
    	}
    }

    public void enqueue(int value) {
    	if (this.capacity() == this.length()) {
    		throw new IllegalStateException();
    	}
    	if (last == null) {
    		first.value = value;
    		last = first;
    	}
    	else {
    		last = last.next;
    		last.value = value;
    	}
    }

    public int dequeue() {
    	if (this.length() == 0) {
    		throw new IllegalStateException();
    	}
    	if (this.length() == 1) {
    		int value = first.value;
    		last = null;
    		return value;
    	}
    	else {
    	int value = first.value;
    	first = first.next;
    	return value;
    	}
    }
}
  

class Node {
    Node next;
    int value;
}

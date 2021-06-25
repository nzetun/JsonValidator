package unl.cse;

import java.util.LinkedList;

public class Queue<T> {

	private final LinkedList<T> list = new LinkedList<T>();
	private int maxSize;
	
	public T dequeue() {
		if(this.list.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return this.list.remove(0);
	}
	
	public void enqueue(T item) {
		if(this.maxSize > 0 && this.list.size() == maxSize) {
			throw new RuntimeException("Queue is full");
		}
		this.list.add(this.list.size(), item);
	}

	public int size() {
		return this.list.size();
	}
	
	public boolean isEmpty() {
		return (this.list.size() == 0);
	}
	
}

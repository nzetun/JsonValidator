package unl.cse;

import java.util.LinkedList;

public class Stack<T> {

	private final LinkedList<T> list = new LinkedList<T>();
	private int maxSize;
	
	public T pop() {
		if(this.list.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return this.list.remove(this.list.size()-1);
	}
	
	public void push(T item) {
		if(this.maxSize > 0 && this.list.size() == maxSize) {
			throw new RuntimeException("Stack is full");
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

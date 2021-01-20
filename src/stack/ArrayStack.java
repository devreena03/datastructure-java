package stack;

import java.lang.reflect.Array;

public class ArrayStack<T> implements BoundedStackInterface<T> {
	
	private T[] stack;
	private int capacity = 10;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		this.stack = (T[])new Object[this.capacity];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		this.stack = (T[])new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(Class<T> clazz, int capacity) {
		this.stack = (T[]) Array.newInstance(clazz, capacity);
	}

	@Override
	public T pop() throws StackUnderFlowException {
		if(this.isEmpty()) {
			throw new StackUnderFlowException("Pop attempted on empty stack");
		}
		T value = this.stack[this.size-1];
		this.stack[this.size-1] = null;
		this.size --;
		return value;
		
	}

	@Override
	public T top() throws StackUnderFlowException {
		if(this.isEmpty()) {
			throw new StackUnderFlowException("top attempted on empty stack");
		}
		return this.stack[this.size-1];
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void push(T o) throws StackOverFlowException {
		if(this.isFull()) {
			throw new StackOverFlowException("Push attempted on full stack");
		}
		this.stack[this.size] = o;
		this.size++;
	}

	@Override
	public boolean isFull() {
		return this.size == this.capacity;
	}
	
	@Override
	public String toString() {
		
		if(isEmpty()) {
			return "[]";
		}
		
		String values = "[";
		for(int i=this.size-1; i >= 0;i--) {
			values += this.stack[i]+ ", ";
		}
		return values.substring(0, values.length()-2) + "]";
		
	}

}

package queue;

import core.Node;

public class LinkedListQueue<T> implements UnboundedQueueInterface<T> {
	
	private int size=0;
	private Node<T> front;
	private Node<T> rear;
	
	@Override //Push
	public void enqueue(T e) {
		Node<T> node = new Node<T>(e);
		if(isEmpty()) {
			front = node;
		} else {
			rear.setNext(node);		
		}
		rear = node;
		this.size++;
		
	}
	
	@Override //Pop
	public T dequeue() throws QueueUnderflowException {
		
		if(this.size==0) 
			throw new QueueUnderflowException("dequeue attempted on empty queue");
		
		T val = this.front.getValue();
		this.front = this.front.getNext();
		this.size--;
		return val;
	}

	@Override
	public T top() throws QueueUnderflowException {
		
		if(this.size==0) 
			throw new QueueUnderflowException("Top attempted on empty queue");
		
		return this.front.getValue();
	}

	@Override
	public boolean isEmpty() {
		return this.size==0;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {	
		if(isEmpty()) {
			return "[]";
		}
		
		String values = "[";
		Node<T> itr = this.front;
		while(itr!=null) {
			values += itr.getValue()+ ", ";
			itr = itr.getNext();
		}
		return values.substring(0, values.length()-2) + "]";
	}

}

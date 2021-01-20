package stack;

import core.Node;

public class LinkedListStack<T> implements UnboundedStackInterface<T> {
	
	private Node<T> currentNode;
	private int size=0;
	
	@Override
	public void push(T o) {
		Node<T> node = new Node<T>(o);
		node.setNext(currentNode);
		this.currentNode = node;
		this.size++;
		
	}
	
	@Override
	public T pop() throws StackUnderFlowException {
		if(this.isEmpty()) {
			throw new StackUnderFlowException("Pop attempted on empty stack");
		}
		T value  = this.currentNode.getValue();
		this.currentNode = this.currentNode.getNext();
		this.size--;
		return value;
	}

	@Override
	public T top() throws StackUnderFlowException {
		if(this.isEmpty()) {
			throw new StackUnderFlowException("Top attempted on empty stack");
		}
		return this.currentNode.getValue();
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
	public boolean isFull() {
		return false;
	}
	
	@Override
	public String toString() {
		
		if(isEmpty()) {
			return "[]";
		}
		
		Node<T> itr = this.currentNode;
		String values = "[";
		while(itr!=null) {
			values += itr.getValue()+ ", ";
			itr = itr.getNext();
		}
		return values.substring(0, values.length()-2) + "]";
	}

}

package core;

public class Node<T> {
	private Node<T> next;
	private T value;
	
	public Node(T name){
		this.value = name;
		this.next = null;		
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public void setValue(Node<T> node) {
		this.next = node;
	}
	
	public T getValue() {
		return this.value;
	}
}

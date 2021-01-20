package core;

public class StringNode {
	
	private StringNode next;
	private String name;
	
	public StringNode(String name){
		this.name = name;
		this.next = null;		
	}
	
	public StringNode getNext() {
		return this.next;
	}
	
	public void setNext(StringNode node) {
		this.next = node;
	}
	
	public String getName() {
		return this.name;
	}

}

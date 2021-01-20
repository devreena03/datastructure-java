package stringLog;

import core.StringNode;

public class LinkedListStringLog implements StringLogInterface {
	
	private String name;
	private int maxSize = 20;
	private int size = 0;
	private StringNode log;
	private StringNode curPosition;
	
	public LinkedListStringLog(String name) {
		this.name = name;
	}
	
	public LinkedListStringLog(String name, int size) {
		this.name = name;
		this.maxSize = size;
	}

	@Override
	public void insert(String element) {	
		StringNode newNode = new StringNode(element);
		if(log==null) { //first element
		  this.log = newNode;
		} else {
			this.curPosition.setNext(newNode);
		}
		this.curPosition = newNode;
		this.size++; 
	}

	@Override
	public void clear() {
		this.log = null;
		this.size = 0;
	}

	@Override
	public boolean isFull() {
		return this.size==this.maxSize;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(String element) {
		StringNode itr = log;
		while(itr!=null) {
			if(itr.getName().equals(element)) {
				return true;
			}
			itr = itr.getNext();
		}		
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		String logString = "Log: "+this.name +"\n\n";
		StringNode itr = log;
		while(itr!=null) {
			System.out.println(itr.getName());
			itr = itr.getNext();
		}
		return logString;
				
	}

}

package gfg.doublylinkedlist;

import gfg.circularlinkedlist.ListOverFlowException;

public class DoublyLinkedList {
	
	private DoublyListNode head;
	private DoublyListNode last;
	private int size=0;
	
	public DoublyListNode add(int val) {
		DoublyListNode node = new DoublyListNode(val);
		if(size==0) {
			head=node;
		} else {
			last.next = node;
			node.prev = last;
		}
		this.size++;
		last = node;
		return head;
	}
	
	public boolean remove() {
		return removeLast();
	}
	
	public boolean removeByIndex(int i) {
		if(i>=size) throw new ListOverFlowException( i +" is out of bound for length "+size);
		
		if(i==0) return removeFirst();
		
		if(i==size-1) return removeLast();
		
		DoublyListNode cur = getNode(i);
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		
		size--;
		return true;
	}
	
	public boolean removeFirst() {
		 if(removeForOneElement()) {
			 return true;
		 }
		
		head = head.next;
		head.prev = null;
		size--;
		
		return true;
	}

	public boolean removeLast() {
		 if(removeForOneElement()) {
			 return true;
		 }
		
		last = last.prev;
		last.next = null;
		size--;
		
		return true;
	}

	private boolean removeForOneElement() {
		if(size==0) throw new ListOverFlowException(" delete 0 index for size "+size);
		
		if(size==1) {
			head =null;
			last = null;
			size =0;
			return true;
		}
		
		return false;
	}

	public DoublyListNode add(int i, int val) {
		if(i>size) throw new ListOverFlowException( i +" is out of bound for length "+size);
		
		if(i==0) return addFirst(val);
		
		if(i==size) return add(val);
		
		DoublyListNode node = new DoublyListNode(val);
		DoublyListNode currNode = getNode(i);
		node.prev = currNode.prev;
		currNode.prev.next = node;
		currNode.prev = node;
		node.next = currNode;
		
		this.size++;
		return head;
	}

	private DoublyListNode getNode(int index) {
		int count=0;
		DoublyListNode itr = head;
		
		while(itr!=null) {
			if(index==count) break;
			count++;
			itr = itr.next; 
		}
		return itr;
	}

	public DoublyListNode addFirst(int val) {
		DoublyListNode node = new DoublyListNode(val);
		if(size==0) {
			last = node;
		} else {
			head.prev = node;
		}
		node.next =head;
		head = node;
		this.size++;
		return head;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DoublyListNode itr = head;
		
		while(itr!=null) {
			sb.append(itr.val);
			sb.append(", ");
			itr = itr.next; 
		}
		return "DoublyLinkedList [size=" + size + " and value = {" + sb.toString()+"}]";
	}

	public String reverse() {
		StringBuilder sb = new StringBuilder();
		DoublyListNode itr = last;
		
		while(itr!=null) {
			sb.append(itr.val);
			sb.append(", ");
			itr = itr.prev; 
		}
		return "DoublyLinkedList [size=" + size + " and reversed value = {" + sb.toString()+"}]";
	}
	
	
}

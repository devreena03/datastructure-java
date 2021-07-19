package gfg.circularlinkedlist;

import application.ListNode;

public class CircularLinkedList {
	
	private ListNode last;
	private int size=0;
	
	//Add given node at end of list and return head of list;
	public ListNode add(int val) {
		ListNode node = new ListNode(val);
		if(last==null) {
			last = node;
			last.next = last;
		} else {
			ListNode head = last.next;
			last.next = node;
			last = node;
			node.next = head;
		}
		size++;
		return this.last.next;
		
	}
	
	//add at given index
	public ListNode add(int i, int val) {
		if(i>size) throw new ListOverFlowException( i +" is out of bound for length "+size);
		
		if(i==0) return addFirst(val);
		
		if(i==size) return add(val);
		
		ListNode prev = nodeAtIndex(i-1);
		
		ListNode node = new ListNode(val);
		node.next = prev.next;
		prev.next = node;
		size++;
		
		return last.next;
	}
	
	private ListNode nodeAtIndex(int i) {
		int count=0;
		ListNode itr = last.next;
		do{
		   if(i==count) return itr;
		   count++;
		   itr = itr.next;
		}while(itr!=last.next);
		
		return null;
	}

	public ListNode addFirst(int val) {
		ListNode node = new ListNode(val);
		node.next = last.next;
		last.next = node;
		size++;
		return node;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(last==null) return "CircularLinkedList [ ]";
		
		ListNode itr = last.next;
		do{
		   sb.append(itr.val+", ");
		   itr = itr.next;
		}while(itr!=last.next);
		
		return "CircularLinkedList [" + sb.toString() + "]";
	}

	public boolean remove(int val) {
		if(this.size==1) {
			if(last.val == val) {
				clear();
				return true;
			}
			return false;
		}
		
		ListNode prev = last;
		ListNode itr = last.next;
		boolean found = false;
		do{
		   if(itr.val == val) {
			   found = true; 
			   break;
		   }		   
		   prev = itr;
		   itr = itr.next;
		}while(itr!=last.next);
		
		if(!found) return false;
		
		this.size--;
		resetElement(prev);
		return true;
		
	}
	
	public boolean removeLast() {
		if(this.size==1) {
			clear();
			return true;
		}
		
		return removeAtIndex(this.size-1);
	}
	
	public boolean removeFirst() {
		if(this.size==1) {
			clear();
			return true;
		} 
			
		this.size--;
		resetElement(last);
		return true;
	}

	private void resetElement(ListNode node) {
		if(this.size==1) {
			this.last.next = this.last;
		} else {
			node.next = node.next.next;
		}
		
	}

	public boolean removeAtIndex(int index) {
		
		if(index>size-1) throw new ListOverFlowException( index +" is out of bound for length "+size);
		
		if(index==0) return removeFirst();
		
		ListNode prev = nodeAtIndex(index-1);
		if(index==size-1) {
			last = prev;
		}
		this.size--;
		resetElement(prev);
		return true;
	}

	public boolean contains(int val) {
		return getIndex(val)!=-1;
	}

	private int getIndex(int val) {
		int count=0;
		ListNode itr = last.next;
		do{
		   if(itr.val == val) return count;
		   count++;
		   itr = itr.next;
		}while(itr!=last.next);
		
		return -1;
	}

	public int size() {
		return this.size;
	}

	public void clear() {
		this.last = null;
		this.size = 0;
		
	}

}

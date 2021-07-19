package gfg.linkedlist;

import application.ListNode;

public class LinkedListOperations {

	// https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
	public int findMiddle(ListNode node) {
		ListNode itr = node;
		ListNode back = node;
		while (itr != null && itr.next != null) {
			back = back.next;
			itr = itr.next.next;
		}
		return back.val;
	}

	// https://practice.geeksforgeeks.org/problems/delete-middle-of-linked-list/1
	public ListNode deleteMiddle(ListNode node) {
		ListNode fast = node;
		ListNode slow = null;

		// handle 0-1 element
		if (node == null || node.next == null)
			return null;

		while (fast != null && fast.next != null) {
			if (slow == null) {
				slow = node;
			} else {
				slow = slow.next;
			}
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
		return node;
	}

	// https://leetcode.com/problems/reverse-linked-list/
	public ListNode reverse(ListNode head) {

		ListNode prev = null;

		while (head != null) {
			ListNode curr = new ListNode(head.val, prev);
			prev = curr;
			head = head.next;
		}

		return prev;
	}

	public boolean isPalindrom(ListNode head) {
		
		ListNode fast = head;
		ListNode slow = head; //itr till mid
		ListNode prev = null; //rev till mid
		
		while (fast != null && fast.next != null) {
			ListNode curr = new ListNode(slow.val, prev);
			prev = curr;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast!=null) { //odd element
			slow = slow.next;
		}
		
		while(slow!=null) {
			if(slow.val!=prev.val) return false;
			slow = slow.next;
			prev = prev.next;
		}

		return true;
	}
	
	 public ListNode swapPairs(ListNode head) {
	        
	        if(head==null || head.next==null) return head;
	        
	        ListNode prev = head;
	        ListNode curr = head.next;
	        ListNode itr = null;
	        boolean first = true;
	        
	        while(curr!=null && prev!=null){
	            
	            prev.next = curr.next;
	            curr.next = prev;
	            
	            if(first){
	              head=curr;
	              first = false;
	            }else {
	            	itr.next = curr;
	            }
	            
	            itr=prev;
	            prev = prev.next;
	            if(prev!=null) {
	                curr = prev.next;
	            }
	        }
	        
	        return head;
	    }

}

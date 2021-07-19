package gfg.linkedlist;
import application.ListNode;
public class AddLinkedList {
	
	//https://leetcode.com/problems/add-two-numbers/
	public ListNode indexWiseAddition(ListNode l1, ListNode l2) {
		
		 ListNode curPoition = null;
		 ListNode sumNode = null;
		 int sum = 0;
		
		while(l1!=null || l2!=null) {
			
			if(l1!=null) {
				sum = sum + l1.getVal();
				l1 = l1.getNext();
			}
			if(l2!=null) {
				sum = sum + l2.getVal();
				l2 = l2.getNext();
			}
			
			ListNode n = new ListNode(sum%10);
			 if(sumNode==null){
	              sumNode = n;
	         } else {
	             curPoition.next = n;
	         }
			curPoition = n;
			sum = sum/10;	
			
		}
		if(sum != 0) {
			ListNode n = new ListNode(sum); //last carryforward if any
			curPoition.next = n;
		}
		return sumNode;
        
    }

	public ListNode naturalOrderAddition(ListNode list1, ListNode list2) {
		if(list1==null) return list2;
		if(list2==null) return list1;
		
		LinkedListOperations operation = new LinkedListOperations();
		list1 = operation.reverse(list1);
		list2 = operation.reverse(list2);
		 
		ListNode sum = indexWiseAddition(list1, list2);
		
		return operation.reverse(sum);
	}

}

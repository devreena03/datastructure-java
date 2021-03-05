package application;

public class MergedNSortedList {
	
	public static void main(String[] args) {
		MergedNSortedList obj = new MergedNSortedList();
		ListNode l1 = LinkedListUtil.getLinkedList();
		LinkedListUtil.printListNodes(l1);
		
		ListNode l2 = LinkedListUtil.getLinkedList(1);
		LinkedListUtil.printListNodes(l2);
		
		ListNode l3 = LinkedListUtil.getLinkedList(1,2);
		LinkedListUtil.printListNodes(l3);
		
		//LinkedListUtil.printListNodes(obj.merged(l1,l2));
			
		ListNode[] lists = {l1,l2};
		LinkedListUtil.printListNodes(obj.solve(lists));
		
	}
	
	public ListNode solve(ListNode[] lists) {
		if(lists.length==0)
			return null;
		return fold(lists, lists.length);
	}

	private ListNode fold(ListNode[] lists, int length) {
		
		if(length==1)
			return lists[0];
		
		int mid = length/2;
		for(int i=0; i<mid; i++) {
			lists[i] = merged(lists[i], lists[length-i-1]);
		}
		
		length = isOdd(length) ? mid+1: mid;
			
		return fold(lists, length);
	}

	private boolean isOdd(int length) {
		return length%2!=0;
	}

	private ListNode merged(ListNode node1, ListNode node2) {
		
		ListNode ref = null;
		ListNode result = node1;
		while (node1 != null && node2 != null) {
			if (node1.getVal() <= node2.getVal()) {
				ref = node1;
				node1 = node1.getNext();
			} else {// insert node2 in node 1			
				if (ref == null) { // insert node2 at 0 position
					result = node2;		
				} else {
					ref.setNext(node2);				
				}
				ref = node2;
				node2 = node2.getNext();
				ref.setNext(node1);
				
			}
		} if(node2!=null) {
			if (ref == null) { // insert node2 at 0 position
				result = node2;		
			} else {
				ref.setNext(node2);				
			}
		} //no action for node2 null, values are merged in node1
		return result;
	}

}

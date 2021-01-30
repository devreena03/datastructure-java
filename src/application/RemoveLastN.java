package application;

public class RemoveLastN {
	
public static void main(String[] args) {
		RemoveLastN obj = new RemoveLastN();
		
//		ListNode l1 = getLinkedList(1,2,3,4,5);
//		printListNodes(l1);		
//		printListNodes(obj.removeNthFromEnd(l1, 2)); //1,2,3,5
//		
//		ListNode l2 = getLinkedList(1);
//		printListNodes(l2);		
//		printListNodes(obj.removeNthFromEnd(l2, 1)); //[]
//		
		ListNode l3 = getLinkedList(1,2);
		printListNodes(l3);		
		printListNodes(obj.removeNthFromEnd(l3, 2)); //[1]
		
	}

	public  ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.getNext()==null) return null;
	    int length = removeLast(head, n);
	    if(length == n) {
	    	head = head.getNext();
	    }
		return head;
	}
	
	private int removeLast(ListNode itr, int n) {
		 if(itr.getNext()==null) {
			 return 1;
		 }
		 
		 int val = removeLast(itr.getNext(), n);
		 if(val==n) {
			itr.setNext(itr.getNext().getNext()); 
		 }
		return val+1;
	}

	private static void printListNodes(ListNode sum) {
		System.out.print("[");
		while(sum!=null) {
			System.out.print(sum.getVal());
			if(sum.getNext()!=null) {
				System.out.print(",");
			}
			sum = sum.getNext();
		}
		System.out.println("]");
	}

	private static ListNode getLinkedList(int ...arr) {
		ListNode node=null;
		ListNode curPoition = null;
		for (int j=0;j<arr.length;j++) {
			ListNode n = new ListNode(arr[j]);
			if(node==null) {
				node = n;
			} else {
				curPoition.setNext(n);
			}
			curPoition = n;
		}
		return node;
	}
}

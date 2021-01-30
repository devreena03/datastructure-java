package application;


public class AddLinkedList {
	
	public static void main(String[] args) {
		
		ListNode l1 = getLinkedList(1,8,5);
		printListNodes(l1);
		
		ListNode l2 = getLinkedList(3,4,8,2);
		printListNodes(l2);
		
		ListNode sum = addTwoNumbers(l1, l2);
		
		printListNodes(sum);
		
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

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode curPoition = null;
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
			n.setNext(curPoition);
			curPoition = n;
			sum = sum/10;	
			
		}
		if(sum != 0) {
			ListNode n = new ListNode(sum); //last carryforward if any
			n.setNext(curPoition);
			curPoition = n;
		}
		return curPoition;
        
    }

}

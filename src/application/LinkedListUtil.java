package application;

public class LinkedListUtil {
	
	public static void printListNodes(ListNode ref) {
		ListNode node = ref;
		System.out.print("[");
		while(node!=null) {
			System.out.print(node.getVal());
			if(node.getNext()!=null) {
				System.out.print(",");
			}
			node = node.getNext();
		}
		System.out.println("]");
	}

	public static ListNode getLinkedList(int ...arr) {
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

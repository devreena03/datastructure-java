package gfg.circularlinkedlist;

import java.util.Arrays;

import application.ListNode;

public class CLLTest {
	
	public static void main(String[] args) {
		CircularLinkedList ccl = new CircularLinkedList();
		ccl.add(2);
		ccl.add(3);
		ccl.add(0, 5);
		ccl.add(2, 5);
		ccl.add(9);
		System.out.println("1.-----------"+ccl.size());
		System.out.println(ccl);
		
		System.out.println(ccl.contains(3));
		System.out.println(ccl.remove(3));
		System.out.println("2.-----------"+ccl.size());
		System.out.println(ccl);
		
		ccl.add(1);
		System.out.println(ccl.removeFirst());
		System.out.println("3.-----------"+ccl.size());
		System.out.println(ccl);
		
		System.out.println(ccl.removeLast());
		ccl.add(10);
		System.out.println("4.-----------"+ccl.size());
		System.out.println(ccl);
		
		ccl.removeAtIndex(1);
		System.out.println(ccl.remove(3));
		ccl.add(9);
		System.out.println("5.-----------"+ccl.size());
		System.out.println(ccl);
		
		System.out.println(ccl.remove(3));
		ccl.add(4);
		System.out.println(ccl.removeFirst());
		System.out.println("6.-----------"+ccl.size());
		System.out.println(ccl);
		
		System.out.println("-------------Util-----------");
		utilTest();
		
	}

	private static void utilTest() {
		ListNode head = CircularLinkedListUtil.arrayToCll(1,2,4,5,6);
		System.out.println(CircularLinkedListUtil.cllToString(head));
		
		ListNode head1 = CircularLinkedListUtil.arrayToCll(4,5,6);
		int[] arr = CircularLinkedListUtil.cllToArray(head1);
		
		Arrays.stream(arr).forEach(System.out::print);
		
	}

}

package gfg.circularlinkedlist;

import java.util.ArrayList;
import java.util.List;

import application.ListNode;

public class CircularLinkedListUtil {
	
	private static CircularLinkedList cll = new CircularLinkedList();
	
	public static ListNode arrayToCll(int... arr) {
		cll.clear();
		ListNode head = null;
		for(int val: arr) {
			head = cll.add(val);
		}
		return head;
		
	}
	
	public static List<Integer> cllToList(ListNode head) {
		
		List<Integer> list = new ArrayList<>();
		if(head==null) return list;
		
		ListNode itr = head;
		do{
			list.add(itr.val);
			itr = itr.next;
		}while(itr!=head);
		
		return list;	
	}
	
	public static int[] cllToArray(ListNode head) {
		List<Integer> list = cllToList(head);
		return list.stream().mapToInt(Integer::intValue).toArray();	
	}
	
	public static String cllToString(ListNode head) {
		StringBuilder sb = new StringBuilder();
		if(head==null) return "CircularLinkedList [ ]";
		
		ListNode itr = head;
		do{
		   sb.append(itr.val+", ");
		   itr = itr.next;
		}while(itr!=head);
		
		return "CircularLinkedList [" + sb.toString() + "]";
	}

}

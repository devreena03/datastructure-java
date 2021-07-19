package gfg.linkedlist;

import static application.LinkedListUtil.flatten;
import static application.LinkedListUtil.getLinkedList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import application.ListNode;

public class RevereseNodeTest {
	
	LinkedListOperations operation = new LinkedListOperations();
	
	@Test
	public void reverseList() throws Exception {
		ListNode node = getLinkedList(1,2,3);
		ListNode result = getLinkedList(3,2,1);
		assertArrayEquals(flatten(result), flatten(operation.reverse(node)));
	}
	
	@Test
	public void reverseOneElementList() throws Exception {
		ListNode node = getLinkedList(1);
		ListNode result = getLinkedList(1);
		assertArrayEquals(flatten(result), flatten(operation.reverse(node)));
	}
	
	@Test
	public void reverse2Element() throws Exception {
		ListNode node = getLinkedList(1,2);
		ListNode result = getLinkedList(2,1);
		assertArrayEquals(flatten(result), flatten(operation.reverse(node)));
	}
	
	@Test
	public void reverseEmpty() throws Exception {
		assertNull(operation.reverse(null));
	}

	@Test
	public void reverseLongList() throws Exception {
		ListNode node = getLinkedList(1,2,3,6,9,4,5);
		ListNode result = getLinkedList(5,4,9,6,3,2,1);
		assertArrayEquals(flatten(result), flatten(operation.reverse(node)));
	}
}

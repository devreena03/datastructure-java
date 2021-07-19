package gfg.linkedlist;

import static org.junit.Assert.*;
import static application.LinkedListUtil.*;
import application.ListNode;

import org.junit.Test;

public class FindMiddleElelementTest {
	
	LinkedListOperations operation = new LinkedListOperations();
	
	@Test
	public void findMiddleWhenOddElement() throws Exception {
		ListNode node = getLinkedList(1,2,3,4,5);
		assertEquals(3, operation.findMiddle(node));
	}
	
	@Test
	public void findMiddleWhenEvenElement() throws Exception {
		ListNode node = getLinkedList(1,2,3,4,5,6);
		assertEquals(4, operation.findMiddle(node));
	}
	
	@Test
	public void findMiddleWhenOneElement() throws Exception {
		ListNode node = getLinkedList(1);
		assertEquals(1, operation.findMiddle(node));
	}
	
	@Test
	public void findMiddleWhenTwoElement() throws Exception {
		ListNode node = getLinkedList(1,2);
		assertEquals(2, operation.findMiddle(node));
	}

	@Test
	public void deleteMiddleWhenOddElement() throws Exception {
		ListNode node = getLinkedList(1,2,3,4,5);
		ListNode result = getLinkedList(1,2,4,5);
		assertArrayEquals(flatten(result), flatten(operation.deleteMiddle(node)));
	}
	
	@Test
	public void deleteMiddleWhenEvenElement() throws Exception {
		ListNode node = getLinkedList(1,2,3,4,5,6);
		ListNode result = getLinkedList(1,2,3,5,6);
		assertArrayEquals(flatten(result), flatten(operation.deleteMiddle(node)));
	}
	
	@Test
	public void deleteMiddleWhenOneElement() throws Exception {
		ListNode node = getLinkedList(1);
		assertNull(operation.deleteMiddle(node));
	}
	
	@Test
	public void deleteMiddleWhenTwoElement() throws Exception {
		ListNode node = getLinkedList(1,2);
		ListNode result = getLinkedList(1);
		assertArrayEquals(flatten(result), flatten(operation.deleteMiddle(node)));
	}
}

package gfg.linkedlist;

import static application.LinkedListUtil.getLinkedList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.ListNode;

public class LinkedListOperationTest {

LinkedListOperations operation = new LinkedListOperations();
	
	@Test
	public void isPalindromEvenElement() throws Exception {
		ListNode node = getLinkedList(1,2,2,1);
		assertTrue(operation.isPalindrom(node));
	}
	
	@Test
	public void isNotPalindromEvenElement() throws Exception {
		ListNode node = getLinkedList(1,2,3,1);
		assertFalse(operation.isPalindrom(node));
	}
	
	@Test
	public void isPalindromOddElement() throws Exception {
		ListNode node = getLinkedList(1,2,1);
		assertTrue(operation.isPalindrom(node));
	}
	
	@Test
	public void isNotPalindromOddElement() throws Exception {
		ListNode node = getLinkedList(1,2,3);
		assertFalse(operation.isPalindrom(node));
	}
	
	@Test
	public void isPalindromOneElement() throws Exception {
		ListNode node = getLinkedList(1);
		assertTrue(operation.isPalindrom(node));
	}
	
	@Test
	public void isPalindromEmptyElement() throws Exception {
		assertTrue(operation.isPalindrom(null));
	}
}

package gfg.linkedlist;

import static application.LinkedListUtil.flatten;
import static application.LinkedListUtil.getLinkedList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import application.ListNode;

public class SwapNodesTest {
	
	LinkedListOperations operation = new LinkedListOperations();
	
	@Test
	public void swapInPair() throws Exception {
		ListNode node = getLinkedList(1,2);
		ListNode result = getLinkedList(2,1);
		assertArrayEquals(flatten(result), flatten(operation.swapPairs(node)));
	}
	
	@Test
	public void swapElementList() throws Exception {
		ListNode node = getLinkedList(1,2,3,4);
		ListNode result = getLinkedList(2,1,4,3);
		assertArrayEquals(flatten(result), flatten(operation.swapPairs(node)));
	}
	
	@Test
	public void swapOddList() throws Exception {
		ListNode node = getLinkedList(1,2,3);
		ListNode result = getLinkedList(2,1,3);
		assertArrayEquals(flatten(result), flatten(operation.swapPairs(node)));
	}
	
	@Test
	public void swapEmpty() throws Exception {
		assertNull(operation.swapPairs(null));
	}

	@Test
	public void swapOneList() throws Exception {
		ListNode node = getLinkedList(1);
		ListNode result = getLinkedList(1);
		assertArrayEquals(flatten(result), flatten(operation.swapPairs(node)));
	}
}

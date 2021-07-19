package gfg.linkedlist;

import static application.LinkedListUtil.flatten;
import static application.LinkedListUtil.getLinkedList;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import application.ListNode;

public class AddLinkedListTest {
	
	AddLinkedList operation = new AddLinkedList();
 //Test case for Indexwise addition	
	@Test
	public void add2NumberIndexWiseWhenNoCarry() throws Exception {
		ListNode list1 = getLinkedList(1,2,4);
		ListNode list2 = getLinkedList(5,6,4);
		ListNode sum = getLinkedList(6,8,8);
//		printListNodes(operation.indexWiseAddition(list1, list2));
		assertArrayEquals(flatten(sum), flatten(operation.indexWiseAddition(list1, list2)));
	}
	
	@Test
	public void add2NumberIndexWiseWhenCarry() throws Exception {
		ListNode list1 = getLinkedList(1,2,4);
		ListNode list2 = getLinkedList(5,6,8);
		ListNode sum = getLinkedList(6,8,2,1);
//		printListNodes(operation.indexWiseAddition(list1, list2));
		assertArrayEquals(flatten(sum), flatten(operation.indexWiseAddition(list1, list2)));
	}
	
	@Test
	public void add2NumberIndexWiseWhenCarry2() throws Exception {
		ListNode list1 = getLinkedList(1,6,4);
		ListNode list2 = getLinkedList(5,6,3);
		ListNode sum = getLinkedList(6,2,8);
//		printListNodes(operation.indexWiseAddition(list1, list2));
		assertArrayEquals(flatten(sum), flatten(operation.indexWiseAddition(list1, list2)));
	}
	@Test
	public void add2NumberIndexWiseWhen2ndEmpty() throws Exception {
		ListNode list1 = getLinkedList(1,2,4);
		assertArrayEquals(flatten(list1), flatten(operation.indexWiseAddition(list1, null)));
	}
	
	@Test
	public void add2NumberIndexWiseWhen1stEmpty() throws Exception {
		ListNode list1 = getLinkedList(1,2,4);
		assertArrayEquals(flatten(list1), flatten(operation.indexWiseAddition(null, list1)));
	}
	
//Testcase for natural order addition	
	
	@Test
	public void add2NumberNaturalOrderWhen2ndEmpty() throws Exception {
		ListNode list1 = getLinkedList(1,2,4);
		assertArrayEquals(flatten(list1), flatten(operation.naturalOrderAddition(list1, null)));
	}
	
	@Test
	public void add2NumberNaturalOrderWhen1stEmpty() throws Exception {
		ListNode list1 = getLinkedList(1,2,4);
		assertArrayEquals(flatten(list1), flatten(operation.naturalOrderAddition(null, list1)));
	}
	
	@Test
	public void add2NumberNaturalOrderWhenNoCarry() throws Exception {
		ListNode list1 = getLinkedList(1,2);
		ListNode list2 = getLinkedList(5,6,4);
		ListNode sum = getLinkedList(5,7,6);
//		printListNodes(operation.indexWiseAddition(list1, list2));
		assertArrayEquals(flatten(sum), flatten(operation.naturalOrderAddition(list1, list2)));
	}
	
	@Test
	public void add2NumberNaturalOrderWhenCarry() throws Exception {
		ListNode list1 = getLinkedList(6,2);
		ListNode list2 = getLinkedList(5,6,4);
		ListNode sum = getLinkedList(6,2,6);
//		printListNodes(operation.indexWiseAddition(list1, list2));
		assertArrayEquals(flatten(sum), flatten(operation.naturalOrderAddition(list1, list2)));
	}
	
	@Test
	public void add2NumberNaturalOrderWhenCarry2() throws Exception {
		ListNode list1 = getLinkedList(8,6,2);
		ListNode list2 = getLinkedList(5,6,4);
		ListNode sum = getLinkedList(1,4,2,6);
//		printListNodes(operation.indexWiseAddition(list1, list2));
		assertArrayEquals(flatten(sum), flatten(operation.naturalOrderAddition(list1, list2)));
	}
}

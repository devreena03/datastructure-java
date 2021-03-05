package application.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TreeTest {
	
	Tree tree = new Tree();

	@Test
	public void constructTree() {
		Integer[] arr = {5,4,3,null,null,6};
		TreeNode root= tree.constructTree(arr);
		System.out.println(tree.bstTraversal(root));
		assertArrayEquals(arr, tree.bstTraversal(root).toArray());
	}
	
	@Test
	public void findLevel() throws Exception {
		TreeNode root = tree.constructTree(5,4,3,2,null,null,1,6,8);
		assertEquals(2, tree.getLevel(root, 3));
		assertEquals(3, tree.getLevel(root, 1));
		assertEquals(4, tree.getLevel(root, 8));
		assertEquals(0, tree.getLevel(root, 9));
	}
	
	@Test
	public void levelWiseTravese() throws Exception {
		TreeNode root = tree.constructTree(5,4,3,2,null,null,1,6,8);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(5));
		expected.add(Arrays.asList(4,3));
		expected.add(Arrays.asList(2,1));
		expected.add(Arrays.asList(6,8));
		assertDeepArrayEquals(expected, tree.levelWiseTraversal(root));
	}
	
	@Test
	public void levelWiseTravese2() throws Exception {
		TreeNode root = tree.constructTree(5,null,3,2,null,null,1,6,8);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(5));
		expected.add(Arrays.asList(3));
		expected.add(Arrays.asList(2));
		expected.add(Arrays.asList(1));
		expected.add(Arrays.asList(6,8));
		assertDeepArrayEquals(expected, tree.levelWiseTraversal(root));
	}
	
	@Test
	public void levelWiseTravese3() throws Exception {
		TreeNode root = tree.constructTree(5);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(5));
		assertDeepArrayEquals(expected, tree.levelWiseTraversal(root));
	}
	
	@Test
	public void zigZagTraversal() throws Exception {
		TreeNode root = tree.constructTree(3,9,20,null,null,15,17,3,5,7,8,9);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(3));
		expected.add(Arrays.asList(20,9));
		expected.add(Arrays.asList(15,17));
		expected.add(Arrays.asList(8,7,5,3));
		expected.add(Arrays.asList(9));
		assertDeepArrayEquals(expected, tree.zigZagTraversal(root));
	}
	
	@Test
	public void zigZagTraversal_empty() throws Exception {
		TreeNode root = tree.constructTree(2);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(2));
		assertDeepArrayEquals(expected, tree.zigZagTraversal(root));
	}

	private void assertDeepArrayEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
		assertEquals(expected.size(), actual.size());
		for(int i=0; i<actual.size();i++) {
			assertArrayEquals(expected.get(i).toArray(), actual.get(i).toArray());
		}
		
	}

}

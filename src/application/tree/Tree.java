package application.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	public TreeNode constructTree(Integer... array) {

		Queue<TreeNode> queue = new LinkedList<>(); // BFS

		TreeNode node = new TreeNode(array[0]);
		queue.add(node);

		for (int i = 1; i < array.length; i++) {
			TreeNode n = queue.remove();
			if (array[i] != null) {
				TreeNode left = new TreeNode(array[i]);
				n.left = left;
				queue.add(left);
			}

			i++;
			if (i < array.length && array[i] != null) {
				TreeNode right = new TreeNode(array[i]);
				n.right = right;
				queue.add(right);
			}
		}
		return node;
	}

	public List<Integer> bstTraversal(TreeNode root) {
		List<Integer> values = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>(); // BFS
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode n = queue.remove();
			if (n == null) {
				values.add(null);
			} else {
				values.add(n.val);
				queue.add(n.left);
				queue.add(n.right);
			}
		}
		// removing extra null at end
		for (int i = values.size() - 1; i >= 0; i--) {
			if (values.get(i) == null) {
				values.remove(i);
			} else {
				break;
			}
		}
		return values;
	}

	public List<List<Integer>> levelWiseTraversal(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		traverse(root, list, 0);
		return list;

	}

	private void traverse(TreeNode root, List<List<Integer>> finalList, int level) {

		if (root == null)
			return;

		if (finalList.size() == level) {
			finalList.add(new ArrayList<>());
		}
		List<Integer> list = finalList.get(level);

		list.add(root.val);
		traverse(root.left, finalList, level + 1);
		traverse(root.right, finalList, level + 1);

	}

	public List<List<Integer>> zigZagTraversal(TreeNode root) {
		
		List<List<Integer>> finalList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		Stack<TreeNode> current = new Stack<>();
		Stack<TreeNode> next = new Stack<>();
		
		current.push(root);
		boolean reverse = false;

		while (!current.isEmpty()) {
			TreeNode node = current.pop();
			if(node!=null) {
				list.add(node.val);
				if(reverse) {
					next.push(node.right);
					next.push(node.left);
				} else {
					next.push(node.left);
					next.push(node.right);
				}
			}
				
				//next level
				if(current.isEmpty()) {
					
					if(!list.isEmpty())
						finalList.add(list);
					
					list = new ArrayList<>();
					
					current = next;
					next = new Stack<>();
					reverse = !reverse;
				}
			

		}
		return finalList;

	}

//			private void zigZagTraversal(TreeNode root, List<List<Integer>> finalList, int level) {
//				
//				if(root==null) return;
//				
//				if(finalList.size()==level) {
//					finalList.add(new ArrayList<>());
//				}
//				List<Integer> list = finalList.get(level);
//
//				zigZagTraversal(root.left, finalList, level+1);
//				zigZagTraversal(root.right, finalList, level+1);
//				list.add(root.val);
//							
//			}

	public int getLevel(TreeNode root, int val) {
		return getLevel(root, val, 1);
	}

	private int getLevel(TreeNode root, int val, int level) {

		if (root == null)
			return 0;

		if (val == root.val)
			return level;

		int down = getLevel(root.left, val, level + 1);

		if (down == 0) { // didn't find left side
			down = getLevel(root.right, val, level + 1);
		}
		return down;
	}

}

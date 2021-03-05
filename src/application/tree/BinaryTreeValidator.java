package application.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeValidator {

	public static void main(String[] args) {

		Tree tree = new Tree();

		Integer[] arr = { 5, 4, 7, null, null, 6, 8 };
		TreeNode root = tree.constructTree(arr);
		System.out.println(isValidBST(root));

	}

	public static boolean isValidBST(TreeNode root) {
		
		   Queue<TreeNode> queue = new LinkedList<>(); // BFS
		   Set<Integer> unique = new HashSet<>();
	       queue.add(root);
	       while(!queue.isEmpty()) {
	    	   TreeNode n = queue.remove();
	    	   
	    	   if(!unique.add(n.val))
	    		   return false;
	    	   
	    	   if(n.left!=null) {
	    		   if(isValidPosition(n.left.val, root)) {
		    		   queue.add(n.left); 
		    	   } else {
		    		   return false;
		    	   } 
	    	   }
	    	  
	    	   if(n.right!=null) {
	    		   if(isValidPosition(n.right.val, root)) {
		    		   queue.add(n.right); 
		    	   } else {
		    		   return false;
		    	   } 
	    	   }
	    	   	  
	       }
	       
		return true;
	}

	private static boolean isValidPosition(int val, TreeNode root) {
		
		if (root == null) return false;
		
		if(val==root.val) return true;
				
		if(val < root.val) {
			return isValidPosition(val, root.left);
		}
		
		return isValidPosition(val, root.right);
	}

}

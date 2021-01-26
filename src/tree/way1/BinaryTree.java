package tree.way1;

public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String value) {
		Node node = new Node(key, value);
		
		if(root==null) {
			root = node;
			return;
		} 
		Node current = root; //start travel from root
		
		while(true) {
			//System.out.println(current);
			if(key < current.getKey()) { //left branch
				if(current.getLeftChild()==null) {
					current.setLeftChild(node);
				//	System.out.println(node);
					break;
				}
				current = current.getLeftChild();
			} else { //right branch
				if(current.getRightChild()==null) {
					current.setRightChild(node);
				//	System.out.println(node);
					break;
				}
				current = current.getRightChild();
			}
			
		}
		
	}
	
	public void inOrderTraverseTree(Node focusNode) {
		
		if(focusNode == null) {
			return;
		}
		
		inOrderTraverseTree(focusNode.getLeftChild());
		System.out.println(focusNode);
		inOrderTraverseTree(focusNode.getRightChild());

	}

	public void preOrderTraverseTree(Node focusNode) {
		if(focusNode == null) {
			return;
		}
		
		System.out.println(focusNode);
		preOrderTraverseTree(focusNode.getLeftChild());	
		preOrderTraverseTree(focusNode.getRightChild());
		
	}

	public void postOrderTraverseTree(Node focusNode) {
		if(focusNode == null) {
			return;
		}		
		
		postOrderTraverseTree(focusNode.getLeftChild());	
		postOrderTraverseTree(focusNode.getRightChild());
		System.out.println(focusNode);
		
	}

}

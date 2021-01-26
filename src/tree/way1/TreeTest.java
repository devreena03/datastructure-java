package tree.way1;

public class TreeTest {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(5, "five");
		tree.addNode(8, "eight");
		tree.addNode(7, "seven");
		tree.addNode(3, "three");
		tree.addNode(12, "tweelve");
		tree.addNode(11, "eleven");
		
		tree.inOrderTraverseTree(tree.root);
		tree.preOrderTraverseTree(tree.root);
		tree.postOrderTraverseTree(tree.root);
		

	}

}

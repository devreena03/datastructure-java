package tree.way2;

public class BSTNode<T> {
	
	private Comparable<T> info;
	private BSTNode<T> leftChild;
	private BSTNode<T> rightChild;
	
	public BSTNode(Comparable<T> info) {
		this.info = info;
	}

	public BSTNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BSTNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Comparable<T> getInfo() {
		return info;
	}

	public void setInfo(Comparable<T> info) {
		this.info = info;
	}

	public BSTNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BSTNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	@Override
	public String toString() {
		return ""+this.info;
	}
}

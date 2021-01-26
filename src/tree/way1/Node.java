package tree.way1;

public class Node {
	
	private int key;
	private String value;
	private Node leftChild;
	private Node rightChild;
	
	public Node(int key, String value) {
		this.setKey(key);
		this.setValue(value);
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return value + " has the key " + key;
	}

}

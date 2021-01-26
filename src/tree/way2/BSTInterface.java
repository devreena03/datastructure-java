package tree.way2;

public interface BSTInterface<T> {
	
	//used to specify traversal order
	static final int INORDER = 1;
	static final int PREORDER = 2;
	static final int POSTORDER = 3;
	
	public boolean isEmpty();
	public int size();	
	
	public boolean contains(Comparable<T> element);
	public BSTNode<T> get(Comparable<T> element);
	
	public void add(Comparable<T> element);
	public boolean remove(Comparable<T> element);
	
	int reset(int orderType);
	public T getNext(int orderTypes);	

}

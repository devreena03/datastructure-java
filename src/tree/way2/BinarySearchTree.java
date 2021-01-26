package tree.way2;

import queue.ArrayQueue;
import stack.LinkedListStack;
import tree.way1.Node;

public class BinarySearchTree<T> implements BSTInterface<T> {
	
	private BSTNode<T> root;
	private int size;
	private ArrayQueue<T> inOrder;
	private ArrayQueue<T> preOrder;
	private ArrayQueue<T> postOrder;
	private boolean found = false;

	@Override
	public boolean isEmpty() {
		return root==null;
	}

	@Override
	public int size() {
		return this.size;
		//return iterativeSize();
		//return recSize(this.root);
	}
	
	private int recSize(BSTNode<T> tree) {
		if(tree==null)
			return 0;
		return recSize(tree.getLeftChild()) + recSize(tree.getRightChild()) + 1;
	}

	private int iterativeSize() {
		int count=0;
		
		if(!isEmpty()) {
			
			LinkedListStack<BSTNode<T>> stack = new LinkedListStack<BSTNode<T>>();
			stack.push(this.root);
			BSTNode<T> itr;
			
			while(!stack.isEmpty()) {
				itr = stack.pop();
				count++;
				
				if(itr.getLeftChild()!=null) {
					stack.push(itr.getLeftChild());
				}
				if(itr.getRightChild()!=null) {
					stack.push(itr.getRightChild());
				}
			}
		}
		
		return count;
	}

	@Override
	public void add(Comparable<T> element) {
		BSTNode<T> node = new BSTNode<>(element);
		root = recAdd(node, root);
		this.size++;
	}

	private BSTNode<T> recAdd(BSTNode<T> node, BSTNode<T> tree) {
		if(tree==null) {
			tree = node;
			return tree;
		}
			
		if(node.getInfo().compareTo((T) tree.getInfo())<0) {
			tree.setLeftChild(recAdd(node, tree.getLeftChild())); 
		} else {
			tree.setRightChild(recAdd(node, tree.getRightChild())); 
		}
		
		return tree;
	}

	@Override
	public boolean contains(Comparable<T> element) {
		return recContains(element, root);
	}

	private boolean recContains(Comparable<T> element, BSTNode<T> tree) {
		if(tree==null) return false;
		
		if(element.compareTo((T) tree.getInfo())==0)
			return true;
		
		if (element.compareTo((T) tree.getInfo())<0) {
			return recContains(element, tree.getLeftChild());
		} 
			
		return recContains(element, tree.getRightChild());
			
	}

	@Override
	public BSTNode<T> get(Comparable<T> element) {
		return recGet(element, root);
	}	

	private BSTNode<T> recGet(Comparable<T> element, BSTNode<T> tree) {
		if(tree==null) return null;
		
		if(element.compareTo((T) tree.getInfo())==0)
			return tree;
		
		if (element.compareTo((T) tree.getInfo())<0) {
			return recGet(element, tree.getLeftChild());
		} 
			
		return recGet(element, tree.getRightChild());
			
	}

	@Override
	public boolean remove(Comparable<T> element) {
		found = false;	
		root = recRemove(element, root);
		return found;
		
	}

	private BSTNode<T> recRemove(Comparable<T> element, BSTNode<T> tree) {
		
		if(tree==null) {
			found = false;
		}
		
		else if(element.compareTo((T) tree.getInfo())==0) {
			tree = removeNode(tree);
			this.size--;
			found = true;
		} else if(element.compareTo((T) tree.getInfo())<0) {
			tree.setLeftChild(recRemove(element, tree.getLeftChild()));
		} else {
			tree.setRightChild(recRemove(element, tree.getRightChild()));
		}
		
		return tree;
	}

	private BSTNode<T> removeNode(BSTNode<T> tree) {
		
		if(tree.getLeftChild()==null) 
			return tree.getRightChild();
		
		if(tree.getRightChild()== null)
			return tree.getLeftChild();
		
		//when removed node has both child
		Comparable<T> data = getPredecessor(tree.getLeftChild());
		tree.setInfo(data);
		tree.setLeftChild(recRemove(data, tree.getLeftChild()));
		return tree;
	}

	private Comparable<T> getPredecessor(BSTNode<T> subTree) {
		while(subTree.getRightChild()!=null) {
			subTree = subTree.getRightChild();
		}
		return subTree.getInfo();
	}

	//returns number of nodes reset
	@Override
	public int reset(int orderType) {
		if(orderType == INORDER) {
			inOrder =  new ArrayQueue<T>(this.size);
			inOrderTraverseTree(root);
		}
		else if(orderType == PREORDER) {
			preOrder =  new ArrayQueue<T>(this.size);
			preOrderTraverseTree(root);
		}
		else if(orderType == POSTORDER) {
			postOrder =  new ArrayQueue<T>(this.size);
			postOrderTraverseTree(root);
		}
		else {
			return 0;
		}
		return this.size;
	}

	private void inOrderTraverseTree(BSTNode<T> focusNode) {
		
		if(focusNode == null) {
			return;
		}
		
		inOrderTraverseTree(focusNode.getLeftChild());
		inOrder.enqueue((T) focusNode.getInfo());
		inOrderTraverseTree(focusNode.getRightChild());

	}

	private void preOrderTraverseTree(BSTNode<T> focusNode) {
		if(focusNode == null) {
			return;
		}
		
		preOrder.enqueue((T) focusNode.getInfo());
		preOrderTraverseTree(focusNode.getLeftChild());	
		preOrderTraverseTree(focusNode.getRightChild());
		
	}

	private void postOrderTraverseTree(BSTNode<T> focusNode) {
		if(focusNode == null) {
			return;
		}		
		
		postOrderTraverseTree(focusNode.getLeftChild());	
		postOrderTraverseTree(focusNode.getRightChild());
		postOrder.enqueue((T) focusNode.getInfo());
		
	}

	@Override
	public T getNext(int orderType) {
		if(orderType == INORDER) {
			return inOrder.dequeue();
		}
		if(orderType == PREORDER) {
			return preOrder.dequeue();
		}
		if(orderType == POSTORDER) {
			return postOrder.dequeue();
		}
		
		return null;
		
	}

}

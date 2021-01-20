package stack;

public interface BoundedStackInterface<T> extends StackInterface<T> {
	
	void push(T o) throws StackOverFlowException;
	boolean isFull();

}

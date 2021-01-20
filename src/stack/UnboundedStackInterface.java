package stack;

public interface UnboundedStackInterface<T> extends StackInterface<T> {
	
	void push(T o);

	boolean isFull();

}

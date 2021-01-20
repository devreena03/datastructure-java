package stack;

public interface StackInterface<T> {
	
	T pop() throws StackUnderFlowException;
	T top() throws StackUnderFlowException;
	boolean isEmpty();
	int size();

}

package stack;

import java.util.ArrayList;
import java.util.List;

public class ListStack<T> implements UnboundedStackInterface<T> {
	
	private List<T> stack = new ArrayList<T>();

	@Override
	public T pop() throws StackUnderFlowException {
		if(this.isEmpty()) {
			throw new StackUnderFlowException("Pop attempted on empty stack");
		}
		int lastIndex = this.stack.size()-1;
		T value = this.stack.get(lastIndex);
		this.stack.remove(lastIndex);
		return value;
	}

	@Override
	public T top() throws StackUnderFlowException {
		if(this.isEmpty()) {
			throw new StackUnderFlowException("Top attempted on empty stack");
		}
		return this.stack.get(this.stack.size()-1);
	}

	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	@Override
	public int size() {
		return this.stack.size();
	}

	@Override
	public void push(T o) {
		this.stack.add(o);
	}
	
	@Override
	public String toString() {
		
		if(isEmpty()) {
			return "[]";
		}
		
		String values = "[";
		for (int i=stack.size()-1; i >= 0;i-- ) {
			values += stack.get(i) +", ";
		}		
		return values.substring(0, values.length()-2) + "]";
		
	}

	@Override
	public boolean isFull() {
		return false;
	}


}

package stack;

public class StackUnderFlowException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public StackUnderFlowException() {
		super();
	}
	
	public StackUnderFlowException(String message) {
		super(message);
	}

}

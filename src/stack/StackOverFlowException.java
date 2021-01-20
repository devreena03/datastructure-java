package stack;

public class StackOverFlowException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public StackOverFlowException() {
		super();
	}
	
	public StackOverFlowException(String message) {
		super(message);
	}

}

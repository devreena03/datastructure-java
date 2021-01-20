package queue;

public class QueueOverFlowException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public QueueOverFlowException() {
		super();
	}
	
	public QueueOverFlowException(String message) {
		super(message);
	}
	

}

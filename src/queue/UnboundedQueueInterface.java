package queue;

public interface UnboundedQueueInterface<T> extends QueueInterface<T> {

	public void enqueue(T e);
	
}

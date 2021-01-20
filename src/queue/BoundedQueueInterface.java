package queue;

public interface BoundedQueueInterface<T> extends QueueInterface<T> {

	public void enqueue(T e) throws QueueOverFlowException; //push
	public boolean isFull();
	int size();
}

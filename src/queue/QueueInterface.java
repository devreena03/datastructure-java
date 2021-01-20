package queue;

public interface QueueInterface<T> {
	
	public T dequeue() throws QueueUnderflowException; //Pop
	public T top() throws QueueUnderflowException;
	public boolean isEmpty();
	int size();

}

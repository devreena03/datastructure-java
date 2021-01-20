package queue;

public class ArrayQueue<T> implements BoundedQueueInterface<T> {
	
	private int capacity=10;
	private T[] queue;
	private int size=0;
	private int front=0;
	private int rear;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		this.queue = (T[])new Object[this.capacity];
		this.rear = capacity-1;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		this.queue = (T[])new Object[capacity];
		this.capacity = capacity;
		this.rear = capacity-1;
	}

	@Override //Push
	public void enqueue(T e) throws QueueOverFlowException {
		if(this.isFull()) 
			throw new QueueOverFlowException("enqueue attempted on full queue");
		
		this.rear++;
		this.rear = this.rear%capacity;
		this.queue[rear] = e;
		this.size++;
		
	}
	
	@Override //Pop
	public T dequeue() throws QueueUnderflowException {
		
		if(this.size==0) 
			throw new QueueUnderflowException("dequeue attempted on empty queue");
		
		T val = this.queue[front];
		this.queue[front] = null;
		this.front ++;
		this.size--;
		return val;
	}

	@Override
	public T top() throws QueueUnderflowException {
		
		if(this.size==0) 
			throw new QueueUnderflowException("Top attempted on empty queue");
		
		return this.queue[front];
	}

	@Override
	public boolean isEmpty() {
		return this.size==0;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isFull() {
		return this.size==this.capacity;
	}
	
	@Override
	public String toString() {	
		if(isEmpty()) {
			return "[]";
		}
		
		String values = "[";
		for(int i=front; i<=this.rear; i++) {
			values += this.queue[i]+ ", ";
		}
		return values.substring(0, values.length()-2) + "]";
	}

}

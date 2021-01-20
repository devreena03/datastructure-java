package stringLog;

public interface StringLogInterface {
	
	//transformation
	public abstract void insert(String element);
	public abstract void clear();
	
	//observer
	public abstract boolean isFull();
	public abstract int size();
	public abstract boolean contains(String element);
	
	//display
	public abstract String getName();
	public abstract String toString();

}

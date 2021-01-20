package stringLog;

public class ArrayStringLog implements StringLogInterface {
	
	private String name;
	private int maxSize = 20;
	private int position = -1;
	private String[] logs;
	
	public ArrayStringLog(String name) {
		this.name = name;
		this.logs = new String[this.maxSize];
	}
	
	public ArrayStringLog(String name, int size) {
		this.name = name;
		this.maxSize = size;
		this.logs = new String[size];
	}

	@Override
	public void insert(String element) {
		if (this.position-1 == maxSize) return;
		
		this.position++;
		this.logs[position] = element;
	}

	@Override
	public void clear() {
		for(int i=0; i<=this.position; i++) {
			this.logs[i] = null;
		}
		
		this.position = -1;
	}

	@Override
	public boolean isFull() {
		return this.maxSize == this.position-1;
	}

	@Override
	public int size() {
		return this.position+1;
	}

	@Override
	public boolean contains(String element) {
		for(int i=0; i<=this.position; i++) {
			if(this.logs[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		String logString = "Log: "+this.name +"\n\n";
		for (int i=0; i<=this.position;i++) {
			logString = logString + logs[i]+"\n";
		}
		return logString;
				
	}

}

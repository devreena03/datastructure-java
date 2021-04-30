package heap;

import java.util.ArrayList;

public class ArrayHeap<T extends Comparable<T>> {
	
	private ArrayList<T> items;
	
	public ArrayHeap(){
		items = new ArrayList<>();
	}
	
	public void insert(T value) {
		items.add(value);
		shiftUp();
	}
	
	public T remove() {
		T value = items.get(0);
		T lastItem = items.remove(items.size()-1);
		System.out.println("replacing with:"+lastItem);
		items.set(0, lastItem);
		shiftDown();
		return value;
	}

	private void shiftDown() {
		
		int parent = 0;
		int left = 2*parent+1;
		int right, max;
		
		while(left<items.size()) {
			
			right = left+1;
			max = left;
			
			if(right<items.size() && items.get(right).compareTo(items.get(left))>0) {
				max = right;
			}
			
			if(items.get(max).compareTo(items.get(parent))>0) {
				System.out.println("Swaping with "+items.get(max));
				T parentItem = items.get(parent);
				items.set(parent, items.get(max));
				items.set(max, parentItem);
				
				parent = max;
				left = 2*parent+1;
				
			} else {
				break;
			}
		}
		
	}

	private void shiftUp() {
		
		int lastIndex = items.size()-1;
		System.out.println("Shifting up for value: "+items.get(lastIndex));
		
		while(lastIndex>0) {
			
			int parentIndex = (lastIndex-1)/2;
			T item = items.get(lastIndex);
			T parent = items.get(parentIndex);
			
			if(item.compareTo(parent)>0) {
				System.out.println("Swaping with "+parent);
				items.set(lastIndex, parent);
				items.set(parentIndex, item);
				lastIndex = parentIndex;
			} else {
				break;
			}
			
		}
		
	}

	@Override
	public String toString() {
		return "ArrayHeap [items=" + items + "]";
	}
	
	
}

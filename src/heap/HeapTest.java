package heap;

public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayHeap<Integer> heap = new ArrayHeap<>();
		
		heap.insert(3);
		heap.insert(2);
		heap.insert(5);
		heap.insert(7);
		heap.insert(4);
		heap.insert(9);
		heap.insert(3);
		heap.insert(8);	

		System.out.println(heap); //max heap
		
		heap.remove();
		System.out.println(heap);
	}

}

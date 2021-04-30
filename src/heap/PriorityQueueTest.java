package heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		//PriorityQueue<Integer> pq = new PriorityQueue<>(); //minheap , default natural order
		
	//	PriorityQueue<Integer> pq =new PriorityQueue<>((x, y) -> Integer.compare(y, x)); // max heap , reverse the order
		
		PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder()); //maxheap
	
		pq.add(3);
		pq.add(2);
		pq.add(5);
		pq.add(7);
		pq.add(4);
		pq.add(9);
		pq.offer(3); //same as add
		pq.add(8);	

		System.out.println(pq); 
		
		System.out.println(pq.remove());
		System.out.println(pq);
		
		System.out.println(pq.peek()); //not remove
		System.out.println(pq);
		
		System.out.println(pq.poll()); // remove
		System.out.println(pq);
		
		//iterating
		pq.forEach((item)->{
			System.out.println(" value :"+item);
		});
		
		//iteration -2
		Iterator<Integer> itr = pq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		

	}

}

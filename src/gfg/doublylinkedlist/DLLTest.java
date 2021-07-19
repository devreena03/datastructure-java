package gfg.doublylinkedlist;

public class DLLTest {
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add(2);
		dll.add(3);
		dll.add(0, 5);
		dll.add(2, 5);
		dll.add(9);
		System.out.println("1."+dll);
		System.out.println("1.reverse.."+dll.reverse());
		
		dll.remove();
		dll.removeLast();
		System.out.println("2."+dll);
		dll.removeFirst();
		System.out.println("3."+dll);
		System.out.println("3.reverse.."+dll.reverse());
		dll.removeByIndex(1);
		dll.add(9);
		System.out.println("4."+dll);
		System.out.println("4.reverse.."+dll.reverse());
		dll.remove();
		System.out.println("5."+dll);
		System.out.print("5.reverse.."+dll.reverse());
		
	}

}

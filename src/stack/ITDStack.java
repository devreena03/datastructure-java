package stack;

import java.util.Scanner;

//Interactive test driver (console based testing)
public class ITDStack {
	
	private static BoundedStackInterface<Integer> stack;
	//private static UnboundedStackInterface<Integer> stack;
	private static Scanner conIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		 
		stack = initilization(); //arraystack
		//stack = new ListStack<>(); //liststack
		//stack = new LinkedListStack<Integer>(); //linkedList
		boolean keepGoing=true;
		menuOption();
		while(keepGoing) {
			System.out.println("Enter your option");
			int operation = conIn.nextInt();
			conIn.nextLine(); //skiping the line after integer read
			keepGoing = performAction(operation);	
		}	

	}
	
	private static BoundedStackInterface<Integer> initilization() {
		
		System.out.println("Do you want default size 10? y/n?");
		String sizeOption = conIn.nextLine();
		
		if(sizeOption.charAt(0)=='n' || sizeOption.charAt(0)=='N') {
			System.out.println("what is size of log?");
			int size = conIn.nextInt();
			conIn.nextLine(); //skiping the line after integer read
			return new ArrayStack<Integer>(size);
		} 
		return new ArrayStack<Integer>();
		
	}

	private static boolean performAction(int operation) {
		switch(operation) {
			case 1: //push
				System.out.println("Enter a Value:");
				int value = conIn.nextInt();
				conIn.nextLine();
				stack.push(value);
				break;
			case 2: //pop
				System.out.println(stack.pop());
				break;
			case 3: //Top
				System.out.println(stack.top());
				break;
			case 4: //full
				if(stack.isFull()) {
					System.out.println("Yes");
				}else {
					System.out.println("No");
				}
				break;
			case 5: //size
				System.out.println(stack.size());
				break;
			case 6: //empty
				System.out.println(stack.isEmpty());
				break;
			case 7: //toString
				System.out.println(stack);
				break;
			case 8: //exit
				System.out.println("Exiting the app");
				return false;
			default:
				System.out.println("Not a valid number");	
		}
		
		return true;
	}

	private static void menuOption() {
		System.out.println("Chose and operation:");
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. Top");
		System.out.println("4. isFull");
		System.out.println("5. size");
		System.out.println("6. isEmpty");
		System.out.println("7. StackValues");
		System.out.println("8. exit");
	}

	

}

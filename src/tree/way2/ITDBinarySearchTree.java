package tree.way2;

import java.util.Scanner;

public class ITDBinarySearchTree {
	
	private static Scanner conIn = new Scanner(System.in);
	private static BSTInterface<Integer> tree;

	public static void main(String[] args) {
		tree = new BinarySearchTree<Integer>();
		boolean keepGoing=true;
		menuOption();
		while(keepGoing) {
			System.out.println("Enter your option");
			int operation = conIn.nextInt();
			conIn.nextLine(); //skiping the line after integer read
			keepGoing = performAction(operation);	
		}
	}
	
	private static boolean performAction(int operation) {
		int value;
		switch(operation) {
			case 1: //Add
				System.out.println("Enter an Integer Value");
				value = conIn.nextInt();
				conIn.nextLine();
				tree.add(value);
				break;
			case 2: //remove
				System.out.println("Enter a value to remove");
				value = conIn.nextInt();
				conIn.nextLine();
				System.out.println(tree.remove(value));
				break;
			case 3: //get
				System.out.println("Enter a value looking for");
				value = conIn.nextInt();
				conIn.nextLine();
				System.out.println(tree.get(value));
				break;
			case 4: //contains
				System.out.println("Enter a value to serach");
				value = conIn.nextInt();
				conIn.nextLine();
				System.out.println(tree.contains(value));
				break;
			case 5: //size
				System.out.println(tree.size());
				break;
			case 6: //empty
				if(tree.isEmpty()) {
					System.out.println("Yes");
				}else {
					System.out.println("No");
				}
				break;
			case 7: //toString
				System.out.println("Enter the order type want to print");
				System.out.println("1. inOrder");
				System.out.println("2. preOrder");
				System.out.println("3. postOrder");
				int orderType = conIn.nextInt();
				conIn.nextLine();
				int count = tree.reset(orderType);
				while(count>0) {
					System.out.print(tree.getNext(orderType)+", ");
					count--;
				}
				System.out.println();
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
		System.out.println("1. Add");
		System.out.println("2. remove");
		System.out.println("3. get");
		System.out.println("4. contains");
		System.out.println("5. size");
		System.out.println("6. isEmpty");
		System.out.println("7. print");
		System.out.println("8. exit");
	}


}

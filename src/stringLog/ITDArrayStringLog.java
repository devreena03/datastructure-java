package stringLog;

import java.util.Scanner;

//Interactive Test driver(Console driven app)
public class ITDArrayStringLog {
	
	private static StringLogInterface log;
	private static Scanner conIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		 
		initilization();
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
		switch(operation) {
			case 1: //insert
				System.out.println("Enter a string:");
				String value = conIn.nextLine();
				log.insert(value);
				break;
			case 2: //clear
				log.clear();
				break;
			case 3: //contains
				System.out.println("Enter a string to find");
				if(log.contains(conIn.nextLine())) {
					System.out.println("Yes");
				}else {
					System.out.println("No");
				}
				break;
			case 4: //full
				if(log.isFull()) {
					System.out.println("Yes");
				}else {
					System.out.println("No");
				}
				break;
			case 5: //size
				System.out.println(log.size());
				break;
			case 6: //getname
				System.out.println(log.getName());
				break;
			case 7: //tostring
				System.out.println(log);
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
		System.out.println("1. Insert");
		System.out.println("2. Clear");
		System.out.println("3. containes");
		System.out.println("4. isFull");
		System.out.println("5. size");
		System.out.println("6. getname");
		System.out.println("7. logs entry");
		System.out.println("8. exit");
	}

	private static void initilization() {
		System.out.println("What is the name of Test?");
		String testName = conIn.nextLine();
		
		System.out.println("Do you want default size 20? y/n?");
		String sizeOption = conIn.nextLine();
		
		if(sizeOption.charAt(0)=='n' || sizeOption.charAt(0)=='N') {
			System.out.println("what is size of log?");
			int size = conIn.nextInt();
			//log = new ArrayStringLog(testName, size);
			log = new LinkedListStringLog(testName, size);
		} else {
			//log = new ArrayStringLog(testName);
			log = new LinkedListStringLog(testName);
		}
	}

}

package gfg.stack;

import java.util.Arrays;
import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {
	
	public static void main(String[] args) {
//		printNGE(new int[] {11,13,21,3});
//		printNGE(new int[] {4,3,2,1});
//		printNGE(new int[] {4,5,2,23});
		Arrays.stream(nge(new int[] {11,13,21,3})).forEach(System.out::println);
	}
	
	public static void printNGE(int[] arr) {
		System.out.println("..................");
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		
		for(int i=1; i< arr.length; i++) {
			
			int top = stack.peek();
			while(top < arr[i]) {
				System.out.println(top+"...->"+arr[i]);
				stack.pop();
				if(!stack.isEmpty())
					top = stack.peek();
				else
					break;
			}
			stack.push(arr[i]);
			
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop()+"...->"+ -1);
		}
	}
	
	public static int[] nge(int[] arr) {
		System.out.println("..................");
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[arr.length];
		
		for(int i=arr.length-1; i>=0; i--) {
			
			while(!stack.isEmpty() && stack.peek()<=arr[i]) {
				stack.pop();
			}
			
			result[i] = stack.isEmpty() ? -1: stack.peek();
			
			stack.push(arr[i]);	
			
		}
		return result;
	}

}

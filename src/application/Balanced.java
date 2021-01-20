package application;

import stack.LinkedListStack;
import stack.StackUnderFlowException;

public class Balanced {
	
	private String openSet;
	private String closedSet;
	
	public Balanced(String openSet, String closedSet) {
		this.openSet = openSet;
		this.closedSet = closedSet;
	}
	
	/* Takes a String which need to be checked for balanced expression
	 * Returns 0 if expression is balanced
	 * Returns 1 if expression has unbalanced expression
	 * Returns 2 if expression came to end prematurely
	 */
	public int checkExpression(String exp) {
		System.out.println("Expression Given: "+exp);
		LinkedListStack<Character> stack = new LinkedListStack<>();
		
		for(int i=0; i<exp.length(); i++) {
			char curVal = exp.charAt(i);
			
			if(openSet.indexOf(curVal)>-1) {
				System.out.println("Open set: "+curVal);
				stack.push(curVal);
			} 
			else if(closedSet.indexOf(curVal)>-1) {
				System.out.println("closed set: "+curVal);
				try {
					char c = stack.pop();
					if(openSet.indexOf(c) != closedSet.indexOf(curVal)) {
						System.out.println("Unbalanced");
						return 1;
					}
				}catch(StackUnderFlowException e) {
					System.out.println(e.getMessage());
					System.out.println("Unbalanced");
					return 1;
				}
			}
			else {
				System.out.println("skipped : "+curVal);
			}
		}
		if(stack.isEmpty()) {
			System.out.println("Balanced");
			return 0;
		}
		System.out.println("expression came to end prematurely");
		return 2;
	}

}

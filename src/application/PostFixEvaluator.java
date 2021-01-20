package application;

import stack.LinkedListStack;
import stack.StackUnderFlowException;

public class PostFixEvaluator {

	LinkedListStack<Integer> stack;

	public int solve(String exp) {
		stack = new LinkedListStack<>();
		int num1 = 0;
		int num2 = 0;
		int finalVal = 0;

		for (char c : exp.toCharArray()) {
			try {
				if (c == '+') {
					num1 = stack.pop();
					num2 = stack.pop();
					finalVal = num1 + num2;
					stack.push(finalVal);
				} else if (c == '-') {
					num1 = stack.pop();
					num2 = stack.pop();
					finalVal = num2 - num1;
					stack.push(finalVal);
				} else if (c == '*') {
					num1 = stack.pop();
					num2 = stack.pop();
					finalVal = num1 * num2;
					stack.push(finalVal);
				} else if (c == '/') {
					num1 = stack.pop();
					num2 = stack.pop();
					finalVal = num2 / num1;
					stack.push(finalVal);
				} else {
					try {
						Integer val = Integer.parseInt(c + "");
						stack.push(val);
					} catch (NumberFormatException e) {
						System.out.println(e.getMessage());
						System.out.println("Invalid entry, exiting the app");
						throw e;
					}
				}
			} catch (StackUnderFlowException e) {
				System.out.println(e.getMessage());
				System.out.println("not enough opperands");
				throw e;
			}
			System.out.println(stack);
		}
		if(stack.size()>1) {
			System.out.println("less operator");
			throw new RuntimeException("less operator");
		}
		return stack.pop();
	}
}

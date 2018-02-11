package com.academy.stack.homework;

import java.util.Stack;

/*
 * Valid matching Parantheses
 * input = ((1+2)*3)	return true
 * input = ({1+2)*3)	return false
 */
public class ParanthesisMatching {

	public static void main(String[] args) {
		// String input = "((1+2)*3)";
		// String input = "({1+2)*3)";
		String input = "(((1+2)*3))";
		if (validMatchParanthesis(input)) {
			System.out.println("valid");
		}
		else {
			System.out.println("Invalid");
		}
	}

	private static boolean validMatchParanthesis(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (int index = 0; index < input.length(); index++) {
			char ch = input.charAt(index);
			if (ch == '{' || ch == '(' || ch == '[') {
				stack.push(ch);
			}
			else if (ch == '}' || ch == ')' || ch == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				else {
					char top = stack.pop();
					if ((ch == ')' && top != '(') || (ch == '}' && ch != '{') || (ch == ']' && top != '[')) {
						return false;
					}
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}

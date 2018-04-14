package com.academy.string;

import java.util.Stack;

/*
 * Basic Calculator
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {

	public static void main(String[] args) {
		String input = "  1+1+(-2+1)";
		int ans = calculate(input);
		System.out.println(ans);
	}

	public static int calculate(String s) {
		if (s == null)
			return 0;

		int result = 0;
		int sign = 1;
		int num = 0;

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(sign);

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c >= '0' && c <= '9') {
				num = num * 10 + (c - '0');

			}
			else if (c == '+' || c == '-') {
				result += sign * num;
				sign = stack.peek() * (c == '+' ? 1 : -1);
				num = 0;

			}
			else if (c == '(') {
				stack.push(sign);

			}
			else if (c == ')') {
				stack.pop();
			}
		}

		result += sign * num;
		return result;
	}

}

package com.academy.string.Ahard;

import java.util.ArrayList;
import java.util.List;

/*
 * Remove Invalid Parentheses
 * Remove the minimum number of invalid parentheses in order to make the input string valid. 
 * Return all possible results.
 * Example: 
 * 1."()())()" -> ["()()()", "(())()"]
 * 2."(a)())()" -> ["(a)()()", "(a())()"]
 * 3. ")(" -> [""]
 */
public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		String input = "()())()";
		// String input = "(a)())()";
		// String input = ")(";
		List<String> valid = removeInvalidParentheses(input);
		System.out.println(valid);
	}

	public static List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<String>();
		remove(s, ans, 0, 0, new char[] { '(', ')' });
		return ans;
	}

	private static void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
		int stack = 0;
		for (int i = last_i; i < s.length(); ++i) {
			if (s.charAt(i) == par[0]) {
				stack++;
			}
			if (s.charAt(i) == par[1]) {
				stack--;
			}
			if (stack >= 0) {
				continue;
			}
			for (int j = last_j; j <= i; ++j) {
				if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
					remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
				}
			}
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (par[0] == '(') { // finished left to right
			remove(reversed, ans, 0, 0, new char[] { ')', '(' });
		}
		else {
			// finished right to left
			ans.add(reversed);
		}
	}
}

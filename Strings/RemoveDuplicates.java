package com.academy.string;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String input = "fffggghhh";
		String output = DuplicatesTEST(input);
		System.out.println(output);
	}

	private static String DuplicatesTEST(String s) {
		StringBuilder result = new StringBuilder();
		result.append(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char prev = s.charAt(i);
			char curr = s.charAt(i - 1);
			if (curr != prev) {
				result.append(prev);
			}
		}
		return result.toString();
	}

}

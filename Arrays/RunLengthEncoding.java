package com.academy.app.array.examples;

/*
 * Compress the string with basic encoding. 
 * input = "BAAAB";
 * output = "B3AB"
 */
public class RunLengthEncoding {

	public static void main(String[] args) {
		String input = "BAAAB";
		System.out.println("Input:" + input);
		String encoded = runLengthEncoding(input);
		System.out.println("Run Length: " + encoded);
		String encoded1 = runLengthEncoding1(input);
		System.out.println("Run Length Almost similar to previous: " + encoded1);
	}

	private static String runLengthEncoding(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			int j = i + 1;
			while (j < input.length() && input.charAt(j) == temp) {
				j++;
			}
			if (j - i > 1) {
				sb.append(j - i);
				i = j - 1;
			}
			sb.append(temp);
		}
		return sb.toString();
	}

	private static String runLengthEncoding1(String source) {
		StringBuffer dest = new StringBuffer();
		for (int i = 0; i < source.length(); i++) {
			int runLength = 1;
			while (i + 1 < source.length() && source.charAt(i) == source.charAt(i + 1)) {
				runLength++;
				i++;
			}

			if (runLength > 1) {
				dest.append(runLength);
			}
			dest.append(source.charAt(i));
		}
		return dest.toString();
	}
}

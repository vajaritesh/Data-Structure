package com.academy.string.Ahard;

/*
 * Scramble String
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 */
public class ScrambleString {

	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgeat";
		if (isScramble(s1, s2)) {
			System.out.println("Scrambles");
		}
		else {
			System.out.println("Not scrambles");
		}
	}

	private static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 0) {
			return true;
		}
		if (s1.equals(s2)) {
			return true;
		}
		int len = s1.length();
		int[] count = new int[26];
		for (int i = 0; i < len; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		for (int i = 1; i < len; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
				return true;
			}
			if (isScramble(s1.substring(0, i), s2.substring(len - i))
			        && isScramble(s1.substring(i), s2.substring(0, len - i))) {
				return true;
			}
		}
		return false;
	}

}

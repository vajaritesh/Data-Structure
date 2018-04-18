package com.academy.string.Amedium;

/*
 * Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		String str = "babad"; // for isPalindrome(str, i, i);
		// String str = "cbbd"; //for isPalindrome(str, i, i + 1);
		String longestPalindrome = findLongestPalindrome(str);
		System.out.println(longestPalindrome);
	}

	private static String findLongestPalindrome(String str) {
		if (str == null) {
			return null;
		}
		if (str.length() < 2) {
			return str;
		}
		String longest = str.substring(0, 1);
		for (int i = 0; i < str.length(); i++) {
			String temp = isPalindrome(str, i, i);
			if (temp.length() > longest.length()) {
				longest = temp;
			}
			temp = isPalindrome(str, i, i + 1);
			if (temp.length() > longest.length()) {
				longest = temp;
			}
		}
		return longest;
	}

	private static String isPalindrome(String str, int start, int end) {
		while (start >= 0 && end <= str.length() - 1 && str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}
		return str.substring(start + 1, end);
	}

}

package com.academy.string.homework;

import java.util.HashMap;
import java.util.Map;

/*
 * Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
 */
public class MinimumWindowSubString {

	public static void main(String[] args) {
		// String str = "AYZABOBECODXBANCE";
		String str = "ADOBECODEBANC";
		String chars = "ABC";
		String result = findMinimumWindowSubstring(str, chars);
		// System.out.println();
		System.out.println(result);
		String result1 = minimumWindow(str, chars);
		System.out.println(result1);
	}

	private static String findMinimumWindowSubstring(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, 0);
		}
		for (char c : t.toCharArray()) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				return "";
		}

		int start = 0, end = 0, head = 0, diff = Integer.MAX_VALUE, counter = t.length();
		while (end < s.length()) {
			char c1 = s.charAt(end);
			if (map.get(c1) > 0) {
				counter--;
			}
			map.put(c1, map.get(c1) - 1);
			end++;

			while (counter == 0) {
				if (diff > end - start) {
					diff = end - start;
					head = start;
				}

				char c2 = s.charAt(start);
				map.put(c2, map.get(c2) + 1);

				if (map.get(c2) > 0) {
					counter++;
				}
				start++;
			}
		}
		return diff == Integer.MAX_VALUE ? "" : s.substring(head, head + diff);
	}

	// Short Version: Only works for Capital A to Z
	private static String minimumWindow(String str, String substr) {
		int[] count = new int[26];
		for (int i = 0; i < substr.length(); i++) {
			count[substr.charAt(i) - 'A']++;
		}
		int start = 0;
		int end = 0;
		int counter = substr.length();
		int diff = Integer.MAX_VALUE;
		int head = 0;
		while (end < str.length()) {
			if (count[str.charAt(end++) - 'A']-- > 0) {
				counter--;
			}
			while (counter == 0) {
				if (end - start < diff) {
					diff = end - start;
					head = start;
				}
				if (count[str.charAt(start++) - 'A']++ == 0) {
					counter++;
				}
			}
		}

		return diff == Integer.MAX_VALUE ? "" : str.substring(head, head + diff);
	}

}

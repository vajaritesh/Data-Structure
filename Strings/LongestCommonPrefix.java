package com.academy.string;

/*
 *  Longest Common Prefix
 *  Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "ABC", "ABD", "ABP", "ABE" };
		String str = longestCommonPrefix(strs);
		System.out.println(str);
		String result = longestCommonPrefixLeetCode(strs);
		System.out.println(result);
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		if (strs.length == 1)
			return strs[0];

		int minLen = strs.length + 1;

		for (String str : strs) {
			if (minLen > str.length()) {
				minLen = str.length();
			}
		}

		for (int i = 0; i < minLen; i++) {
			for (int j = 0; j < strs.length - 1; j++) {
				String s1 = strs[j];
				String s2 = strs[j + 1];
				if (s1.charAt(i) != s2.charAt(i)) {
					return s1.substring(0, i);
				}
			}
		}

		return strs[0].substring(0, minLen);
	}

	public static String longestCommonPrefixLeetCode(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String pre = strs[0];
		int i = 1;
		while (i < strs.length) {
			while (strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length() - 1);
			i++;
		}
		return pre;
	}
}

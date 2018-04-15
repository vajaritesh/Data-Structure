package com.academy.string;

import java.util.HashMap;

/*
 * Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 */
public class Anagram {

	public static void main(String[] args) {
		// String s = "rat";
		// String t = "cat";
		String s = "anagram";
		String t = "nagaram";
		if (isAnagram(s, t)) {
			System.out.println("Strings are anagram");
		}
		else {
			System.out.println("Strings are not anagram");
		}
		s = "anagram@#";
		t = "nagaram#@";
		if (checkAnagramForUniCodeCharacter(s, t)) {
			System.out.println("Strings are anagram");
		}
		else {
			System.out.println("Strings are not anagram");
		}
	}

	// Time O(N). Space O(1)
	private static boolean isAnagram(String s, String t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'a']--;
			if (count[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkAnagramForUniCodeCharacter(String s, String t) {
		if (s.length() != t.length())
			return false;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if (map.containsKey(c1)) {
				map.put(c1, map.get(c1) + 1);
			}
			else {
				map.put(c1, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c2 = t.charAt(i);
			if (map.containsKey(c2)) {
				if (map.get(c2) == 1) {
					map.remove(c2);
				}
				else {
					map.put(c2, map.get(c2) - 1);
				}
			}
			else {
				return false;
			}
		}

		if (map.size() > 0) {
			return false;
		}

		return true;
	}
}

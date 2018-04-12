package com.academy.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *  Longest Substring Without Repeating Characters
 *  "abcabcbb" is "abc", which the length is 3
 *  "bbbbb" the longest substring is "b", with the length of 1
 */
public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		String str = "abcabcbb";
		int max_set = longestSubstringHashSet(str);
		System.out.println(max_set);
		int max_map = longestSubstringHashMap(str);
		System.out.println(max_map);
	}

	// Big O(2n) = O(n)
	private static int longestSubstringHashSet(String str) {
		Set<Character> set = new HashSet<Character>();
		int slow = 0;
		int fast = 0;
		int max = 0;
		while (fast < str.length()) {
			if (!set.contains(str.charAt(fast))) {
				set.add(str.charAt(fast++));
				max = Math.max(max, set.size());
			}
			else {
				set.remove(str.charAt(slow++));
			}
		}
		return max;
	}

	// Big O(n)
	private static int longestSubstringHashMap(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int j = 0;
		int max = 0;
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				j = Math.max(j, map.get(str.charAt(i)) + 1);
			}
			map.put(str.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

}

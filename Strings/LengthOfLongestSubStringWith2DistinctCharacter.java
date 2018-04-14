package com.academy.string;

import java.util.HashMap;

/*
 * Longest Substring with At Most K Distinct Characters
 */
public class LengthOfLongestSubStringWith2DistinctCharacter {

	public static void main(String[] args) {
		String str = "abcbbbbcccbdddadacb";
		int k = 2;
		int max = findLengthOfLongestSubString2DistinctCharacter(str, k);
		System.out.println(max);
	}

	// Time is O(n).
	private static int findLengthOfLongestSubString2DistinctCharacter(String s, int k) {

		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
			counter++;
			if (map.size() > k) {
				// max = Math.max(max, i - start);
				max = Math.max(max, counter - 1);

				while (map.size() > k) {
					char t = s.charAt(start);
					int count = map.get(t);
					if (count > 1) {
						map.put(t, count - 1);
					}
					else {
						map.remove(t);
					}
					counter--;
					start++;
				}
			}
		}

		// max = Math.max(max, s.length() - start);
		return max;
	}
}

package com.academy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Group Anagrams
 * Given an array of strings, return all groups of strings that are anagrams.
 */
public class AnagramGroup {

	public static void main(String[] args) {
		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> lists = anagramGroupUsingSorting(input);
		for (List<String> list : lists) {
			System.out.println(list);
		}
		System.out.println();
		List<List<String>> results = anagramGroupUsingArray(input);
		for (List<String> list : results) {
			System.out.println(list);
		}
	}

	// Time is O(n*mLog(m)) n is length of String array and m is average length of each string
	private static List<List<String>> anagramGroupUsingSorting(String[] input) {
		if (input.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : input) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String newStr = String.valueOf(arr);
			if (!map.containsKey(newStr)) {
				map.put(newStr, new ArrayList<String>());
			}
			map.get(newStr).add(str);
		}
		return new ArrayList<List<String>>(map.values());

	}

	// Time is O(n*m)
	private static List<List<String>> anagramGroupUsingArray(String[] input) {
		if (input.length == 0) {
			return new ArrayList<>();
		}
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		int[] arr = new int[26];
		for (String str : input) {
			Arrays.fill(arr, 0);
			for (char c : str.toCharArray()) {
				arr[c - 'a']++;
			}
			String ns = String.valueOf(arr);
			if (!map.containsKey(ns)) {
				map.put(ns, new ArrayList<String>());
			}
			map.get(ns).add(str);
		}
		result.addAll(map.values());
		return result;
	}

}

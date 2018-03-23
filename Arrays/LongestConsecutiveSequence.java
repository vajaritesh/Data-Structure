package com.academy.app.array.examples;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4 because The longest consecutive elements sequence is [1, 2, 3, 4].
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = { 100, 4, 200, 1, 3, 2 };
		int len = longestConsecutiveSequence(arr);
		System.out.println(len);
	}

	private static int longestConsecutiveSequence(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			int start = arr[i] + 1;
			int end = arr[i] - 1;
			int count = 1;
			while (set.contains(start)) {
				set.remove(start);
				start++;
				count++;
			}
			while (set.contains(end)) {
				set.remove(end);
				end--;
				count++;
			}
			max = Math.max(max, count);
		}
		return max;
	}
}

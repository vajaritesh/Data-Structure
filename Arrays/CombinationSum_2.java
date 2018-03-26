package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Combination Sum II
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * input : [10, 1, 2, 7, 6, 1, 5] target = 8
 * output: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 */
public class CombinationSum_2 {

	public static void main(String[] args) {
		int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> result = UniqueCombinationSum(arr, target);
		print(result);
	}

	private static List<List<Integer>> UniqueCombinationSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		backtrack(result, new ArrayList<Integer>(), arr, target, 0);
		return result;
	}

	private static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] arr, int remain,
	        int start) {
		if (remain < 0) {
			return;
		}
		if (remain == 0) {
			result.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (i > start && arr[i] == arr[i - 1]) { // skip duplicates
				continue;
			}
			tempList.add(arr[i]);
			backtrack(result, tempList, arr, remain - arr[i], i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	private static void print(List<List<Integer>> result) {
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

}

package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Combination Sum
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T)
 * find all unique combinations in C where the candidate numbers sums to T. 
 * input: [2, 3, 6, 7] target = 7
 * output: [ [7], [2, 2, 3] ]
 */
public class CombinationSum {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> sums = findCombinationSum(arr, target);
		print(sums);
	}

	private static List<List<Integer>> findCombinationSum(int[] arr, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		backtrack(list, new ArrayList<>(), arr, target, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] arr, int remain, int start) {
		if (remain < 0) {
			return;
		}
		else if (remain == 0) {
			list.add(new ArrayList<>(tempList));
		}
		else {
			for (int i = start; i < arr.length; i++) {
				tempList.add(arr[i]);
				backtrack(list, tempList, arr, remain - arr[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	private static void print(List<List<Integer>> sums) {
		for (List<Integer> list : sums) {
			System.out.println(list);
		}
	}

}

package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * 
 */
public class Subsets {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		List<List<Integer>> subsets = findSubSets(arr);
		print(subsets);
	}

	private static List<List<Integer>> findSubSets(int[] arr) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		backtrack(subsets, new ArrayList<Integer>(), arr, 0);
		return subsets;
	}

	private static void backtrack(List<List<Integer>> subsets, List<Integer> tempList, int[] arr, int start) {
		subsets.add(new ArrayList<Integer>(tempList));

		for (int i = start; i < arr.length; i++) {
			tempList.add(arr[i]);
			backtrack(subsets, tempList, arr, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	private static void print(List<List<Integer>> subsets) {
		for (List<Integer> subset : subsets) {
			System.out.println(subset);
		}

	}

}

package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
/*
 * Combination Sum III
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * input: n=9 k=3
 * output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum_3 {

	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		List<List<Integer>> result = cominationSum(k, n);
		print(result);
	}

	private static List<List<Integer>> cominationSum(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		backtrack(result, new ArrayList<Integer>(), n, k, 1);
		return result;
	}

	private static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int remain, int size,
	        int start) {
		if (tempList.size() == size && remain == 0) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}
		for (int i = start; i <= 9; i++) {
			tempList.add(i);
			backtrack(result, tempList, remain - i, size, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	private static void print(List<List<Integer>> result) {
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

}

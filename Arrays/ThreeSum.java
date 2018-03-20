package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 3Sum equal to 0 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		// -4,-1,-1,0,1,2
		List<List<Integer>> result = find3SumZero(arr);
		print(result);
	}

	private static List<List<Integer>> find3SumZero(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (arr == null || arr.length < 3)
			return result;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			if (i == 0 || arr[i] > arr[i - 1]) {
				int j = i + 1;
				int k = arr.length - 1;
				while (j < k) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						List<Integer> localResult = new ArrayList<Integer>();
						localResult.add(arr[i]);
						localResult.add(arr[j]);
						localResult.add(arr[k]);
						result.add(localResult);
						j++;
						k--;
						while (j < k && arr[j] == arr[j - 1]) {
							j++;
						}
						while (j < k && arr[k] == arr[k + 1]) {
							k--;
						}
					}
					else if (arr[i] + arr[j] + arr[k] < 0) {
						j++;
					}
					else {
						k--;
					}
				}
			}
		}
		return result;
	}

	private static void print(List<List<Integer>> result) {
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}
}

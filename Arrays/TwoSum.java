package com.academy.app.array.examples;

import java.util.HashMap;
import java.util.Map;

/*
 * Two Sum Problem. Find two elements whose sum equal to given target value.
 * input = {2,6,11,7} int target = 9
 * output = {2,7} OR {index 0, index 3}
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] arr = { 12, 7, 11, 2 };
		int sum = 9;
		int[] sumIndex = twoSum(arr, sum);
		System.out.println(arr[sumIndex[0]] + "," + arr[sumIndex[1]]);
	}

	private static int[] twoSum(int[] arr, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int diff = target - arr[i];
			if (map.containsKey(diff)) {
				result[0] = i;
				result[1] = map.get(diff);
			}
			else {
				map.put(arr[i], i);
			}
		}
		return result;
	}

}

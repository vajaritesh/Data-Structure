package com.academy.app.array.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * input = {1,1,1,-2,-11,-5}
 * output = 1
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, -2, -11, -5 };
		int majorityBySorting = findMajorityElementBySorting(arr);
		System.out.println(majorityBySorting);
		int majorityByHashMap = findMajorityElementByHashMap(arr);
		System.out.println(majorityByHashMap);
		int majorityByCount = findMajorityByCount(arr);
		System.out.println(majorityByCount);
	}

	private static int findMajorityByCount(int[] arr) {
		int count = 1;
		int majority = 0;
		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				count = 1;
				majority = arr[i];
			}
			else if (majority == arr[i]) {
				count++;
			}
			else {
				count--;
			}
		}
		return majority;
	}

	private static int findMajorityElementByHashMap(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		int majority = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
				majority = Math.max(majority, map.get(arr[i]));
				max = arr[i];
			}
			else {
				map.put(arr[i], 1);
			}
		}
		return max;
	}

	private static int findMajorityElementBySorting(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length / 2];
	}

}

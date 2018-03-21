package com.academy.app.array.examples;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * input: { 3, 0, 1 }
 * output: 2
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = { 3, 0, 1 };
		// int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int num = findMissingNumByMath(arr);
		System.out.println("Missing Number is:" + num);
		int num1 = findMissingNumByHashMap(arr);
		System.out.println("Missing Number is:" + num1);
		int num2 = findMissingNumByXOR(arr);
		System.out.println("Missing Number is:" + num2);
	}

	private static int findMissingNumByXOR(int[] arr) {
		int miss = 0;
		for (int i = 0; i < arr.length; i++) {
			miss ^= (i + 1) ^ arr[i];
		}

		return miss;
	}

	private static int findMissingNumByHashMap(int[] arr) {
		// Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int min = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
			min = Math.min(min, arr[i]);
		}
		for (int i = min; i < min + arr.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return 0;
	}

	// Integer overflow may occur
	private static int findMissingNumByMath(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int n = arr.length;
		int mathSum = (n * (n + 1)) / 2;

		return mathSum - sum;
	}

}

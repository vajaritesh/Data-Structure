package com.academy.app.array.examples;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * input = { -2, 1, -3, 4, -1, 2, 1, -1, 4 };
 * output = 9
 */
public class MaximumSubArray {

	public static void main(String[] args) {
		// int[] arr = { -2, 1, -3, 4, -1, 2, 1, -1, 4 };
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = findMaxSubArray(arr);
		System.out.println(maxSum);

	}

	private static int findMaxSubArray(int[] arr) {

		int maxSoFar = arr[0], maxEndingHere = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + arr[i], arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

}

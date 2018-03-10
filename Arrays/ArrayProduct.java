package com.academy.app.array.examples;

/*
 * Product of Array Except self
 * Input = {1,2,3,4,5}			{arr[1]*..arr[n], arr[0]*arr[2]*...arr[n], ...., arr[0]*arr[1]*...arr[n-1]}
 * Output = {120,60,40,30,24}
 */
public class ArrayProduct {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		print(nums);
		int[] result1 = productArrayUsingTwoArrays(nums);
		System.out.println("Product Array using Two Arrays:");
		print(result1);
		System.out.println("Product Array using Single Array:");
		int[] result2 = productArray(nums);
		print(result2);
	}

	// Using two auxiliary arrays
	private static int[] productArrayUsingTwoArrays(int[] nums) {
		int[] result = new int[nums.length];
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = nums[i - 1] * left[i - 1];
		}
		// print(left);

		right[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = nums[i + 1] * right[i + 1];
		}
		for (int i = 0; i < nums.length; i++) {
			result[i] = left[i] * right[i];
		}
		return result;
		// print(right);
	}

	private static int[] productArray(int[] nums) {
		int[] result = new int[nums.length];
		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0) {
				left = left * nums[i - 1];
			}
			result[i] = left;
		}
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i < nums.length - 1) {
				right = right * nums[i + 1];
			}
			result[i] *= right;
		}
		return result;
	}

	private static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println();

	}
}

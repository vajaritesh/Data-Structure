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
		productArrayUsingTwoArrays(nums);
		System.out.println("Product Array using Two Arrays:");
		print(nums);
		int[] nums1 = { 1, 2, 3, 4, 5 };
		System.out.println("Product Array using Single Array:");
		int[] result2 = productArrayUsingSingleArray(nums1);
		print(result2);
	}

	// Using two auxiliary arrays
	private static void productArrayUsingTwoArrays(int[] arr) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int mul;
		left[0] = mul = arr[0];
		for (int i = 1; i < arr.length; i++) {
			mul *= arr[i - 1];
			left[i] = mul;
		}

		right[arr.length - 1] = mul = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			mul *= arr[i + 1];
			right[i] = mul;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = left[i] * right[i];
		}
	}

	private static int[] productArrayUsingSingleArray(int[] nums) {
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

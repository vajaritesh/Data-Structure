package com.academy.app.array.examples;

/*
 * Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * Input: { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }
 * Output: 6
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int capacity = messuareWater(arr);
		System.out.println(capacity);
		int optimized = messuareWaterByOptimize(arr);
		System.out.println(optimized);
	}

	// O(n) Time and O(1) Space
	private static int messuareWaterByOptimize(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int ans = 0;
		while (left < right) {
			if (arr[left] <= arr[right]) {
				if (arr[left] < leftMax) {
					ans += leftMax - arr[left];
				}
				else {
					leftMax = arr[left];
				}
				left++;
			}
			else {
				if (arr[right] < rightMax) {
					ans += rightMax - arr[right];
				}
				else {
					rightMax = arr[right];
				}
				right--;
			}
		}

		return ans;
	}

	// O(n) Time and O(n) Space
	private static int messuareWater(int[] arr) {
		int result = 0;
		if (arr == null || arr.length <= 2) {
			return result;
		}
		int[] left = new int[arr.length];
		left[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}
		int[] right = new int[arr.length];
		right[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			result += Math.min(left[i], right[i]) - arr[i];
		}
		return result;
	}

}

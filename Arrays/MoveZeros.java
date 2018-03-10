package com.academy.app.array.examples;

public class MoveZeros {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		print(nums);
		// moveZerosUnStable(nums);
		moveZerosStable(nums);
		print(nums);
	}

	// In-Place without maintaining non-zero elements relative paths. Unstable
	private static void moveZerosUnStable(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] == 0) {
				while (right > left && nums[right] == 0) {
					right--;
				}
				if (left < right) {
					swap(nums, left, right);
				}
			}
			left++;
		}
	}

	// In-Place without maintaining non-zero elements relative paths. Stable. N^2 time Complexity
	private static void moveZerosStable(int[] nums) {
		int left = 0;
		int end = nums.length;
		while (left < end) {
			if (nums[left] == 0) {
				int right = findNonZeroElement(nums, left);
				if (right < end) {
					swap(nums, left, right);
				}
			}
			left++;
		}
	}

	private static int findNonZeroElement(int[] arr, int index) {
		while (index < arr.length && arr[index] == 0) {
			index++;
		}
		return index;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;

	}

	private static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
	}

}

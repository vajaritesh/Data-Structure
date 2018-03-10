package com.academy.app.array.examples;

/*
 * Move All Zeros to right end of Array. Maintain the Non Zero element order
 * Input = { 0, 1, 0, 3, 12 }
 * Output= { 1, 3, 12, 0, 0 }
 */
public class MoveZeros {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		print(nums);
		moveZerosUnStable(nums);
		System.out.println("Unstable:");
		print(nums);
		moveZerosStable(nums);
		System.out.println("Stable with Extra Space:");
		print(nums);
		moveZerosStableOptimize(nums);
		System.out.println("Stable with Optimization:");
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

	// In-Place without maintaining non-zero elements relative paths. Stable. N^2 time and constant space Complexity
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

	// In-Place without maintaining non-zero elements relative paths. Stable. N time and space Complexity
	private static void moveZerosStableOptimize(int[] nums) {
		int[] nonZeros = new int[nums.length];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nonZeros[j++] = i;
			}
		}
		int i = 0;
		for (i = 0; i < j; i++) {
			nums[i] = nums[nonZeros[i]];
		}
		for (; i < nums.length; i++) {
			nums[i] = 0;
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

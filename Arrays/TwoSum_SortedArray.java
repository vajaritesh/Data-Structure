package com.academy.app.array.examples;

/*
 * Two Sum II – Input array is sorted
 * input = {2,7,11,15} target = 9
 * output = {0,1} (index) OR {2,7} {value}
 */
public class TwoSum_SortedArray {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int target = 9;
		int[] sumIndex = findSumIndex(arr, target);
		System.out.println(arr[sumIndex[0]] + "," + arr[sumIndex[1]]);
	}

	private static int[] findSumIndex(int[] arr, int target) {
		int left = 0;

		int right = arr.length - 1;
		while (left <= right) {
			if (arr[left] + arr[right] == target) {
				return new int[] { left, right };
			}
			else if (arr[left] + arr[right] > target) {
				right--;
			}
			else {
				left++;
			}
		}
		return new int[] { -1, -1 };
	}
}

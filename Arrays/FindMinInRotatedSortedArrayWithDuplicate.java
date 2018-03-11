package com.academy.app.array.examples;

/*
 * Find Min value from Rotated Sorted Array [With Duplicates]
 * input={7, 18, 18, 18, 29, 1, 4, 6}
 * output = 1
 */
public class FindMinInRotatedSortedArrayWithDuplicate {

	public static void main(String[] args) {
		int[] arr = { 7, 18, 18, 18, 29, 1, 4, 6 }; // 3, 1, 3
		int min = findMin(arr);
		System.out.println(min);
	}

	private static int findMin(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		while (left <= right) {
			while (arr[left] == arr[right] && left != right) {
				left++;
			}
			if (arr[left] <= arr[right]) {
				return arr[left];
			}
			mid = (left + right) / 2;
			if (arr[left] <= arr[mid]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return -1;
	}

}

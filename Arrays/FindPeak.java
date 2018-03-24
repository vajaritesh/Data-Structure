package com.academy.app.array.examples;

/*
 * Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeak {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1 };
		int peak = findPeak(arr);
		System.out.println(arr[peak]);
		int peak1 = findPeakByBinarySearchIterative(arr);
		System.out.println(arr[peak1]);
	}

	private static int findPeakByBinarySearchIterative(int[] arr) {
		return binarySearch(arr, 0, arr.length - 1);
	}

	private static int binarySearch(int[] arr, int low, int high) {
		while (low < high) {
			int mid = (low + high) / 2;
			if (arr[mid] > arr[mid + 1]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int findPeak(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return arr.length - 1;
	}
}

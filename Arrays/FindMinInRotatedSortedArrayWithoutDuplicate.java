package com.academy.app.array.examples;

/*
 * Find Min value from Rotated Sorted Array [Without Duplicates]
 * input={7, 18, 29, 1, 4, 6}
 * output = 1
 */
public class FindMinInRotatedSortedArrayWithoutDuplicate {
	// 4,5,6,7,1,2,3
	// 1,2,3
	// 4,1,2,3
	// 1,2,3,4,5
	public static void main(String[] args) {
		int[] arr = { 7, 18, 29, 1, 4, 6 }; // This will fail for 7, 18, 18, 18, 29, 1, 4, 6
		// int[] arr = { 3, 1, 2 }; //1,2,3 //2,3,1 //3,1,2
		int min = findMin(arr);
		System.out.println(min);
	}

	private static int findMin(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		int mid;
		while (left <= right) {
			if (arr[left] <= arr[right]) {
				return arr[left];
			}

			mid = (left + (right - left)) / 2;
			if (arr[left] <= arr[mid]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}

			// if (arr[mid] >= arr[left]) {
			// left = mid + 1;
			// }
			// else {
			// right = mid;
			// }
		}
		return -1;
	}

}

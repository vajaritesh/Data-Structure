package com.academy.sorting;

/*
 * Merge Sort: Divide the array in middle and merge them back using temporary array
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n);
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 2, 3, 6 };
		int leftStart = 0;
		int rightEnd = arr.length - 1;
		mergeSort(arr, new int[arr.length], leftStart, rightEnd);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int mid = (leftStart + rightEnd) / 2;
		mergeSort(arr, temp, leftStart, mid);
		mergeSort(arr, temp, mid + 1, rightEnd);
		merge(arr, temp, leftStart, rightEnd);
	}

	private static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {

		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] < arr[right]) {
				temp[index] = arr[left++];
			}
			else {
				temp[index] = arr[right++];
			}
			index++;
		}
		while (left <= leftEnd) {
			temp[index++] = arr[left++];
		}
		while (right <= rightEnd) {
			temp[index++] = arr[right++];
		}

		// System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		// System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		// System.arraycopy(temp, leftStart, arr, leftStart, size);

		// System.arraycopy(temp, leftStart, arr, leftStart, size);
		for (int i = leftStart; i < size; i++) {
			arr[i] = temp[i];
		}
	}

}

package com.academy.sorting;

/*
 * Selection Sort: Find minimum elements and swap with first element. Find second minimum element and swap with second elememnts. Keep contineu till N-1.  
 * Time Complexity: O(n^2)
 * Space Complexity: O(1);
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 2, 3, 6 };
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

}

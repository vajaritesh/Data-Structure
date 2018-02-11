package com.academy.sorting;

/*
 * Insertion Sort: Sort element at starting. Good sorting for array with almost sorted data  
 * Time Complexity: O(n^2)
 * Space Complexity: O(1);
 */
public class Insertion {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 2, 3, 6 };
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void insertionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}

	}

}

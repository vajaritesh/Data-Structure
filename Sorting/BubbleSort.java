package com.academy.sorting;

/*
 * Bubble Sort: Comare array element with rest of elements and swap if element is greater then rest of elements.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1);
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 2, 3, 6 };
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void bubbleSort(int[] arr) {
		boolean flag = false;
		for (int j = 0; j < arr.length; j++) {
			flag = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					flag = true;
					int temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
				}
			}
			if (!flag) {
				break;
			}
		}
	}
}

package com.academy.sorting;

/*
 * Quick Sort: Partition around pivot index and swap all samller elements then pivot towards left and greater towards right. 
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1);
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 2, 4, 70, 3, 90 };
		// {4, 2, 2, 4, 70, 3, 90},
		// {4, 4, 4, 4, 4, 4, 4},
		// {9, 5, 2, 3, 6, 1},
		// {1, 6, 3, 6, 5, 9},
		// {2,1,3}
		// int[] arr = { 10, 5, 20, 2, 3, 6, 1 };
		int left = 0;
		int right = arr.length - 1;
		quickSort(arr, left, right);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		// int pivot = arr[(left + right) / 2];
		int pivot = arr[left];
		int pIndex = partition(arr, left, right, pivot);
		quickSort(arr, left, pIndex - 1);
		quickSort(arr, pIndex, right);
	}

	private static int partition(int[] arr, int left, int right, int pivot) {
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}

}

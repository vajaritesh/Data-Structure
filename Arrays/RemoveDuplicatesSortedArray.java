package com.academy.app.array.examples;

/*
 * Remove Duplicates from Sorted Array
 * input = {1, 1, 2, 3, 4, 4, 4, 5 }
 * output = 5 {1,2,3,4,5}
 */
public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 4, 4, 4, 5 };
		int length = findUniqueElementLength(arr);
		System.out.println(length);
		print(arr);
		removeDuplicates(arr);
		print(arr);
	}

	private static void removeDuplicates(int[] arr) {
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[j]) {
				arr[++j] = arr[i];
			}
		}
	}

	private static int findUniqueElementLength(int[] arr) {
		int j = 0;
		int count = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			j = j + 1;
			if (arr[i] != arr[j]) {
				count++;
			}
		}
		return count;
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

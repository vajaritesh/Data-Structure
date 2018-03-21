package com.academy.app.array.examples;

/*
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotateKRight(arr, k);
		print(arr);
	}

	private static void rotateKRight(int[] arr, int k) {
		k %= arr.length;
		swap(arr, 0, arr.length - 1);
		swap(arr, 0, k - 1);
		swap(arr, k, arr.length - 1);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp;
		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

package com.academy.app.array.examples;

/*
 * Remove all instance of given value from input array.
 * input = {3,2,2,3} target = 3;
 * output = {2,2} new length = 2
 */
public class RemoveAllInstanceOfElement {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 2, 3 };
		int target = 3;
		int len = findLength(arr, target);
		System.out.println(len);
		print(arr, arr.length);
		int newLength = removeAllInstance(arr, target);
		print(arr, newLength);
	}

	private static int removeAllInstance(int[] arr, int target) {
		int newIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != target) {
				arr[newIndex++] = arr[i];
			}
		}
		return newIndex;
	}

	private static void print(int[] arr, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static int findLength(int[] arr, int target) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != target) {
				count++;
			}
		}
		return count;
	}

}

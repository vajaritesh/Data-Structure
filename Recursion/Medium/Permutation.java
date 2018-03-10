package com.academy.recursion.examples;

public class Permutation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };

		printPermutations(arr, 0);
		// System.out.println("=========================");
		// printPermutationsReverse(arr, arr.length - 1);
	}

	private static void printPermutations(int[] arr, int start) {
		if (start == arr.length) {
			print(arr);
			return;
		}
		for (int curr = start; curr < arr.length; curr++) {
			swap(arr, start, curr);
			printPermutations(arr, start + 1);
			swap(arr, start, curr);
		}
	}

	private static void printPermutationsReverse(int[] arr, int start) {
		if (start == 0) {
			print(arr);
		}
		for (int curr = start; curr >= 0; curr--) {
			swap(arr, start, curr);
			printPermutationsReverse(arr, start - 1);
			swap(arr, start, curr);
		}
	}

	private static void swap(int[] arr, int start, int curr) {
		int temp = arr[start];
		arr[start] = arr[curr];
		arr[curr] = temp;

	}

	private static void print(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

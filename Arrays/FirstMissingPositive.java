package com.academy.app.array.examples;

/*
 * First Missing Positive
 * Given an unsorted integer array, find the first missing positive integer.
 * Input: [1,2,0]
 * Output: 3
 * Input: [3,4,-1,1]
 * Output: 2
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 0, 3 };
		// int[] arr = { 3, 4, -1, 1 };
		int[] arr = { 19, 21, 20, 25 };

		int ans = missingInteger(arr);
		System.out.println(ans);

		// int posoitiveNumAns = missingIntegerIfAllInputPositive(arr);
		// System.out.println(posoitiveNumAns);
	}

	// O(n) Time and O(1) Space
	private static int missingInteger(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
				int temp = arr[i];
				arr[i] = arr[temp - 1];
				arr[temp - 1] = temp;
			}
			// while (arr[i] != i + 1) {
			// if (arr[i] <= 0 || arr[i] >= n) {
			// break;
			// }
			// if (arr[i] == arr[arr[i] - 1]) {
			// break;
			// }
			// int temp = arr[i];
			// arr[i] = arr[temp - 1];
			// arr[temp - 1] = temp;
			// }
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

	// This method only for positive numbers
	private static int missingIntegerIfAllInputPositive(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			while (arr[i] != i) {
				if (arr[i] < 0 || arr[i] >= n) {
					break;
				}
				if (arr[i] == arr[arr[i]]) {
					break;
				}
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] != i) {
				return i;
			}
		}
		return n;
	}

}

package com.academy.app.array.examples;

/*
 * Given an index k, return the kth row of the Pascal's triangle.
 * input:  k = 3,
 * output: [1,3,3,1].
 */
public class PascalTriangleKRow {

	public static void main(String[] args) {
		int k = 3;
		int[] kthRow = pascalTriangle(k);
		print(kthRow);
	}

	private static int[] pascalTriangle(int k) {
		int[] result = new int[k + 1];
		result[0] = 1;
		for (int i = 1; i <= k; i++) {
			for (int j = i; j >= 1; j--) {
				result[j] += result[j - 1];
			}
		}
		return result;
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

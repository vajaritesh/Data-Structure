package com.academy.app.array.examples;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order. 
 */
public class SpiralMatrix_2 {

	public static void main(String[] args) {
		int n = 4;
		int[][] result = generateSpiralMatrix(n);
		print(result);
	}

	private static void print(int[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + "  ");
			}
			System.out.println();
		}

	}

	private static int[][] generateSpiralMatrix(int n) {
		int[][] result = new int[n][n];
		int k = 1;
		int left = 0;
		int right = n - 1;
		int top = 0;
		int bottom = n - 1;
		while (k <= n * n) {
			for (int i = left; i <= right; i++) {
				result[top][i] = k;
				k++;
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				result[i][right] = k;
				k++;
			}
			right--;

			for (int i = right; i >= left; i--) {
				result[bottom][i] = k;
				k++;
			}
			bottom--;

			for (int i = bottom; i >= top; i--) {
				result[i][left] = k;
				k++;
			}
			left++;
		}
		return result;
	}

}

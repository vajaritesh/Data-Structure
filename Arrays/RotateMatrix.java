package com.academy.app.array.examples;

/*
 * Rotate Image(Matrix)
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise/anti clockwise).
 */
public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix90Clock = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		System.out.println("Input 1:");
		print(matrix90Clock);
		rotateMatrix90ClockWise(matrix90Clock);
		System.out.println("Rotate 90 degree Clock wise:");
		print(matrix90Clock);
		int[][] matrix180Clock = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix180ClockWise(matrix180Clock);
		System.out.println("Rotate 180 degree Clock wise:");
		// print(matrix180Clock);
		int[][] matrix270Clock = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix270ClockWise(matrix270Clock);
		System.out.println("Rotate 270 degree Clock wise:");
		// print(matrix270Clock);
		int[][] matrix90AntiClock = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix90AntiClockWise(matrix90AntiClock);
		System.out.println();
		System.out.println("Rotate 90 degree Anti Clock wise:");
		print(matrix90AntiClock);
		int[][] matrix180AntiClock = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix180AntiClockWise(matrix180AntiClock);
		System.out.println("Rotate 180 degree Anti Clock wise:");
		// print(matrix180AntiClock);
		int[][] matrix270AntiClock = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix270AntiClockWise(matrix270AntiClock);
		System.out.println("Rotate 270 degree Anti Clock wise:");
		// print(matrix270AntiClock);

	}

	private static void rotateMatrix270AntiClockWise(int[][] matrix270AntiClock) {
		// TODO Auto-generated method stub

	}

	private static void rotateMatrix180AntiClockWise(int[][] matrix180AntiClock) {
		// TODO Auto-generated method stub

	}

	private static void rotateMatrix270ClockWise(int[][] matrix270Clock) {
		// TODO Auto-generated method stub

	}

	private static void rotateMatrix180ClockWise(int[][] matrix180Clock) {
		// TODO Auto-generated method stub

	}

	private static void rotateMatrix90ClockWise(int[][] matrix) {

		reverseTopDown(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; ++j) {
				// for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	private static void reverseTopDown(int[][] matrix) {
		int start = 0;
		int end = matrix.length - 1;
		while (start < end) {
			int[] temp = matrix[start];
			matrix[start] = matrix[end];
			matrix[end] = temp;
			start++;
			end--;
		}

	}

	private static void rotateMatrix90AntiClockWise(int[][] matrix) {
		reverseLeftRight(matrix);
		for (int row = 0; row < matrix.length; row++) {
			for (int col = row + 1; col < matrix[row].length; col++) {
				int temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}
	}

	private static void reverseLeftRight(int[][] matrix) {
		int start = 0;
		int end = matrix[0].length - 1;
		while (start < end) {
			for (int row = 0; row < matrix.length; row++) {
				int temp = matrix[row][start];
				matrix[row][start] = matrix[row][end];
				matrix[row][end] = temp;
			}
			start++;
			end--;
		}
	}

	private static void print(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}

	}

}

package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> sprialMatrix = convertToSpiralMatrix(matrix);
		print(sprialMatrix);
	}

	private static void print(List<Integer> sprialMatrix) {
		System.out.println(sprialMatrix);
	}

	private static List<Integer> convertToSpiralMatrix(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return res;
		}
		int rowBegin = 0;
		int colBegin = 0;
		int rowEnd = matrix.length - 1;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {

		}
		return res;
	}
}

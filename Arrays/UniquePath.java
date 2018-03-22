package com.academy.app.array.examples;

/*
 * Unique Paths
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid 
 * How many possible unique paths are there? 
 */
public class UniquePath {

	public static void main(String[] args) {
		int m = 3;
		int n = 7;

		int DFSpaths = countUniquePathsByDFS(0, 0, m, n);
		System.out.println(DFSpaths);
		int DPpaths = countUniquePathsByDP(m, n);
		System.out.println(DPpaths);
	}

	private static int countUniquePathsByDP(int endRow, int endCol) {
		if (endRow == 0 || endCol == 0)
			return 0;
		if (endRow == 1 || endCol == 1)
			return 1;
		int[][] dp = new int[endRow][endCol];
		for (int col = 0; col < endCol; col++) {
			dp[0][col] = 1;
		}
		for (int row = 0; row < endRow; row++) {
			dp[row][0] = 1;
		}

		for (int row = 1; row < endRow; row++) {
			for (int col = 1; col < endCol; col++) {
				dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
			}
		}
		return dp[endRow - 1][endCol - 1];
	}

	private static int countUniquePathsByDFS(int startRow, int startCol, int endRow, int endCol) {
		if (startRow == endRow - 1 && startCol == endCol - 1) {
			return 1;
		}
		if (startRow < endRow - 1 && startCol < endCol - 1) {
			return countUniquePathsByDFS(startRow + 1, startCol, endRow, endCol)
			        + countUniquePathsByDFS(startRow, startCol + 1, endRow, endCol);
		}
		if (startRow < endRow - 1) {
			return countUniquePathsByDFS(startRow + 1, startCol, endRow, endCol);
		}
		if (startCol < endCol - 1) {
			return countUniquePathsByDFS(startRow, startCol + 1, endRow, endCol);
		}
		return 0;
	}

}

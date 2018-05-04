package com.academy.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 	NQueen Problem with all placement
 *  Given a chess board of N x N , find all ways to place N queens so that they don't each other.
 */
public class NQueenAllPlacement {

	public static void main(String[] args) {
		int N = 4;
		int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		List<Integer> result = new ArrayList<Integer>();
		if (solve(board, 0, N, result)) {
			print(board);
		}
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static boolean solve(int[][] board, int col, int N, List<Integer> result) {
		if (col == N) {
			// System.out.println(result);
			print(board);
			System.out.println();
			return true;
		}
		for (int row = 0; row < board[0].length; row++) {

			if (!isAttacked(col, row, board)) {
				board[col][row] = 1;
				result.add(col);
				// N--;

				if (solve(board, col + 1, N, result)) {
					return true;
				}
				board[col][row] = 0;
				result.remove(result.size() - 1);
				// N++;
			}
		}

		return false;

	}

	private static boolean isAttacked(int col, int row, int[][] board) {
		for (int rowIndex = 0; rowIndex < board[0].length; rowIndex++) {
			if (board[col][rowIndex] == 1 && rowIndex != row) {
				return true;
			}
			if (board[rowIndex][row] == 1 && rowIndex != col) {
				return true;
			}
		}

		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			for (int colIndex = 0; colIndex < board[0].length; colIndex++) {
				if (rowIndex - colIndex == row - col || rowIndex + colIndex == row + col) {
					if (board[colIndex][rowIndex] == 1 && (rowIndex != row || colIndex != col)) {
						return true;
					}
				}
			}
		}

		return false;
	}

}

package com.academy.recursion.backtracking;

/*
 * NQueen Problem
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. 
 */
public class NQueenSinglePlacement {

	public static void main(String[] args) {
		int N = 4;
		solveNQueen(N);
	}

	private static void solveNQueen(int N) {
		int[][] board = new int[N][N];
		if (solveNQueenUtil(board, 0)) {
			print(board);
		}
		else {
			System.out.println("Solution does not exist");
		}

	}

	private static boolean solveNQueenUtil(int[][] board, int col) {
		if (col == board.length) {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				if (solveNQueenUtil(board, col + 1)) {
					return true;
				}
				board[i][col] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		// Check row on left side
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		// Upper left Diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		// Lower left Diagonal
		for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}

	}

}

package com.academy.recursion.backtracking;

import java.util.HashSet;

/*
 * Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 */
public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board =
		        { { '3', '.', '6', '5', '.', '8', '4', '.', '.' }, { '5', '2', '.', '.', '.', '.', '.', '.', '.' },
		                { '.', '8', '7', '.', '.', '.', '.', '3', '1' },
		                { '.', '.', '3', '.', '1', '.', '.', '8', '.' },
		                { '9', '.', '.', '8', '6', '3', '.', '.', '5' },
		                { '.', '5', '.', '.', '9', '.', '6', '.', '.' },
		                { '1', '3', '.', '.', '.', '.', '2', '5', '.' },
		                { '.', '.', '.', '.', '.', '.', '.', '7', '4' },
		                { '.', '.', '5', '2', '.', '6', '3', '.', '.' } };
		print(board);
		solveSudoku(board);
		print(board);
	}

	private static void print(char[][] soduku) {
		for (int row = 0; row < soduku.length; ++row) {
			if (row % 3 == 0)
				System.out.println("+-------+-------+-------+");

			for (int col = 0; col < soduku.length; col++) {
				if (col % 3 == 0)
					System.out.print("| ");

				System.out.print(soduku[row][col] == 0 ? "  " : soduku[row][col] + " ");
			}
			System.out.println("|");
		}
		System.out.println("+-------+-------+-------+");
	}

	public static void solveSudoku(char[][] board) {
		solve(board);
	}

	public static boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.')
					continue;

				for (int k = 1; k <= 9; k++) {
					board[i][j] = (char) (k + '0');
					if (isValid(board, i, j) && solve(board))
						return true;
					board[i][j] = '.';
				}

				return false;
			}
		}

		return true;
	}

	public static boolean isValid(char[][] board, int i, int j) {
		HashSet<Character> set = new HashSet<Character>();

		for (int k = 0; k < 9; k++) {
			if (set.contains(board[i][k]))
				return false;

			if (board[i][k] != '.') {
				set.add(board[i][k]);
			}
		}

		set.clear();

		for (int k = 0; k < 9; k++) {
			if (set.contains(board[k][j]))
				return false;

			if (board[k][j] != '.') {
				set.add(board[k][j]);
			}
		}

		set.clear();

		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				int x = i / 3 * 3 + m;
				int y = j / 3 * 3 + n;
				if (set.contains(board[x][y]))
					return false;

				if (board[x][y] != '.') {
					set.add(board[x][y]);
				}
			}
		}

		return true;
	}
}

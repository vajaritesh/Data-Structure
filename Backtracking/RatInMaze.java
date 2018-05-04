package com.academy.recursion.backtracking;

//Rat in a Maze
//Move (0,0) to (N-1,M-1) 

public class RatInMaze {

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		solveMaze(maze);
	}

	public static void solveMaze(int[][] maze) {
		int[][] solve = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		if (mazeHelper(maze, 0, 0, solve)) {
			print(solve);
		}
		else {
			System.out.println("Can't solve maze");
		}
	}

	public static Boolean mazeHelper(int[][] maze, int x, int y, int[][] solve) {

		if (x == maze.length - 1 && y == maze.length - 1) {
			solve[x][y] = 1;
			return true;
		}
		if (isValidPosition(maze, x, y)) {
			solve[x][y] = 1;
			if (mazeHelper(maze, x, y + 1, solve)) {
				return true;
			}
			if (mazeHelper(maze, x + 1, y, solve)) {
				return true;
			}
			solve[x][y] = 0;
			return false;
		}
		return false;
	}

	public static Boolean isValidPosition(int[][] maze, int x, int y) {
		return x < maze.length && y < maze.length && maze[x][y] == 1;
	}

	private static void print(int[][] solve) {
		for (int row = 0; row < solve.length; row++) {
			for (int col = 0; col < solve.length; col++) {
				System.out.print(solve[row][col] + " ");
			}
			System.out.println();
		}
	}
}

package com.academy.recursion.backtracking;

//A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
//In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination. Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with limited number of moves.

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

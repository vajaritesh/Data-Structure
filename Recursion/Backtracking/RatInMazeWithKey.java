package com.academy.recursion.backtracking;

/*
 * http://codingrecipies.blogspot.com/2013/10/problem-statement-help-jerry-walk.html
 * Maze with Key
 */
public class RatInMazeWithKey {

	public static void main(String[] args) {
		RatInMazeWithKey mazeObj = new RatInMazeWithKey();
		mazeObj.init();
	}

	// Move Down-> Right->Up->Left->NW->NE->SE->SW
	static int[] X = { 1, 0, -1, 0, -1, -1, 1, 1 };
	static int[] Y = { 0, 1, 0, -1, -1, 1, 1, -1 };

	private void init() {
		int[][] maze =
		        { { 1, 1, 0, 0, 1, 1 }, { 1, 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 1, 0 }, { 1, 1, 1, 2, 0, 0 },
		                { 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1 } };

		int[][] solution = new int[maze.length][maze[0].length];

		System.out.println("Input Matrix is ");
		printSolution(maze);

		System.out.println("===========================");
		if (solveMaze(maze, 0, 0, solution, false)) {
			printSolution(solution);
		}
	}

	private boolean solveMaze(int[][] maze, int x, int y, int[][] solution, boolean isKeyFound) {
		if (x == maze.length - 1 && y == maze[0].length - 1) {
			if (isKeyFound) {
				solution[x][y] = 1;
				return true;
			}
		}
		for (int i = 0; i < X.length; i++) {
			if (isSafe(maze, x, y)) {

				if (solution[x][y] != 1) {
					solution[x][y] = 1;
					int nextX = x + X[i];
					int nextY = y + Y[i];

					if (maze[x][y] == 2) {
						isKeyFound = true;
					}
					if (solveMaze(maze, nextX, nextY, solution, isKeyFound)) {
						return true;
					}
					solution[x][y] = 0;
					if (maze[x][y] == 2) {
						isKeyFound = false;
					}
				}
			}
		}
		return false;
	}

	private boolean isSafe(int[][] maze, int x, int y) {
		return (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && (maze[x][y] == 1 || maze[x][y] == 2));
	}

	private void printSolution(int[][] solution) {
		int rLen = solution.length;
		int cLen = solution[0].length;

		for (int i = 0; i < rLen; i++) {
			for (int j = 0; j < cLen; j++) {
				System.out.print(solution[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

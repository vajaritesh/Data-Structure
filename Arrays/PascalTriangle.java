package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.List;

/*
 * Print Pascal's triangle.
 * input = 5
 * output = 
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 */
public class PascalTriangle {

	public static void main(String[] args) {
		int n = 5;
		List<List<Integer>> triangle = buildPascalTriangle(n);
		print(triangle);
		List<List<Integer>> triangle1 = buildPascalTriangle1(n);
		print(triangle1);
	}

	private static List<List<Integer>> buildPascalTriangle1(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		result.get(0).add(1);
		for (int row = 1; row < n; row++) {
			List<Integer> currRow = new ArrayList<Integer>();
			List<Integer> prevRow = result.get(row - 1);
			currRow.add(1);
			for (int col = 1; col < row; col++) {
				currRow.add(prevRow.get(col) + prevRow.get(col - 1));
			}
			currRow.add(1);
			result.add(currRow);
		}
		return result;
	}

	private static List<List<Integer>> buildPascalTriangle(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> prev = new ArrayList<Integer>();
		prev.add(1);
		result.add(prev);
		for (int row = 2; row <= n; row++) {
			List<Integer> curr = new ArrayList<Integer>();
			curr.add(1);
			for (int j = 0; j < prev.size() - 1; j++) {
				curr.add(prev.get(j) + prev.get(j + 1));
			}
			curr.add(1);
			result.add(curr);
			prev = curr;
		}
		return result;
	}

	private static void print(List<List<Integer>> triangle) {
		for (List<Integer> line : triangle) {
			System.out.println(line);
		}

	}
}

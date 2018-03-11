package com.academy.app.array.examples;

import java.util.Stack;

/*
 * Find largest rectangular area in Histogram
 * input = { 6, 2, 5, 4, 5, 1, 6 }
 * output= 12 => [5,4,5] => 4*3 = 12
 */
public class LargestRectangularAreaHistogram {

	public static void main(String[] args) {
		// int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		int[] arr = { 2, 3, 1 };
		int maxArea = maxArea(arr);
		System.out.println(maxArea);
	}

	private static int maxArea(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		int height = 0;
		int width = 0;
		int i = 0;

		while (i < arr.length) {
			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i++);
			}
			else {
				height = arr[stack.pop()];
				width = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, height * width);
			}
		}
		while (!stack.isEmpty()) {
			height = arr[stack.pop()];
			width = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(maxArea, height * width);
		}

		return maxArea;
	}

}

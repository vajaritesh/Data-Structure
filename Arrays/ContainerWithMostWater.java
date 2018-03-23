package com.academy.app.array.examples;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two end points of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int maxArea = findMaxArea(arr);
		System.out.println(maxArea);
	}

	private static int findMaxArea(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int maxArea = Integer.MIN_VALUE;
		int minHeight = Integer.MAX_VALUE;
		while (left < right) {
			minHeight = Math.min(arr[left], arr[right]);
			maxArea = Math.max(maxArea, (right - left) * minHeight);
			if (arr[left] < arr[right]) {
				left++;
			}
			else {
				right--;
			}
		}
		return maxArea;
	}

}

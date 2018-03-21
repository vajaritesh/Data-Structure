package com.academy.app.array.examples;

/*
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * input = {1,3,5,6} target = 5
 * output = 2
 * input = {1,3,5,6} target = 7
 * output = 4
 * input = {1,3,5,6} target = 0
 * output = 0
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] arr = { 1, 5 };
		int target = 6;
		int index = searchInsertPosition(arr, target);
		System.out.println("Index position should be:" + index);
	}

	private static int searchInsertPosition(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return left;
	}

}

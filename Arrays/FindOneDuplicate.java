package com.academy.app.array.examples;

/*
 * Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive)
 * there is only one duplicate number, find the duplicate one.
 * Restriction:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindOneDuplicate {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 5, 4, 3 };
		int duplicate = findDuplicate(arr);
		System.out.println(duplicate);
	}

	private static int findDuplicate(int[] arr) {
		int slow = arr[0];
		int fast = arr[arr[0]];
		while (slow != fast) {
			slow = arr[slow];
			fast = arr[arr[fast]];
		}
		fast = 0;
		while (slow != fast) {
			slow = arr[slow];
			fast = arr[fast];
		}
		return slow;
	}

}

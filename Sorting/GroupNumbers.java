package com.academy.sorting.homework;

/*
 * Given input arrays, group the elements in even odd numbers
 * input = {1,3,5,4,6}
 * output = {6,4,5,3,1}	
 */
public class GroupNumbers {

	public static void main(String[] args) {
		int[] input = { 1, 3, 5, 4, 6 };
		groupNumbers(input);
		print(input);
	}

	private static void print(int[] output) {
		for (int index = 0; index < output.length; index++) {
			System.out.print(output[index] + " ");
		}
		System.out.println();
	}

	private static void groupNumbers(int[] input) {
		int left = 0;
		int right = input.length - 1;
		while (left <= right) {
			while (left <= right && input[left] % 2 == 0) {
				left++;
			}
			while (right >= 0 && input[right] % 2 != 0) {
				right--;
			}
			if (left <= right) {
				int temp = input[left];
				input[left] = input[right];
				input[right] = temp;
				left++;
				right--;
			}
		}
	}

}

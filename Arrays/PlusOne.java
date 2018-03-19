package com.academy.app.array.examples;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number. 
 * The digits are stored such that the most significant digit is at the head of the list.
 * input = {1,9}
 * output = {2,0}
 * input = {9,9}
 * output = {1,0,0}
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] arr = { 9, 9 };
		print(arr);
		int[] result = plusOneArr(arr);
		print(result);
	}

	private static int[] plusOneArr(int[] arr) {
		int[] result = new int[arr.length];
		int carry = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			int sum = arr[i] + carry;
			if (sum > 9) {
				carry = 1;
			}
			else {
				carry = 0;
			}
			result[i] = sum % 10;
		}
		if (carry == 1) {
			int[] newResult = new int[arr.length + 1];
			newResult[0] = 1;
			for (int i = 0; i < result.length; i++) {
				newResult[i + 1] = result[i];
			}
			return newResult;
		}
		else {
			return result;
		}

	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

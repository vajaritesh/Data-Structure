package com.academy.app.array.examples;

/*
 * Find the Hamming Weight of given number. We need to find out how many total bits are turned on.
 * input = {31,51};	31 has 5 bits 1 and 51 has 4 bits 1.
 * output = 9;
 */
public class HammingWeight {

	public static void main(String[] args) {
		int[] arr = { 31, 51 };
		int weight = findHammingWeight(arr);
		System.out.println(weight);
	}

	private static int findHammingWeight(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count += countOne(arr[i]);
		}
		return count;
	}

	private static int countOne(int n) {
		int count = 0;
		while (n != 0) {
			count = count + (n & 1);
			n = n >>> 1;
		}
		return count;
	}

}

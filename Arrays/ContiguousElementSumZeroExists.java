package com.academy.app.array.examples;

import java.util.HashSet;
import java.util.Set;

/*
 * Check if Contiguous subset whose sum is Zero exists or not. 
 * Input: {5,1,2,-3,7,-4}
 * Output: True because Contiguous subset {1,2,-3} OR {-3,7,-4}
 */
public class ContiguousElementSumZeroExists {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, -3, 7, -4 };

		boolean isSumZero = sumZero(arr);
		print(arr);
		if (isSumZero) {
			System.out.println("Contiguous Subset Sum Zero found");
		}
		else {
			System.out.println("No Contiguous Subset Sum Zero found");
		}
	}

	private static boolean sumZero(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (set.contains(sum)) {
				return true;
			}
			set.add(sum);
		}
		return false;
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

}

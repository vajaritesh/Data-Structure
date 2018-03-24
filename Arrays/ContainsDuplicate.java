package com.academy.app.array.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and
 * it should return false if every element is distinct.
 * 
 *  input: {10,5,2}
 *  output: false
 *  input: {1,5,2,1}
 *  output: true
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 11, 10 };
		if (anyDuplicateByHashSetLength(arr)) {
			System.out.println("Array contains duplicate");
		}
		else {
			System.out.println("No duplicate found");
		}
		if (anyDuplicateByHashSet(arr)) {
			System.out.println("Array contains duplicate");
		}
		else {
			System.out.println("No duplicate found");
		}
		if (anyDuplicate(arr)) {
			System.out.println("Array contains duplicate");
		}
		else {
			System.out.println("No duplicate found");
		}
	}

	private static boolean anyDuplicate(int[] arr) {
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				return true;
			}
		}
		return false;
	}

	private static boolean anyDuplicateByHashSetLength(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		return set.size() != arr.length;
	}

	private static boolean anyDuplicateByHashSet(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				return true;
			}
			set.add(arr[i]);
		}
		return false;
	}

}

package com.academy.app.array.examples;

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * input arr1 = {2, 6, 9, 0, 0}, arr2={1,19}
 * output arr = {1, 2, 6, 9, 19}
 * 
 */
public class MergedTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 2, 6, 9, 0, 0 };
		int[] arr2 = { 1, 19 };
		mergeSort(arr1, arr2);
		print(arr1);
	}

	private static void mergeSort(int[] arr1, int[] arr2) {
		int end1 = arr1.length - arr2.length - 1;
		int end2 = arr2.length - 1;
		int lastIndex = arr1.length - 1;
		while (end1 >= 0 && end2 >= 0) {
			if (arr1[end1] > arr2[end2]) {
				arr1[lastIndex--] = arr1[end1];
				end1--;
			}
			else {
				arr1[lastIndex--] = arr2[end2];
				end2--;
			}
		}
		while (end1 >= 0) {
			arr1[lastIndex--] = arr1[end1--];
		}
		while (end2 >= 0) {
			arr1[lastIndex--] = arr2[end2--];
		}
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

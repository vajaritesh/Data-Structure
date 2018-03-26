package com.academy.app.array.examples;

/*
 * Find the median of the two sorted arrays.
 * There are two sorted arrays A and B of size m and n respectively. 
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3 };
		int[] arr2 = { 2 };
		double median = findMedian(arr1, arr2);
		System.out.println(median);
	}

	private static double findMedian(int[] arr1, int[] arr2) {
		int total = arr1.length + arr2.length;
		if (total % 2 == 0) {
			return (findKthMedian(total / 2 + 1, arr1, arr2, 0, 0) + findKthMedian(total / 2, arr1, arr2, 0, 0) / 2.0);
		}
		else {
			return findKthMedian(total / 2 + 1, arr1, arr2, 0, 0);
		}
	}

	private static int findKthMedian(int k, int[] arr1, int[] arr2, int s1, int s2) {
		if (s1 >= arr1.length) {
			return arr2[s2 + k - 1];
		}
		if (s2 >= arr2.length) {
			return arr1[s1 + k - 1];
		}
		if (k == 1) {
			return Math.min(arr1[s1], arr2[s2]);
		}
		int m1 = s1 + k / 2 - 1;
		int m2 = s2 + k / 2 - 1;
		int mid1 = m1 < arr1.length ? arr1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < arr2.length ? arr2[m2] : Integer.MAX_VALUE;
		if (mid1 < mid2) {
			return findKthMedian(k - k / 2, arr1, arr2, m1 + 1, s2);
		}
		else {
			return findKthMedian(k - k / 2, arr1, arr2, s1, m2 + 1);
		}
	}

}

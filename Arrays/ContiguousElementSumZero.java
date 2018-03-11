package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Find Contiguous subset whose sum is Zero. 
 * Input: {5,1,2,-3,7,-4}
 * Output: Contiguous subset {1,2,-3} OR {-3,7,-4} return anyone
 */
public class ContiguousElementSumZero {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, -3, 7, -4 };

		List<List<Integer>> results = sumZero(arr);
		print(arr);
		System.out.println("Contiguous Subset Sum Zero:");
		print(results);
	}

	private static List<List<Integer>> sumZero(int[] arr) {
		int end = arr.length;
		int left = 0;
		List<List<Integer>> lists = new ArrayList<List<Integer>>();

		int sum = 0;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		while (left < end) {
			sum += arr[left];
			queue.add(arr[left]);
			if (arr[left] < 0) {
				while (queue.size() > 1 && sum != 0) {
					sum -= queue.poll();
				}
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					while (!queue.isEmpty()) {
						list.add(queue.poll());
					}
					lists.add(list);
				}
			}
			left++;
		}
		return lists;
	}

	private static void print(List<List<Integer>> results) {
		for (List<Integer> result : results) {
			System.out.println(result);
		}
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

}

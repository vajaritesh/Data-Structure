package com.academy.app.array.examples;

/*
 * Merge Overlapping Intervals using 2D array
 * Input: { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } }
 * Output: {{1,4},{5,8}}
 */
public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		// int[][] intervals = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		int[][] intervals = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };
		int[][] overlappingIntervals = mergeOverlappingInterval(intervals);
		print(intervals);
		print(overlappingIntervals);
	}

	private static int[][] mergeOverlappingInterval(int[][] intervals) {
		sortIntervals(intervals);
		int size = intervals.length - 1;
		int[][] result = new int[size][2];
		int j;
		int index = 0;
		for (int i = 0; i < intervals.length; i++) {
			j = i + 1;
			while (j <= size && intervals[i][1] > intervals[j][0]) {
				j++;
			}
			j--;
			merge(result, index, intervals, i, j);
			i = j;
			index++;
		}
		return result;
	}

	private static void merge(int[][] result, int index, int[][] intervals, int i, int j) {
		result[index][0] = intervals[i][0];
		result[index][1] = Math.max(intervals[i][1], intervals[j][1]);
	}

	private static void sortIntervals(int[][] intervals) {
		quickSort(intervals, 0, intervals.length - 1);
	}

	private static void quickSort(int[][] intervals, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = intervals[left][0];
		int pi = partition(intervals, left, right, pivot);
		quickSort(intervals, left, pi - 1);
		quickSort(intervals, pi, right);
	}

	private static int partition(int[][] intervals, int left, int right, int pivot) {
		while (left <= right) {
			while (intervals[left][0] < pivot) {
				left++;
			}
			while (intervals[right][0] > pivot) {
				right--;
			}
			if (left <= right) {
				int[] temp = intervals[left];
				intervals[left] = intervals[right];
				intervals[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}

	private static void print(int[][] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			System.out.print("{" + intervals[i][0] + "," + intervals[i][1] + "}" + ",");
		}
		System.out.println();
	}

}

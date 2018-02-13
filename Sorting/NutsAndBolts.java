package com.academy.sorting.homework;


/*
 * There are equal numbers of nuts and bolts given. Write algorithm to match each nuts with its matching bolts.
 *  input = nuts [N3, N2, N1, N4] bolts [B4, B1, B3, B2]
 *  output = [N1B1, N2B2, N3B3, N4B4] 
 * 
 */
public class NutsAndBolts {

	public static void main(String[] args) {
		String[] nuts = { "N3", "N2", "N1", "N4" };
		String[] bolts = { "B4", "B2", "B3", "B1" };
		matchNutsWithBolts(nuts, bolts);
		print(nuts, bolts);
	}

	private static void print(String[] nuts, String[] bolts) {
		for (int index = 0; index < nuts.length; index++) {
			System.out.println(nuts[index] + " " + bolts[index]);
		}
	}

	private static void matchNutsWithBolts(String[] nuts, String[] bolts) {
		matchPairs(nuts, bolts, 0, nuts.length - 1);
	}

	private static void matchPairs(String[] nuts, String[] bolts, int low, int high) {
		if (low < high) {
			int pivot = pairPartition(nuts, low, high, bolts[high]);
			pairPartition(bolts, low, high, nuts[pivot]);
			matchPairs(nuts, bolts, low, pivot - 1);
			matchPairs(nuts, bolts, pivot + 1, high);
		}
	}

	private static int pairPartition(String[] arr, int low, int high, String pivot) {
		int left = low;
		String temp1, temp2;
		char[] pivotArr = pivot.toCharArray();
		for (int index = low; index < high; index++) {
			char[] charArr = arr[index].toCharArray();
			if (charArr[1] < pivotArr[1]) {
				temp1 = arr[left];
				arr[left] = arr[index];
				arr[index] = temp1;
			}
			else if (charArr[1] == pivotArr[1]) {
				temp2 = arr[index];
				arr[index] = arr[high];
				arr[high] = temp2;
			}
		}
		temp2 = arr[left];
		arr[left] = arr[high];
		arr[high] = temp2;
		return left;
	}
}

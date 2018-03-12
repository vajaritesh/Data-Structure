package com.academy.app.array.examples;

/*
 * Given an array, convert to alternating +ve and -ve numbers. With And Without Space
 * input = {2, 3, -4, -9, -1, -7, 1, -5, -6}
 * output = {2,-4,3,-9,1,-1,-7,-5,-6}
 */
public class AlternatingPositiveNegativeNumbers {

	public static void main(String[] args) {
		// int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
		// int[] arr1 = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
		int[] arr = { 2, 3, -4, -9, -1, -7, 1, -5, -6 };
		int[] arr1 = { 2, 3, -4, -9, -1, -7, 1, -5, -6 };
		print(arr);

		alternatingPositiveNegativeNumberWithExtraSpace(arr);
		print(arr);

		alternatingPositiveNegativeNumberWithoutExtraSpace(arr1);
		print(arr1);
	}

	private static void alternatingPositiveNegativeNumberWithoutExtraSpace(int[] arr) {
		int len = arr.length;
		int sign = 1;
		int temp;
		int i;
		for (i = 0; i < len; i++) {
			if (sign > 0) {
				if (arr[i] < 0) {
					int pIndex = findPositive(arr, i);
					if (pIndex > 0) {
						temp = arr[pIndex];
						moveElement(arr, i, pIndex);
						arr[i] = temp;
					}
					else {
						break;
					}
				}
				sign = -1;
			}
			else {
				if (arr[i] > 0) {
					int nIndex = findNegative(arr, i);
					if (nIndex > 0) {
						temp = arr[nIndex];
						moveElement(arr, i, nIndex);
						arr[i] = temp;
					}
					else {
						break;
					}
				}
				sign = 1;
			}
		}
	}

	private static void moveElement(int[] arr, int i, int j) {
		while (j >= i && j > 0) {
			arr[j] = arr[j - 1];
			j--;
		}
	}

	private static int findNegative(int[] arr, int i) {
		while (i < arr.length) {
			if (arr[i] < 0) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private static int findPositive(int[] arr, int i) {
		while (i < arr.length) {
			if (arr[i] > 0) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private static void alternatingPositiveNegativeNumberWithExtraSpace(int[] arr) {
		int[] positiveArr = new int[arr.length];
		int[] negativeArr = new int[arr.length];
		int posIndex = 0;
		int negIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0) {
				positiveArr[posIndex++] = arr[i];
			}
			else {
				negativeArr[negIndex++] = arr[i];
			}
		}

		int len = Math.min(posIndex, negIndex);
		int pos = 0;
		int neg = 0;
		int i = 0;
		while (i < len * 2) {
			arr[i] = positiveArr[pos++];
			posIndex--;
			i++;
			if (i < len * 2) {
				arr[i] = negativeArr[neg++];
				i++;
				negIndex--;
			}

		}
		while (posIndex > 0) {
			arr[i++] = positiveArr[pos++];
			posIndex--;
		}
		while (negIndex > 0) {
			arr[i++] = negativeArr[neg++];
			negIndex--;
		}
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}

}

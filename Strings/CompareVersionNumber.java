package com.academy.string;

/*
 * Compare Version Numbers
 * Compare two version numbers version1 and version2. 
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 */
public class CompareVersionNumber {

	public static void main(String[] args) {
		String version1 = "1.0";
		String version2 = "1";
		int result = compareVersion(version1, version2);
		System.out.println(result);
	}

	public static int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");

		int i = 0;
		while (i < arr1.length || i < arr2.length) {
			if (i < arr1.length && i < arr2.length) {
				if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
					return -1;
				}
				else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
					return 1;
				}
			}
			else if (i < arr1.length) {
				if (Integer.parseInt(arr1[i]) != 0) {
					return 1;
				}
			}
			else if (i < arr2.length) {
				if (Integer.parseInt(arr2[i]) != 0) {
					return -1;
				}
			}

			i++;
		}

		return 0;
	}

}

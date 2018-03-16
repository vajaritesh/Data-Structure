package com.academy.app.array.examples;

// http://www.ardendertat.com/2011/12/01/programming-interview-questions-19-find-next-palindrome-number/
/*
 * For a given integer number N. Find the Next smallest Palindromic number which is larger than original number N
 * Odd N:
 * input: 250 => 252
 * input: 123 -> 121=>131
 * input: 397 => 393->400=>404
 * Even N:
 * input: 4512 => 4554
 * input: 1234 -> 1221 => 1331
 * input: 1997 -> 1991 -> 2000 => 2002
 */
public class NextPalindromicNumber {

	public static void main(String[] args) {
		// int num = 1997;
		int[] numArr = new int[6];
		numArr[0] = 250;
		numArr[1] = 123;
		numArr[2] = 237;
		numArr[3] = 4512;
		numArr[4] = 1234;
		numArr[5] = 1997;
		for (int i = 0; i < numArr.length; i++) {
			long nextPalinNum = next_palindrome(numArr[i]);
			System.out.println(numArr[i] + " => " + nextPalinNum);
		}

	}

	static long next_palindrome(int n) {
		String nStr = String.valueOf(n);
		String newStr;

		int length = nStr.length();
		String leftHalf = getLeftHalf(nStr);
		String middle = getMiddle(nStr);
		String leftHalfReverse = reverse(leftHalf);
		boolean isOdd = (length % 2 == 0) ? false : true;
		int increment;
		if (isOdd) {
			increment = (int) Math.pow(10, length / 2);
			newStr = leftHalf + middle + leftHalfReverse;
		}
		else {
			increment = (int) (1.1 * Math.pow(10, length / 2));
			newStr = leftHalf + leftHalfReverse;
		}
		if (newStr.compareTo(nStr) > 0) {
			return Integer.parseInt(newStr);
		}
		if (!newStr.contains("9")) {
			return Integer.parseInt(newStr) + increment;
		}
		else {
			return next_palindrome(roundUp(newStr));
		}
	}

	static int roundUp(String numStr) {
		int num = Integer.parseInt(numStr);
		int len = numStr.length();
		int increment = (int) Math.pow(10, len / 2 + 1);
		int result = num / increment + 1;
		return result * increment;
	}

	static String reverse(String numStr) {
		return new StringBuilder(numStr).reverse().toString();
	}

	static String getLeftHalf(String numStr) {
		return numStr.substring(0, numStr.length() / 2);
	}

	static String getMiddle(String numStr) {
		int len = numStr.length();
		if (len % 2 == 0) {
			return numStr.substring(len / 2 - 1, len / 2 + 1);
		}
		return numStr.substring(len / 2, len / 2 + 1);
	}

}

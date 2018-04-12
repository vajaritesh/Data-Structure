package com.academy.string;

/*
 * Add binary.
 * Given two binary strings, return their sum (also a binary string).
 * a = "11" and b = "1"
 * Return "100".
 */
public class AddBinary {

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}

	private static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int aLen = a.length() - 1;
		int bLen = b.length() - 1;
		int carry = 0;
		int sum = 0;
		while (aLen >= 0 || bLen >= 0) {
			sum = carry;
			if (aLen >= 0) {
				sum += a.charAt(aLen--) - '0';
			}
			if (bLen >= 0) {
				sum += b.charAt(bLen--) - '0';
			}
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

}

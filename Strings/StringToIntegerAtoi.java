package com.academy.string.Aeasy;

/*
 * String to Integer (atoi)
 * Implement atoi to convert a string to an integer.
 * 	1. null or empty string
 *	2. white spaces
 *	3. +/- sign
 *	4. calculate real value
 *	5. handle min & max 
 */
public class StringToIntegerAtoi {

	public static void main(String[] args) {
		String str = "123";
		int strInt = atoi(str);
		System.out.println(strInt);
	}

	private static int atoi(String str) {
		if (str == null || str.length() < 1) {
			return 0;
		}
		str = str.trim();
		int sign = 1;
		int i = 0;
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			sign = str.charAt(i++) == '-' ? -1 : 1;
		}
		int result = 0;
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		result = result * sign;
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return result;
	}

}

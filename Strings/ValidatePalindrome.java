package com.academy.string;

/*
 * Validate Palindrome
 */
public class ValidatePalindrome {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		if (isPalindrome(str)) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}

	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		return validate(s.toLowerCase(), 0, s.length() - 1);
	}

	private static boolean validate(String s, int start, int end) {
		while (start <= end) {
			boolean startAlphaNum = isAlphNumeric(s.charAt(start));
			boolean endAlphaNum = isAlphNumeric(s.charAt(end));
			if (!startAlphaNum || !endAlphaNum) {
				if (!startAlphaNum) {
					start++;
				}
				if (!endAlphaNum) {
					end--;
				}
			}
			else if (startAlphaNum && endAlphaNum && s.charAt(start) != s.charAt(end)) {
				return false;
			}
			else {
				start++;
				end--;
			}
		}
		return true;
	}

	private static boolean isAlphNumeric(char ch) {
		if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) || (ch >= '0' && ch <= '9')) {
			return true;
		}
		return false;
	}

}

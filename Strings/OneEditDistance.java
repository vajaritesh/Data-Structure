package com.academy.string.easy;

/*
 * One Edit Distance
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {

	public static void main(String[] args) {
		String s = "creek";
		String t = "creak";
		if (isOneEditDistance(s, t)) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}

	private static boolean isOneEditDistance(String s, String t) {
		int slen = s.length();
		int tlen = t.length();
		if (Math.abs(slen - tlen) > 1) {
			return false;
		}
		int sIndex = 0;
		int tIndex = 0;
		int diff = 0;
		while (sIndex < slen && tIndex < tlen) {
			if (s.charAt(sIndex) == t.charAt(tIndex)) {
				sIndex++;
				tIndex++;
			}
			else {
				diff++;
				if (diff > 1) {
					return false;
				}
				if (slen > tlen) {
					sIndex++;
				}
				else if (slen < tlen) {
					tIndex++;
				}
				else {
					sIndex++;
					tIndex++;
				}
			}
		}

		if (sIndex < slen || tIndex < tlen) {
			diff++;
		}

		if (diff == 1) {
			return true;
		}

		return false;
	}

}

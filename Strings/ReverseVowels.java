package com.academy.string.Aeasy;

import java.util.HashSet;
import java.util.Set;

/*
 * Reverse Vowels of a String 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 */
public class ReverseVowels {

	public static void main(String[] args) {
		String str = "hello";
		String result = reverseVowels(str);
		System.out.println(result);
	}

	public static String reverseVowels(String s) {
		Set<Character> vowList = new HashSet<Character>();
		vowList.add('a');
		vowList.add('e');
		vowList.add('i');
		vowList.add('o');
		vowList.add('u');
		vowList.add('A');
		vowList.add('E');
		vowList.add('I');
		vowList.add('O');
		vowList.add('U');

		char[] arr = s.toCharArray();

		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			if (!vowList.contains(arr[i])) {
				i++;
				continue;
			}

			if (!vowList.contains(arr[j])) {
				j--;
				continue;
			}

			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;

			i++;
			j--;
		}

		return new String(arr);
	}
}

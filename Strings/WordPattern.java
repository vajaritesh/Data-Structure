package com.academy.string.Aeasy;

import java.util.HashMap;
import java.util.Map;

/*
 * Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern. 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 1. pattern = "abba", str = "dog cat cat dog" should return true.
 * 2. pattern = "abba", str = "dog cat cat fish" should return false.
 */
public class WordPattern {

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		if (wordPattern(pattern, str)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}

		if (wordPatternOptimize(pattern, str)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}

	}

	public static boolean wordPattern(String pattern, String str) {
		Map<Character, String> patternMap = new HashMap<Character, String>();
		Map<String, Character> strMap = new HashMap<String, Character>();
		int patternLen = pattern.length();
		String[] strArr = str.split(" ");
		int strLen = strArr.length;
		if (patternLen != strLen) {
			return false;
		}
		for (int i = 0; i < patternLen; i++) {
			if (!patternMap.containsKey(pattern.charAt(i))) {
				if (strMap.containsKey(strArr[i])) {
					return false;
				}
				patternMap.put(pattern.charAt(i), strArr[i]);
				strMap.put(strArr[i], pattern.charAt(i));
			}
			else if (!patternMap.get(pattern.charAt(i)).equals(strArr[i])) {
				return false;
			}

		}
		return true;
	}

	public static boolean wordPatternOptimize(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map index = new HashMap();
		for (Integer i = 0; i < words.length; ++i)
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
				return false;
		return true;
	}
}

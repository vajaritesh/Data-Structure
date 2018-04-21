package com.academy.string.Amedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * Input:Digit string "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		String str = "23";
		List<String> output = letterCombinations(str);
		System.out.println(output);
		List<String> output1 = letterCombinations1(str);
		System.out.println(output1);
		List<String> output2 = letterCombinations2(str);
		System.out.println(output2);
	}

	// Method 1: DFS - Using Map<Integer, String>
	public static List<String> letterCombinations(String digits) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");

		List<String> result = new ArrayList<String>();

		if (digits == null || digits.length() == 0)
			return result;

		List<Character> temp = new ArrayList<Character>();
		getString(digits, temp, result, map);

		return result;
	}

	public static void getString(String digits, List<Character> temp, List<String> result, Map<Integer, String> map) {
		if (digits.length() == 0) {
			char[] arr = new char[temp.size()];
			for (int i = 0; i < temp.size(); i++) {
				arr[i] = temp.get(i);
			}
			result.add(String.valueOf(arr));
			return;
		}

		Integer curr = Integer.valueOf(digits.substring(0, 1));
		String letters = map.get(curr);
		for (int i = 0; i < letters.length(); i++) {
			temp.add(letters.charAt(i));
			getString(digits.substring(1), temp, result, map);
			temp.remove(temp.size() - 1);
		}
	}

	// Method 2: DFS - Using Map<Integer, char[]> and StringBuilder
	public static List<String> letterCombinations1(String digits) {
		HashMap<Character, char[]> map = new HashMap<Character, char[]>();
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });

		List<String> result = new ArrayList<String>();
		if (digits.equals(""))
			return result;

		helper(result, new StringBuilder(), digits, 0, map);

		return result;

	}

	public static void helper(List<String> result, StringBuilder sb, String digits, int index,
	        HashMap<Character, char[]> map) {
		if (index >= digits.length()) {
			result.add(sb.toString());
			return;
		}

		char c = digits.charAt(index);
		char[] arr = map.get(c);

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			helper(result, sb, digits, index + 1, map);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	// Method 3: DFS - Map<Integer, char[]> and arr
	public static List<String> letterCombinations2(String digits) {
		HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
		dict.put('2', new char[] { 'a', 'b', 'c' });
		dict.put('3', new char[] { 'd', 'e', 'f' });
		dict.put('4', new char[] { 'g', 'h', 'i' });
		dict.put('5', new char[] { 'j', 'k', 'l' });
		dict.put('6', new char[] { 'm', 'n', 'o' });
		dict.put('7', new char[] { 'p', 'q', 'r', 's' });
		dict.put('8', new char[] { 't', 'u', 'v' });
		dict.put('9', new char[] { 'w', 'x', 'y', 'z' });

		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		char[] arr = new char[digits.length()];
		helper(digits, 0, dict, result, arr);

		return result;
	}

	private static void helper(String digits, int index, HashMap<Character, char[]> dict, List<String> result,
	        char[] arr) {
		if (index == digits.length()) {
			result.add(new String(arr));
			return;
		}

		char number = digits.charAt(index);
		char[] candidates = dict.get(number);
		for (int i = 0; i < candidates.length; i++) {
			arr[index] = candidates[i];
			helper(digits, index + 1, dict, result, arr);
		}
	}

}

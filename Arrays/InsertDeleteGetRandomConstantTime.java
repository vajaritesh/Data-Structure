package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * Insert Delete GetRandom O(1) - Without Duplicates
 * 
 */
public class InsertDeleteGetRandomConstantTime {
	Map<Integer, Integer> map;
	List<Integer> arr;
	Random rand = new Random();

	InsertDeleteGetRandomConstantTime() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> arr = new ArrayList<Integer>();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, arr.size());
		arr.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		int lastIndex = arr.size() - 1;
		if (index < lastIndex) {
			int lastValue = arr.get(lastIndex);
			arr.set(index, lastValue);
			map.put(lastValue, index);
		}
		map.remove(val);
		arr.remove(lastIndex);
		return true;
	}

	public int getRandom() {
		return arr.get(rand.nextInt(arr.size()));
	}

	public static void main(String[] args) {

	}

}

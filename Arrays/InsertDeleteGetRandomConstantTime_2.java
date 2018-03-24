package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 * Insert Delete GetRandom O(1) - With Duplicates
 * 
 */
public class InsertDeleteGetRandomConstantTime_2 {

	List<Integer> arr;
	Map<Integer, Set<Integer>> map;
	Random rand = new Random();

	InsertDeleteGetRandomConstantTime_2() {
		arr = new ArrayList<Integer>();
		map = new HashMap<Integer, Set<Integer>>();
	}

	public boolean insert(int val) {

		if (!map.containsKey(val)) {
			map.put(val, new HashSet<Integer>());
		}
		Set<Integer> set = map.get(val);
		set.add(arr.size());
		arr.add(val);
		map.put(val, set);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		Set<Integer> set = map.get(val);
		int index = set.iterator().next();
		int lastIndex = arr.size() - 1;
		if (index < lastIndex) {
			int lastValue = arr.get(lastIndex);
			arr.set(index, lastValue);
			map.get(lastValue).remove(lastIndex);
			map.get(lastValue).add(index);
		}
		arr.remove(lastIndex);
		if (map.get(val).isEmpty()) {
			map.remove(val);
		}
		return true;
	}

	public int getRandom() {
		return arr.get(rand.nextInt(arr.size()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

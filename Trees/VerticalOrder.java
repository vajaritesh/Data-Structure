package com.academy.binarytree.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Vertical Order Traversal
 */
public class VerticalOrder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		verticalIterative(root);
	}

	private static void verticalIterative(TreeNode root) {

		if (root == null) {
			return;
		}
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		helper(root, map, 0);
		for (Integer col : map.keySet()) {
			System.out.println(map.get(col));
		}
	}

	private static void helper(TreeNode root, Map<Integer, List<Integer>> map, int col) {
		if (root.left != null) {
			helper(root.left, map, col - 1);
		}
		if (root.right != null) {
			helper(root.right, map, col + 1);
		}
		if (map.containsKey(col)) {
			map.get(col).add(root.val);
		}
		else {
			List<Integer> tempList = new ArrayList<Integer>();
			tempList.add(root.val);
			map.put(col, tempList);
		}
	}
}

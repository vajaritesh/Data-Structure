package com.academy.binarytree.examples;

import java.util.ArrayList;
import java.util.List;

/*
 * Find Leaves of Binary Tree
 */
public class FindLeaves {
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
		// root.right.left = new TreeNode(6);
		List<List<Integer>> result = findLeaves(root);
		print(result);
	}

	private static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(root, result);
		return result;
	}

	private static int helper(TreeNode root, List<List<Integer>> result) {
		if (root == null) {
			return -1;
		}
		int left = helper(root.left, result);
		int right = helper(root.right, result);
		int curr = Math.max(left, right) + 1;
		if (result.size() <= curr) {
			result.add(new ArrayList<Integer>());
		}
		result.get(curr).add(root.val);
		return curr;
	}

	private static void print(List<List<Integer>> result) {
		for (List<Integer> list : result) {
			System.out.println(list);
		}

	}
}

package com.academy.binarytree.examples;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
 * 
 */
public class PathSum2 {
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
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		int sum = 8;

		List<List<Integer>> result = pathSum(root, sum);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

	private static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<Integer> tempList = new ArrayList<Integer>();
		tempList.add(root.val);
		helper(root, result, tempList, sum - root.val);
		return result;
	}

	private static void helper(TreeNode root, List<List<Integer>> result, List<Integer> tempList, int sum) {
		if (root.left == null && root.right == null && sum == 0) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}

		if (root.left != null) {
			tempList.add(root.left.val);
			helper(root.left, result, tempList, sum - root.left.val);
			tempList.remove(tempList.size() - 1);
		}
		if (root.right != null) {
			tempList.add(root.right.val);
			helper(root.right, result, tempList, sum - root.right.val);
			tempList.remove(tempList.size() - 1);
		}

	}

}

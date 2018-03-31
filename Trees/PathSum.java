package com.academy.binarytree.examples;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum {
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
		root.right.right = new TreeNode(6);
		int sum = 4;
		if (pathSumRec(root, sum)) {
			System.out.println("Path exits");
		}
		else {
			System.out.println("Path not exits");
		}

		if (pathSumIterative(root, sum)) {
			System.out.println("Path exits");
		}
		else {
			System.out.println("Path not exits");
		}
	}

	private static boolean pathSumRec(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.val == sum && root.left == null && root.right == null) {
			return true;
		}
		return pathSumRec(root.left, sum - root.val) || pathSumRec(root.right, sum - root.val);
	}

	private static boolean pathSumIterative(TreeNode root, int add) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> sum = new LinkedList<Integer>();
		if (root != null) {
			queue.add(root);
			sum.add(root.val);
		}
		int total = 0;
		while (!queue.isEmpty()) {
			TreeNode top = queue.poll();
			total = sum.poll();
			if (top.left == null && top.right == null && total == add) {
				return true;
			}
			if (top.left != null) {
				queue.add(top.left);
				sum.add(total + top.left.val);
			}
			if (top.right != null) {
				queue.add(top.right);
				sum.add(total + top.right.val);
			}
		}
		return false;
	}

}

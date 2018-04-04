package com.academy.binarytree.examples;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Minimum Depth of Binary Tree
 */
public class MinimumDepth {

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
		// root.right.right = new TreeNode(6);
		int min = minDepthRec(root);
		System.out.println(min);
		int minDepth = minDepthIterative(root);
		System.out.println(minDepth);
	}

	private static int minDepthRec(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepthRec(root.left);
		int right = minDepthRec(root.right);
		if (left == 0 || right == 0) {
			return left + right + 1;
		}
		else {
			return Math.min(left, right) + 1;
		}
	}

	private static int minDepthIterative(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> counts = new LinkedList<Integer>();
		if (root != null) {
			queue.add(root);
			counts.add(1);
		}
		while (!queue.isEmpty()) {
			TreeNode top = queue.poll();
			int count = counts.remove();
			if (top.left == null && top.right == null) {
				return count;
			}
			if (top.left != null) {
				queue.add(top.left);
				counts.add(count + 1);
			}
			if (top.right != null) {
				queue.add(top.right);
				counts.add(count + 1);
			}
		}
		return 0;
	}

}

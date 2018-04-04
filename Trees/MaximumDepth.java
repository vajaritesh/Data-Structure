package com.academy.binarytree.examples;

/*
 * Maximum Depth of Binary Tree
 */
public class MaximumDepth {

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
		// root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// root.right.right = new TreeNode(6);
		int max = maxDepthRec(root);
		System.out.println(max);

		int max1 = maxDepthRec1(root);
		System.out.println(max1);

		// int minDepth = minDepthIterative(root);
		// System.out.println(minDepth);
	}

	private static int maxDepthRec(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepthRec(root.left);
		int right = maxDepthRec(root.right);
		if (left == 0 || right == 0) {
			return left + right + 1;
		}
		else {
			return Math.max(left, right) + 1;
		}
	}

	private static int maxDepthRec1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepthRec1(root.left), maxDepthRec1(root.right)) + 1;
	}

}

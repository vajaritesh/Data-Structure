package com.academy.binarytree.examples;


/*
 * Binary Tree Longest Consecutive Sequence 
 * Given a binary tree, find the length of the longest consecutive sequence path.
 */
public class LongestConsecutiveSequence {
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
		TreeNode root = new TreeNode(6);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(10);
		root.right.right.right = new TreeNode(11);

		int length = findLongestConsecutiveSequenceLength(root);
		System.out.println(length);
	}

	private static int findLongestConsecutiveSequenceLength(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return recursiveHelper(root, null, 0);
	}

	private static int recursiveHelper(TreeNode root, TreeNode parent, int depth) {

		if (root == null) {
			return 0;
		}
		int currDepth = 0;
		if (parent != null) {
			currDepth = depth + 1;
		}
		else {
			currDepth = 1;
		}
		return Math.max(currDepth,
		        Math.max(recursiveHelper(root.left, root, currDepth), recursiveHelper(root.right, root, currDepth)));
	}

}

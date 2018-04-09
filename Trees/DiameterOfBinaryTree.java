package com.academy.binarytree.examples;

/*
 * Diameter of Binary Tree
 */
public class DiameterOfBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}

	static class Height {
		int h;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		int diameter = findDiameter(root);
		System.out.println(diameter);

		int d = diameterOptimzed(root);
		System.out.println(d);
	}

	// Time O(n^2)
	private static int findDiameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		int leftDiameter = findDiameter(root.left);
		int rightDiameter = findDiameter(root.right);

		int fd = Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
		return fd;
	}

	private static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	// Time O(n)
	private static int diameterOptimzed(TreeNode root) {
		Height height = new Height();
		return diameterOpt(root, height);
	}

	private static int diameterOpt(TreeNode root, Height height) {
		Height lh = new Height(), rh = new Height();
		if (root == null) {
			height.h = 0;
			return 0;
		}
		lh.h++;
		rh.h++;

		int leftDiameter = diameterOpt(root.left, lh);
		int rightDiameter = diameterOpt(root.right, rh);

		height.h = Math.max(lh.h, rh.h) + 1;

		return Math.max(lh.h + rh.h + 1, Math.max(leftDiameter, rightDiameter));
	}

}

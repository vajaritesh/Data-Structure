package com.academy.binarytree.examples;

/*
 * Validate BST
 */
public class ValidateBST {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(15);

		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(9);

		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(17);

		if (validateBST(root)) {
			System.out.println("Tree is valid BST");
		}
		else {
			System.out.println("Tree is not valid BST");
		}
	}

	private static boolean validateBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValid(TreeNode root, int min, int max) {
		if (root.data < min || root.data > max) {
			return false;
		}
		if (root.left != null && !isValid(root.left, root.data, max)) {
			return false;
		}
		if (root.right != null && !isValid(root.right, min, root.data)) {
			return false;
		}

		return true;
	}

}

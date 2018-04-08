package com.academy.binarytree.examples;

/*
 * Populating Next Right Pointers in Each Node
 * With Constance space
 * With Perfect Binary Tree (Full Tree)
 */
public class PopulatingNextRight {

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

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		nextRight(root);

	}

	private static void nextRight(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.right != null) {
			if (root.next != null) {
				root.right.next = root.next.left;
			}
			else {
				root.right.next = null;
			}
		}
		nextRight(root.left);
		nextRight(root.right);
	}

}

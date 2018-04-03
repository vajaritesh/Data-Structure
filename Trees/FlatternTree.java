package com.academy.binarytree.examples;

import java.util.Stack;

/*
 * Flatten Binary Tree to Linked List
 */
public class FlatternTree {

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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		flatternTree(root);
		print(root);
	}

	private static void flatternTree(TreeNode root) {

		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				root.right = root.left;
				root.left = null;
			}
			else {
				if (!stack.isEmpty()) {
					root.right = stack.pop();
				}
			}
			root = root.right;
		}

	}

	private static void print(TreeNode root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}
	}

}

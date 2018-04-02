package com.academy.binarytree.examples;

import java.util.Stack;

/*
 * PreOrder Traversal
 */
public class PreOrder {
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
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		printPreOrderRec(root);
		System.out.println();
		printPreOrderIterative(root);
	}

	private static void printPreOrderRec(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printPreOrderRec(root.left);
		printPreOrderRec(root.right);
	}

	private static void printPreOrderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			TreeNode top = stack.pop();
			System.out.print(top.data + " ");
			if (top.right != null) {
				stack.push(top.right);
			}
			if (top.left != null) {
				stack.push(top.left);
			}
		}
	}

}
